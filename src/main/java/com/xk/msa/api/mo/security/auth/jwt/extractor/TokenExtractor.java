package com.xk.msa.api.mo.security.auth.jwt.extractor;
 
/**
 * Implementations of this interface should always return raw base-64 encoded
 * representation of JWT Token.
 * @author yanhaixun
 * @date 2017年3月18日 下午12:20:21
 *
 */
public interface TokenExtractor {
    public String extract(String payload);
}
