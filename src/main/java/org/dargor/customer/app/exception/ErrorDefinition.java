package org.dargor.customer.app.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorDefinition {

   INVALID_INPUT_DATA("Please verify input data", HttpStatus.BAD_REQUEST),
   UNKNOWN_ERROR("Unknown error occurred", HttpStatus.INTERNAL_SERVER_ERROR),
   ENTITY_NOT_FOUND("Entity not found", HttpStatus.NOT_FOUND),
   NOT_AUTHORIZED("Not Authorized", HttpStatus.UNAUTHORIZED),

   //Fallback
   SERVICE_UNAVAILABLE("Service is unavailable", HttpStatus.SERVICE_UNAVAILABLE);

   private final String message;

   private final HttpStatus status;

   ErrorDefinition(String message, HttpStatus status) {
      this.message = message;
      this.status = status;
   }
}
