package org.dargor.customer.core.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class EncoderUtil {

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);

    private EncoderUtil() {

    }

    public static String passwordEncoder(String password) {
        if (!ObjectUtils.isEmpty(password))
            return bCryptPasswordEncoder.encode(password);
        return null;
    }

}
