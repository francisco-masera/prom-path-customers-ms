package org.dargor.customer.core.util;

import java.util.Optional;

import org.dargor.customer.app.exception.CustomException;
import org.dargor.customer.app.exception.ErrorDefinition;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncoderUtil {

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);

    private EncoderUtil() {

    }

    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(Optional.ofNullable(password).orElseThrow(() ->
              new CustomException(ErrorDefinition.INVALID_INPUT_DATA))
        );
    }

}
