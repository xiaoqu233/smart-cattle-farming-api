package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jhd.scf.entity.OperationManual;
import com.jhd.scf.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 操作手册Mapper接口
 */

@Mapper
public interface OperationManualMapper extends BaseMapper<OperationManual> {
    /**
     * 查询操作手册
     *
     * @param page  分页对象
     * @param query 查询参数
     * @return
     */
    IPage<OperationManual> selectAll(Page<Object> page, @Param("query") BaseQuery query);

    /**
     * 根据手册id删除手册
     *
     * @param id 手册id
     * @return
     */
    int deleteById(@Param("id") Long id);
}