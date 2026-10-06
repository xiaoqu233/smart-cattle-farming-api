package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhd.scf.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门Mapper接口
 */

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * 部门查询
     *
     * @return
     */
    List<Dept> selectAll(@Param("name") String name);

    /**
     * 查询部门是否存在
     *
     * @param deptCode 部门编码
     * @param deptName 部门名称
     * @return 已存在的部门
     */
    List<Dept> deptExists(@Param("deptCode") String deptCode,
                          @Param("deptName") String deptName);

    /**
     * 根据部门id删除部门
     *
     * @param id 部门id
     * @return
     */
    int deleteById(@Param("id") Long id);
}