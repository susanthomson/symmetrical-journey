package com.scottlogic.bristechsrm;


import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SimpleSecurityContext;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Enumeration;

@Component
public class AuthFilter  implements Filter{

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig)  {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain) {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String requestMethod = httpRequest.getMethod();
            if (requestMethod.equals("OPTIONS")) {
                chain.doFilter(request, response);
            } else {
                String accessToken = httpRequest.getHeader("Authorization");
                ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();
                JWKSource keySource = new RemoteJWKSet(new URL("http://localhost:9003/jwk"));
                JWSAlgorithm expectedJWSAlg = JWSAlgorithm.RS256;
                JWSKeySelector keySelector = new JWSVerificationKeySelector(expectedJWSAlg, keySource);
                jwtProcessor.setJWSKeySelector(keySelector);
                jwtProcessor.process(accessToken.substring(7), null);
                chain.doFilter(request, response);
            }
        } catch (IOException | ServletException e) {
            System.out.println("oh no filtering went wrong " + e.getMessage());
        } catch (ParseException | BadJOSEException | JOSEException e) {
            System.out.println("oh no processing token went wrong " + e.getMessage());
        }
    }
}
