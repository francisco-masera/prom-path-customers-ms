package org.dargor.customer.app.client.config;

import java.util.Optional;

import org.dargor.customer.app.exception.CustomException;
import org.dargor.customer.app.exception.ErrorDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class FeignAuthInterceptor implements RequestInterceptor {

   @Override
   public void apply(RequestTemplate template) {
      var token = Optional
            .ofNullable((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
            .orElseThrow(() -> new CustomException(ErrorDefinition.NOT_AUTHORIZED))
            .getRequest()
            .getHeader(HttpHeaders.AUTHORIZATION);

      template.header(HttpHeaders.AUTHORIZATION, token);

   }
}
