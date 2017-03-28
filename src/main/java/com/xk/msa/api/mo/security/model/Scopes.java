package com.xk.msa.api.mo.security.model;
/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:28:43
 *
 */
public enum Scopes {
    REFRESH_TOKEN;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
