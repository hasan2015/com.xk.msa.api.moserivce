package com.xk.msa.api.mo.security.exceptions;

import org.springframework.security.core.AuthenticationException;

import com.xk.msa.api.mo.security.model.token.JwtToken;
/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:27:06
 *
 */
public class JwtExpiredTokenException extends AuthenticationException {
    private static final long serialVersionUID = -5959543783324224864L;
    
    private JwtToken token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
    }

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
