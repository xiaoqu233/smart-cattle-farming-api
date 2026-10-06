package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 部门对象
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("dept")
public class Dept extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /**
     * 上级ID
     */
    private Long parentId;

    /**
     * 部门code
     */
    private String deptCode;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门负责人
     */
    private Long principalId;

    /**
     * 子部门
     */
    private List<Dept> children;
}
