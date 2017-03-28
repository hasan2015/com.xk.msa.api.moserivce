package com.xk.msa.api.mo.common;

import com.fasterxml.jackson.annotation.JsonValue;
 
/**
 * Enumeration of REST Error types.
 * @author yanhaixun
 * @date 2017年3月18日 下午12:14:45
 *
 */
public enum ErrorCode {
    GLOBAL(2),

    AUTHENTICATION(10), JWT_TOKEN_EXPIRED(11);
    
    private int errorCode;

    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }
}
