package com.jhd.scf.controller.admin;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.jhd.scf.service.RoleService;
import com.jhd.scf.utils.Res;
import com.jhd.scf.vo.RoleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色Controller
 */

@Tag(name = "角色管理")
@RestController
@RequestMapping("/admin/role")
public class RoleAdminController {
    @Autowired
    private RoleService roleService;

    @Operation(summary = "角色查询", description = "查询所有角色")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:role:list")
    @GetMapping("/list")
    public Res query(
            @Parameter(name = "name", description = "角色名称")
            @RequestParam(name = "name", required = false) String name) {
        return roleService.query(name);
    }

    @Operation(summary = "添加角色", description = "添加角色")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "添加成功")})
    @SaCheckPermission("sys:role:save")
    @PostMapping
    public Res save(@RequestBody RoleVO roleVO) {
        return roleService.save(roleVO);
    }

    @Operation(summary = "修改角色", description = "根据角色id修改角色信息")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "修改成功")})
    @SaCheckPermission("sys:role:update")
    @PutMapping
    public Res update(@RequestBody RoleVO roleVO) {
        return roleService.update(roleVO);
    }

    @Operation(summary = "删除角色", description = "根据角色id删除角色")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "删除成功")})
    @SaCheckPermission("sys:role:delete")
    @DeleteMapping("/{id}")
    public Res delete(
            @Parameter(name = "id", description = "角色id")
            @PathVariable(name = "id") Long id) {
        return roleService.delete(id);
    }

    @Operation(summary = "查询角色对应的菜单", description = "查询角色对应的菜单")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:role:list")
    @GetMapping("/userMenu/{roleId}")
    public Res userMenu(@Parameter(name = "roleId", description = "角色id")
                        @PathVariable("roleId") Long roleId) {
        return roleService.getUserMenu(roleId);
    }

    @Operation(summary = "根据角色id查询对应的权限", description = "根据角色id查询对应的权限")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @GetMapping("/permission")
    public Res userPermission(@Parameter(name = "userId", description = "用户id")
                              @RequestParam List<Long> roleIds) {
        return roleService.getUserPermission(roleIds);
    }

}