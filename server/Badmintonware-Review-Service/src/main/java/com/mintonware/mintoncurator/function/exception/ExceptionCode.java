package com.mintonware.mintoncurator.function.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    MEMBER_EXISTS(409, "Member Exists"),
    PRODUCT_NOT_FOUND(404, "Product Not Found"),
    PRODUCT_EXISTS(409, "Product Exists"),
    ORDER_NOT_FOUND(404, "Order Not Found"),
    CANNOT_CHANGE_ORDER(403, "Order Can't Change");

    @Getter
    private int code;
    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
