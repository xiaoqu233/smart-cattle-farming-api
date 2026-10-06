package com.jhd.scf.controller.admin;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.jhd.scf.query.BaseQuery;
import com.jhd.scf.service.DataDictionaryService;
import com.jhd.scf.utils.Res;
import com.jhd.scf.vo.DataDictionaryItemVO;
import com.jhd.scf.vo.DataDictionaryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "数据字典")
@RestController
@RequestMapping("/admin/dataDictionary")
public class DataDictionaryAdminController {
    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Operation(summary = "字典查询", description = "查询字典数据")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:dataDictionary:list")
    @GetMapping("/list")
    public Res query(@ParameterObject BaseQuery query) {
        return dataDictionaryService.query(query);
    }

    @Operation(summary = "字典查详情(字典值)", description = "字典查详情(字典值)")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:dataDictionary:list")
    @GetMapping("/detail/{key}")
    public Res detail(@PathVariable("key") String key) {
        return dataDictionaryService.detail(key);
    }

    @Operation(summary = "添加字典", description = "添加字典")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "添加成功")})
    @SaCheckPermission("sys:dataDictionary:save")
    @PostMapping
    public Res save(@RequestBody DataDictionaryVO data) {
        return dataDictionaryService.save(data);
    }

    @Operation(summary = "添加字典项", description = "添加字典项")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "添加成功")})
    @SaCheckPermission("sys:dataDictionary:save")
    @PostMapping("/item")
    public Res saveDataDictionaryItem(@RequestBody DataDictionaryItemVO data) {
        return dataDictionaryService.saveDataDictionaryItem(data);
    }

    @Operation(summary = "修改字典", description = "根据字典id修改字典")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "修改成功")})
    @SaCheckPermission("sys:dataDictionary:update")
    @PutMapping
    public Res update(@RequestBody DataDictionaryVO data) {
        return dataDictionaryService.update(data);
    }

    @Operation(summary = "删除字典", description = "根据字典id删除字典")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "删除成功")})
    @SaCheckPermission("sys:dataDictionary:delete")
    @DeleteMapping("/{id}")
    public Res delete(
            @Parameter(name = "id", description = "字典id")
            @PathVariable(name = "id") Long id) {
        return dataDictionaryService.delete(id);
    }

    @Operation(summary = "删除字典项", description = "根据字典项id删除字典项")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "删除成功")})
    @DeleteMapping("/item/{id}")
    public Res deleteItem(
            @Parameter(name = "id", description = "字典项id")
            @PathVariable(name = "id") Long id) {
        return dataDictionaryService.deleteItem(id);
    }
}
