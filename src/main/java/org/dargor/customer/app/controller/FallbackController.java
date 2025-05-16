package org.dargor.customer.app.controller;

import static org.dargor.customer.app.exception.ErrorDefinition.SERVICE_UNAVAILABLE;

import org.dargor.customer.app.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
//@RequestMapping("/fallback")
public class FallbackController {

   @GetMapping("/customer")
   public ResponseEntity<CustomException> fallbackErrorResponse() {
      return new ResponseEntity<>(new CustomException(SERVICE_UNAVAILABLE), HttpStatus.SERVICE_UNAVAILABLE);
   }

}
