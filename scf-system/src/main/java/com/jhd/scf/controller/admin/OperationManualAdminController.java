package com.jhd.scf.controller.admin;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.jhd.scf.entity.OperationManual;
import com.jhd.scf.query.BaseQuery;
import com.jhd.scf.service.OperationManualService;
import com.jhd.scf.utils.Res;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 操作手册Controller
 */

@Tag(name = "操作手册")
@RestController
@RequestMapping("/admin/operationManual")
public class OperationManualAdminController {
    @Autowired
    private OperationManualService operationManualService;

    @Operation(summary = "操作手册查询", description = "查询所有操作手册")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:operationManual:list")
    @GetMapping("/list")
    public Res query(@ParameterObject BaseQuery query) {
        return operationManualService.query(query);
    }

    @Operation(summary = "添加操作手册", description = "添加操作手册")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "添加成功")})
    @SaCheckPermission("sys:operationManual:add")
    @PostMapping
    public Res save(@RequestBody OperationManual data) {
        return operationManualService.save(data);
    }

    @Operation(summary = "修改操作手册", description = "根据操作手册id修改操作手册信息")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "修改成功")})
    @SaCheckPermission("sys:operationManual:update")
    @PutMapping
    public Res update(@RequestBody OperationManual data) {
        return operationManualService.update(data);
    }

    @Operation(summary = "删除操作手册", description = "根据操作手册id删除操作手册")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "删除成功")})
    @SaCheckPermission("sys:operationManual:delete")
    @DeleteMapping("/{id}")
    public Res delete(
            @Parameter(name = "id", description = "岗位id")
            @PathVariable(name = "id") Long id) {
        return operationManualService.delete(id);
    }
}
