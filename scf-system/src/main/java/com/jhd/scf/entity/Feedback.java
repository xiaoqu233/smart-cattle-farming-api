package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * 意见反馈对象
 */

@Data
@Builder
@TableName("feedback")
public class Feedback {
    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片
     */
    private String images;

    /**
     * 操作人Id
     */
    private Long operatorId;

    /**
     * 0反馈中，1已处理，2拒绝
     */
    private Long status;

    /**
     * 处理意见
     */
    private String handlingComments;
}
