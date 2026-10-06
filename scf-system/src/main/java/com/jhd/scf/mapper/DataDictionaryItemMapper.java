package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhd.scf.entity.DataDictionaryItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 数据字典项Mapper接口
 */

@Mapper
public interface DataDictionaryItemMapper extends BaseMapper<DataDictionaryItem> {
    /**
     * 查询key是否存在
     *
     * @param bond 字典key
     * @return
     */
    DataDictionaryItem selectByBond(@Param("bond") String bond);

    /**
     * 删除
     *
     * @param id 编号
     * @return
     */
    int deleteById(@Param("id") Long id);
}