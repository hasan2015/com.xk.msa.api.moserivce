package com.xk.msa.api.mo.security.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;
/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:26:53
 *
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
