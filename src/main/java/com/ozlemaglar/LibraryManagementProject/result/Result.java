package com.ozlemaglar.LibraryManagementProject.result;

import lombok.Data;

@Data
public class Result<T> {
    public static final String NULL_ERROR = "204";
    public static final String NOT_FOUND_ERROR = "204";
    public static final String SUCCESS_CODE = "200";

    public static final String ERROR_CODE = "205";

    private T data;
    private String message;
    private String code;

    public Result() {
        this.code = SUCCESS_CODE;
    }

    public Result(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public static String getNullError() {
        return NULL_ERROR;
    }

    public void setNullError(String message) {
        this.setError(NULL_ERROR, message);
    }

    public void setNotFoundError(String message) {
        this.setError(NOT_FOUND_ERROR, message);
    }

    public void setError(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public void setSuccess(String code, String message){
        this.setCode(code);
        this.setMessage(message);
    }
}