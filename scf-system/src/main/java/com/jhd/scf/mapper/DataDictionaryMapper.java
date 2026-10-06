package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jhd.scf.entity.DataDictionary;
import com.jhd.scf.entity.DataDictionaryItem;
import com.jhd.scf.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据字典Mapper接口
 */

@Mapper
public interface DataDictionaryMapper extends BaseMapper<DataDictionary> {

    /**
     * 查询字典列表
     *
     * @param page  分页
     * @param query 查询条件
     * @return
     */
    IPage<DataDictionary> selectAll(Page<Object> page, @Param("query") BaseQuery query);

    /**
     * 字典查详情(字典值)
     *
     * @param key 字典id
     * @return
     */
    List<DataDictionaryItem> detail(@Param("key") String key);

    /**
     * 删除数据字典
     *
     * @param id 数据字典id
     * @return
     */
    int deleteById(@Param("id") Long id);
}