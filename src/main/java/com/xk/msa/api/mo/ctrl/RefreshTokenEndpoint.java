package com.xk.msa.api.mo.ctrl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xk.msa.api.mo.entity.User;
import com.xk.msa.api.mo.security.auth.jwt.extractor.TokenExtractor;
import com.xk.msa.api.mo.security.auth.jwt.verifier.TokenVerifier;
import com.xk.msa.api.mo.security.config.JwtSettings;
import com.xk.msa.api.mo.security.config.WebSecurityConfig;
import com.xk.msa.api.mo.security.exceptions.InvalidJwtToken;
import com.xk.msa.api.mo.security.model.UserContext;
import com.xk.msa.api.mo.security.model.token.JwtToken;
import com.xk.msa.api.mo.security.model.token.JwtTokenFactory;
import com.xk.msa.api.mo.security.model.token.RawAccessJwtToken;
import com.xk.msa.api.mo.security.model.token.RefreshToken;
import com.xk.msa.api.mo.service.UserService;
/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:26:32
 *
 */
@RestController
@RefreshScope
public class RefreshTokenEndpoint {
    @Autowired private JwtTokenFactory tokenFactory;
    @Autowired private JwtSettings jwtSettings;
    @Autowired private UserService userService;
    @Autowired private TokenVerifier tokenVerifier;
    @Autowired @Qualifier("jwtHeaderTokenExtractor") private TokenExtractor tokenExtractor;
    
    @RequestMapping(name = "com.xk.msa.api.ca.refreshtoken",value="/api/xkauth/token", method=RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM));
        
        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(() -> new InvalidJwtToken());

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtToken();
        }

        String subject = refreshToken.getSubject();
        User user = userService.getByUsername(subject).orElseThrow(() -> new UsernameNotFoundException("User not found: " + subject));

        if (user.getUserroles() == null) throw new InsufficientAuthenticationException("User has no roles assigned");
        List<GrantedAuthority> authorities = user.getUserroles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().getRolename()))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getUsername(), authorities);

        return tokenFactory.createAccessJwtToken(userContext);
    }
}
