package com.xk.msa.api.mo.ctrl;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xk.msa.api.mo.security.auth.JwtAuthenticationToken;
import com.xk.msa.api.mo.security.model.UserContext;

/**
 * End-point for retrieving logged-in user details.
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:16:58
 *
 */
@RestController
@RefreshScope
public class ProfileEndpoint {
	@RequestMapping(name = "com.xk.msa.moservice",value = "/api/getuserinfo", method = RequestMethod.GET)
	public @ResponseBody UserContext get(JwtAuthenticationToken token) {
		return (UserContext) token.getPrincipal();
	}
}
