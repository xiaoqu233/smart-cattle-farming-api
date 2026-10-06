package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhd.scf.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 岗位Mapper接口
 */

@Mapper
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 岗位查询
     *
     * @param name
     * @return
     */
    List<Post> selectAll(@Param("name") String name);

    /**
     * 根据岗位编码或岗位名称检查岗位是否存在
     *
     * @param postCode
     * @param postName
     * @return
     */
    List<Post> postExists(@Param("postCode") String postCode, @Param("postName") String postName);

    /**
     * 删除岗位
     *
     * @param id 岗位id
     * @return
     */
    int deleteById(@Param("id") Long id);
}
