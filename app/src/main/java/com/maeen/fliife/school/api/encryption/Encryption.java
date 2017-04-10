package com.maeen.fliife.school.api.encryption;

public abstract class Encryption {

    /**
     * Abstract method to encrypt.
     * @param toEncrypt The source string
     * @return The source string, encrypted
     * @throws NoSuchMethodException if the class doesn't support encryption
     */
    public abstract String encrypt(String toEncrypt) throws NoSuchMethodException;

    /**
     * Abstract method to encrypt.
     * @param encrypted Encrypted string
     * @return The unencrypted String
     * @throws NoSuchMethodException if the class doesn't support decryption
     */
    public abstract String decrypt(String encrypted) throws NoSuchMethodException;
}
