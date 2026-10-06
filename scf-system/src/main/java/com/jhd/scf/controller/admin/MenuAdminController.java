package com.jhd.scf.controller.admin;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.jhd.scf.service.MenuService;
import com.jhd.scf.utils.Res;
import com.jhd.scf.vo.MenuVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "菜单管理")
@RestController
@RequestMapping("/admin/menu")
public class MenuAdminController {
    @Autowired
    private MenuService menuService;

    @Operation(summary = "用户菜单", description = "查询用户菜单(不包含菜单下的按钮)")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @GetMapping("/userMenu")
    public Res userMenu() {
        return menuService.getUserMenu(StpUtil.getLoginIdAsLong());
    }

    @Operation(summary = "用户菜单(包含菜单和按钮)", description = "查询所有菜单和菜单下的按钮（租户添加角色时只能设置该账号拥有的菜单和按钮）")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:menu:list")
    @GetMapping("/userMenu/all")
    public Res userMenuAll() {
        return menuService.userMenuAll(StpUtil.getLoginIdAsLong());
    }

    @Operation(summary = "菜单查询", description = "查询所有菜单")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:menu:list")
    @GetMapping("/list")
    public Res query(
            @Parameter(name = "name", description = "菜单名称")
            @RequestParam(name = "name", required = false) String name) {
        return menuService.query(name);
    }

    @Operation(summary = "树形菜单(只有菜单)", description = "查询所有菜单(不包含菜单下的按钮)，用于添加时作为上级菜单列表")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:menu:list")
    @GetMapping("/tree")
    public Res tree() {
        return menuService.tree();
    }

    @Operation(summary = "树形菜单(包含菜单和按钮)", description = "查询所有菜单和菜单下的按钮，用于设置角色权限")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:menu:list")
    @GetMapping("/tree/all")
    public Res all() {
        return menuService.all();
    }

    @Operation(summary = "添加菜单", description = "添加菜单")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "添加成功")})
    @SaCheckPermission("sys:menu:save")
    @PostMapping
    public Res save(@RequestBody MenuVO menu) {
        return menuService.save(menu);
    }

    @Operation(summary = "修改菜单", description = "根据菜单id修改菜单信息")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "修改成功")})
    @SaCheckPermission("sys:men:update")
    @PutMapping
    public Res update(@RequestBody MenuVO menu) {
        return menuService.update(menu);
    }

    @Operation(summary = "删除菜单", description = "根据菜单id删除菜单")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "删除成功")})
    @SaCheckPermission("sys:men:delete")
    @DeleteMapping("/{id}")
    public Res delete(
            @Parameter(name = "id", description = "菜单id")
            @PathVariable(name = "id") Long id) {
        return menuService.delete(id);
    }

}
