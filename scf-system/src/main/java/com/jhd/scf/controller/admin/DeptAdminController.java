package com.jhd.scf.controller.admin;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jhd.scf.service.DeptService;
import com.jhd.scf.utils.Res;
import com.jhd.scf.vo.DeptVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 部门管理Controller
 */


@Tag(name = "部门管理")
@RestController
@RequestMapping("/admin/dept")
public class DeptAdminController {
    @Autowired
    private DeptService deptService;

    @ApiOperationSupport(order = 1)
    @Operation(summary = "部门查询", description = "查询所有部门")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:dept:list")
    @GetMapping("/list")
    public Res query(
            @Parameter(name = "name", description = "部门编码或部门名称")
            @RequestParam(name = "name", required = false) String name) {
        return deptService.query(name);
    }

    @ApiOperationSupport(order = 2)
    @Operation(summary = "添加部门", description = "添加部门")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "添加成功")})
    @SaCheckPermission("sys:dept:save")
    @PostMapping
    public Res save(@RequestBody DeptVO dept) {
        return deptService.save(dept);
    }

    @ApiOperationSupport(order = 3)
    @Operation(summary = "修改部门", description = "根据部门id修改部门")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "修改成功")})
    @SaCheckPermission("sys:dept:update")
    @PutMapping
    public Res update(@RequestBody DeptVO dept) {
        return deptService.update(dept);
    }

    @ApiOperationSupport(order = 4)
    @Operation(summary = "删除部门", description = "根据部门id删除部门")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "删除成功")})
    @SaCheckPermission("sys:dept:delete")
    @DeleteMapping("/{id}")
    public Res delete(
            @Parameter(name = "id", description = "部门id")
            @PathVariable(name = "id") Long id) {
        return deptService.delete(id);
    }

}
