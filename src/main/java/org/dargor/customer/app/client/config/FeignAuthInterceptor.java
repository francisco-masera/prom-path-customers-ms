package org.dargor.customer.app.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.dargor.customer.app.exception.CustomException;
import org.dargor.customer.app.exception.ErrorDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@Configuration
public class FeignAuthInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        var token = Optional.ofNullable((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .orElseThrow(() -> new CustomException(ErrorDefinition.NOT_AUTHORIZED.getMessage(), HttpStatus.UNAUTHORIZED.value()))
                .getRequest().getHeader(HttpHeaders.AUTHORIZATION);
        
        template.header(HttpHeaders.AUTHORIZATION, token);

    }
}
