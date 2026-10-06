package com.jhd.scf.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用返回类
 *
 * @param <T>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Res<T> implements Serializable {

    /**
     * 响应码
     */
    @Schema(description = "响应码")
    private int code;

    /**
     * 响应数据
     */
    @Schema(description = "响应数据")
    private T data;

    /**
     * 响应信息
     */
    @Schema(description = "提示信息")
    private String msg;

    public static Res success() {
        return Res.builder().code(200).data(null).msg("请求成功").build();
    }

    public static <T> Res success(T data) {
        return Res.builder().code(200).data(data).msg("请求成功").build();
    }

    public static <T> Res success(T data, String msg) {
        return Res.builder().code(200).data(data).msg(msg).build();
    }

    public static Res error() {
        return Res.builder().code(400).data(null).msg("请求失败").build();
    }

    public static Res error(String msg) {
        return Res.builder().code(400).data(null).msg(msg).build();
    }

    public static Res error(int code, String msg) {
        return Res.builder().code(code).data(null).msg(msg).build();
    }

    public static Res error(String msg, Object data) {
        return Res.builder().code(400).data(data).msg(msg).data(data).build();
    }
}
