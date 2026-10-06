package com.jhd.scf.controller.app;


import com.jhd.scf.service.DataDictionaryService;
import com.jhd.scf.utils.Res;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "数据字典")
@RestController
@RequestMapping("/app/dataDictionary")
public class DataDictionaryController {
    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Operation(summary = "字典查详情(字典值)", description = "字典查详情(字典值)")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @GetMapping("/detail/{key}")
    public Res detail(@PathVariable("key") String key) {
        return dataDictionaryService.detail(key);
    }

}