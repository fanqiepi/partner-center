package com.chalz.usercenter.exception;

import com.chalz.usercenter.common.ErrorCode;

/**
 * @author chalz
 */
public class BusinessException extends RuntimeException{
    private final String description;
    private final int code;

    public BusinessException( int code, String message,String description) {
        super(message);
        this.description = description;
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.description = errorCode.getDescription();
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }
}
