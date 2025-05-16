package org.dargor.customer.app.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private final String message;
    private final int code;
    private final String timestamp = LocalDateTime.now().toString();

}
