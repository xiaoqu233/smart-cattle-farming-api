package com.jhd.scf.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jhd.scf.entity.User;
import com.jhd.scf.entity.UserPwd;
import com.jhd.scf.feign.SystemFeign;
import com.jhd.scf.mapper.UserMapper;
import com.jhd.scf.mapper.UserPwdMapper;
import com.jhd.scf.mapper.UserRoleMapper;
import com.jhd.scf.service.UserRoleService;
import com.jhd.scf.service.UserService;
import com.jhd.scf.utils.Res;
import com.jhd.scf.vo.AccountVO;
import com.jhd.scf.vo.LoginInfoVO;
import com.jhd.scf.vo.UserVO;
import com.jhd.scf.vo.query.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 用户Service业务层
 *
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPwdMapper userPwdMapper;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private SystemFeign systemFeign;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户查询
     *
     * @param query
     * @return
     */
    @Override
    public Res query(UserQuery query) {
        IPage<User> data = userMapper.query(Page.of(query.getPage(), query.getSize()), query);
        return Res.success(data);
    }

    /**
     * 添加用户
     *
     * @param userVO
     * @return
     */
    @Override
    @Transactional
    public Res save(UserVO userVO) {
        BeanCopier copier = BeanCopier.create(UserVO.class, User.class, false);

        User user = User.builder().build();
        copier.copy(userVO, user, null);
        user.setEntryTime(new Date());
        user.setCreateTime(new Date());

        userMapper.insert(user);

        String salt = RandomUtil.randomString(8); // 生成密码盐
        String password = SaSecureUtil.aesEncrypt(salt, userVO.getPassword()); // 生成密码


        // 构建用户密码对象
        UserPwd userPwd = UserPwd.builder()
                .userId(user.getId())
                .pwd(password)
                .salt(salt)
                .build();

        userPwdMapper.insert(userPwd); // 插入用户密码数据

        // 添加角色
        userRoleService.save(userVO.getTenantId(), user.getId(), userVO.getRoleIds());

        return Res.success();
    }

    /**
     * 修改用户
     *
     * @param userVO
     * @return
     */
    @Override
    public Res update(UserVO userVO) {
        BeanCopier copier = BeanCopier.create(UserVO.class, User.class, false);

        User user = User.builder().build();
        copier.copy(user, user, null);
        user.setPhone(null);

        // 修改用户信息
        userMapper.updateById(user);
        // 设置角色
        userRoleService.save(userVO.getTenantId(), user.getId(), userVO.getRoleIds());

        return Res.success();
    }

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public Res delete(Long userId) {
        int del = userMapper.deleteById(userId);
        return del > 0 ? Res.success() : Res.error();
    }

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public Res getUserInfo(long userId) {
        HashMap<String, Object> map = new HashMap<>(3);

        // 查询用户信息
        User user = userMapper.selectById(userId);
        map.put("profilePicture", user.getProfilePicture());
        map.put("userName", user.getUserName());
        map.put("sex", user.getSex());

        return Res.success();
    }


    @Override
    public Res userRole(long userId) {
        // 查询用户拥有的角色 （返回的是角色id）
        List<Long> roleIds = userRoleMapper.selectByUserId(userId);

        // 远程调用（调用系统服务(system)，查询到用户拥有的权限(例如sys:user:list)）
        Res res = systemFeign.userPermission(roleIds);
        if (res.getCode() == 200) {
            redisTemplate.opsForValue().set("user:role:" + userId, JSON.toJSONString(res.getData()));
        }

        return res;
    }

    /**
     * 登录
     *
     * @param data
     * @return
     */
    @Override
    public Res login(AccountVO data) {
        // 查询用户信息
        User user = userMapper.selectByPhone(data.getAccount());
        if (Objects.isNull(user)) {
            return Res.error("用户不存在");
        }

        // 查询密码信息
        UserPwd userPwd = userPwdMapper.selectByUserId(user.getId());
        if (Objects.isNull(userPwd)) {
            return Res.error("密码不存在");
        }

        // 密码校验，用户输入的密码先进行加密和数据库中已加密的密码进行对比，相同则说明密码正确，反之密码错误
        String inputPassword = SaSecureUtil.aesEncrypt(userPwd.getSalt(), data.getPassword());
        if (!inputPassword.equals(userPwd.getPwd())) {
            return Res.error("密码错误");
        }

        StpUtil.logout(user.getId()); // sa-token框架方法，登录前先退出，调用此方法。redis会有很多登录数据
        StpUtil.login(user.getId());  // sa-token框架方法，调用登录方法

        LoginInfoVO vo = LoginInfoVO.builder()
                .userName(user.getUserName())
                .profilePicture(user.getProfilePicture())
                .accessToken(StpUtil.getTokenInfo().tokenValue) // 拿到sa-token框架登录用户的token信息
                .build();

        return Res.success(vo);
    }
}
