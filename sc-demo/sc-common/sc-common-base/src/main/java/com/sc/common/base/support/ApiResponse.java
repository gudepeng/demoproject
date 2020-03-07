package com.sc.common.base.support;

import lombok.Data;

/**
 * @author ：我是金角大王
 * @date ：Created in 2020/2/27 8:44 下午
 */
@Data
public class ApiResponse {

    public static final String SUCCESS = "0";

    private String code;

    private String message;

    private Object data;

    public ApiResponse(Object data) {
        this.code = ApiResponse.SUCCESS;
        this.data = data;
    }

    public ApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
