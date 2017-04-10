package com.maeen.fliife.school.api.encryption;

import java.security.SecureRandom;

/**
 * @author fliife
 * @since 01/04/17
 */
public class AESEncryption extends Encryption{

    private static AESEncryption instance;
    private byte[] key;
    private byte[] initVector;

    /**
     * Class entrypoint. Use this method to get an instance
     * @return {@link AESEncryption AESEncryption} instance usable for encryption/unencryption
     */
    public static AESEncryption getInstance() {
        // If no instance exists, then create one. Otherwise, keep it.
        instance = instance == null ? new AESEncryption() : instance;
        return instance;
    }

    /**
     * Generate a random byte array of given length.
     * @param length Length of the array to be created.
     * @return The random byte array.
     */
    public byte[] generateRandomBytes(int length) {
        byte[] key = new byte[length];
        new SecureRandom().nextBytes(key);
        return key;
    }

    // Private to make sure no instanciation is going to be made
    // except through getInstance
    private AESEncryption() {}

    /**
     * Set the private key to use.
     * The string is converted to a byte array
     * and passed to {@link AESEncryption#setKey(byte[]) AESEncryption#setKey(byte[])}.
     * @param key The key
     * @return {@link AESEncryption AESEncryption} instance
     */
    public AESEncryption setKey(String key) {
        byte[] bytesKey = new byte[key.length()];
        char[] chars = key.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            bytesKey[i] = (byte) chars[i];
        }
        return setInitVector(bytesKey);
    }

    /**
     * Set the initial vector to use for AES-CBC.
     * The string is converted to a byte array.
     * @param key The init vector
     * @return {@link AESEncryption AESEncryption} instance
     */
    public AESEncryption setKey(byte[] key) {
        this.key = key;
        return this;
    }

    /**
     * Set the initial vector to use for AES-CBC.
     * The string is converted to a byte array and is then
     * passed to {@link AESEncryption#setInitVector(byte[]) AESEncryption#setInitVector(byte[])}.
     * @param initVector The init vector
     * @return {@link AESEncryption AESEncryption} instance
     */
    public AESEncryption setInitVector(String initVector) {
        byte[] bytesInitVector = new byte[initVector.length()];
        char[] chars = initVector.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            bytesInitVector[i] = (byte) chars[i];
        }
        return setInitVector(bytesInitVector);
    }

    /**
     * Set the initial vector to use for AES-CBC.
     * @param initVector The init vector as a byte array.
     * @return {@link AESEncryption AESEncryption} instance
     */
    public AESEncryption setInitVector(byte[] initVector) {
        this.initVector = initVector;
        return this;
    }

    @Override
    public String encrypt(String toEncrypt) {
        // TODO: implement this
        return null;
    }

    @Override
    public String decrypt(String encrypted) {
        // TODO: implement this
        return null;
    }

}
