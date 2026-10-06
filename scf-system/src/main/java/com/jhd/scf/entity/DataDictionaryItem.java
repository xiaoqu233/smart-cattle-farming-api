package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据字典项对象
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("data_dictionary_item")
public class DataDictionaryItem {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 数据字典ID
     */
    private Long dataDictionaryId;

    /**
     * Key
     */
    private String bond;

    /**
     * 名称
     */
    private String bondName;

    /**
     * 当前状态key的下一个状态key
     */
    private String nextKey;

    /**
     * 值1
     */
    private String value;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 值2
     */
    private String value2;
}
