package com.example.api.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private Result<T> result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result<T> {
        private int code;
        private String message;
        private T data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(new Result<>(200, "success", data));
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(new Result<>(code, message, null));
    }
} 