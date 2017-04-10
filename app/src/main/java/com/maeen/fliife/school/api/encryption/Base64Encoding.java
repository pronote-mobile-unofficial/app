package com.maeen.fliife.school.api.encryption;

import android.util.Base64;

/**
 * @author fliife
 * @since 05/04/17
 */
public class Base64Encoding extends Encryption {

    private static Base64Encoding instance;

    /**
     * Get class instance
     * @return {@link Base64Encoding Base64Encoding} instance
     */
    public static Base64Encoding getInstance() {
        instance = instance == null ? new Base64Encoding() : instance;
        return instance;
    }

    // Private to make sure no instanciation is going to be made
    // except through getInstance
    private Base64Encoding() {}

    /**
     * Given a string, return its base64 version
     * @param source the string to be encoded
     * @return The encoded string
     */
    @Override
    public String encrypt(String source) {
        return new String(Base64.encode(source.getBytes(), Base64.CRLF));
    }

    /**
     * Given a base64 string, return its non-encoded version
     * @param base64 The string to be unencoded
     * @return The source string
     */
    @Override
    public String decrypt(String base64) {
        return new String(Base64.decode(base64.getBytes(), Base64.CRLF));
    }
}
