package com.xk.msa.api.mo.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

 
/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:20:36
 *
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
