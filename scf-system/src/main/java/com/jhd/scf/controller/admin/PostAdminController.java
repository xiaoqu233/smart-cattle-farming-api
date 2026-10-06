package com.jhd.scf.controller.admin;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.jhd.scf.service.PostService;
import com.jhd.scf.utils.Res;
import com.jhd.scf.vo.PostVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 岗位Controller
 */

@Tag(name = "岗位管理")
@RestController
@RequestMapping("/admin/post")
public class PostAdminController {
    @Autowired
    private PostService postService;

    @Operation(summary = "岗位查询", description = "查询所有岗位")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:post:list")
    @GetMapping("/list")
    public Res query(
            @Parameter(name = "name", description = "岗位编码或岗位名称")
            @RequestParam(name = "name", required = false) String name) {
        return postService.query(name);
    }

    @Operation(summary = "添加岗位", description = "添加岗位")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "添加成功")})
    @SaCheckPermission("sys:post:save")
    @PostMapping
    public Res save(@RequestBody PostVO post) {
        return postService.save(post);
    }

    @Operation(summary = "修改岗位", description = "根据岗位id修改岗位信息")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "修改成功")})
    @SaCheckPermission("sys:post:update")
    @PutMapping
    public Res update(@RequestBody PostVO post) {
        return postService.update(post);
    }

    @Operation(summary = "删除岗位", description = "根据岗位id删除岗位")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "删除成功")})
    @SaCheckPermission("sys:post:delete")
    @DeleteMapping("/{id}")
    public Res delete(
            @Parameter(name = "id", description = "岗位id")
            @PathVariable(name = "id") Long id) {
        return postService.delete(id);
    }

}