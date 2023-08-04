package org.dargor.customer.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionAdviser {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse> argsNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        var errorMessage = new ErrorResponse(String.format("%s: %s", ErrorDefinition.INVALID_INPUT_DATA.getMessage(), errors), HttpStatus.BAD_REQUEST.value());
        log.error(String.format("Exception found with code %s for field validation didn't passed.", errorMessage.getCode()));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<CustomException> customError(CustomException e) {
        log.error(String.format("Exception found with code %d.", e.getCode()));
        return ResponseEntity.status(e.getCode()).body(e);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ErrorResponse> entityNotFound() {
        var errorMessage = new ErrorResponse(ErrorDefinition.ENTITY_NOT_FOUND.getMessage(), HttpStatus.BAD_REQUEST.value());
        log.error("Entity not found");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> genericError() {
        var errorMessage = new ErrorResponse(ErrorDefinition.UNKNOWN_ERROR.getMessage(), HttpStatus.BAD_REQUEST.value());
        log.error(String.format("Exception found with code %d.", 490));
        return new ResponseEntity<>(errorMessage, null, 490);
    }


}
