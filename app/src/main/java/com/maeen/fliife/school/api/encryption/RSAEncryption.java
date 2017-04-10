package com.maeen.fliife.school.api.encryption;

import android.util.Base64;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public class RSAEncryption extends Encryption {

    private BigInteger modulus;
    private BigInteger exponent;
    private static RSAEncryption instance;

    public static RSAEncryption getInstance() {
        instance = instance == null ? new RSAEncryption() : instance;
        return instance;
    }

    // Private to make sure no instanciation is going to be made
    // except through getInstance
    private RSAEncryption() {}

    /**
     * Sets the modulus from a String
     * @param modulus The exponent, that from String, can be casted to BigInteger
     * @return RSAEncryption itself.
     */
    public RSAEncryption setModulus(String modulus) {
        if (modulus == null || modulus.equals("")) throw new NullPointerException("The parameter given to .setModulus is null/empty.");
        return this.setModulus(new BigInteger(modulus, 16));
    }

    /**
     * Sets the modulus from BigInteger
     * @param modulo The modulus
     * @return RSAEncryption itself.
     */
    public RSAEncryption setModulus(BigInteger modulo) {
        if (modulo == null) throw new NullPointerException("The parameter given to .setModulus is null.");
        this.modulus = modulo;
        return this;
    }

    /**
     * Returns the modulus
     * @return the modulus
     */
    public BigInteger getModulus() {
        return this.modulus;
    }

    /**
     * Sets the exponent from String.
     * @param exponent The exponent as String.
     * @return RSAEncryption itself.
     */
    public RSAEncryption setExponent(String exponent) {
        if (exponent == null || exponent.equals("")) throw new NullPointerException("The parameter given to .setExponent is null/empty.");
        return this.setExponent(new BigInteger(exponent, 16));
    }

    /**
     * Sets the exponent from BigInteger
     * @param exponent The exponent.
     * @return RSAEncryption itself.
     */
    public RSAEncryption setExponent(BigInteger exponent) {
        if (exponent == null) throw new NullPointerException("The parameter given to .setExponent is null.");
        this.exponent = exponent;
        return this;
    }

    /**
     * Returns the exponent
     * @return The exponent
     */
    public BigInteger getExponent() {
        return this.exponent;
    }

    /**
     * Encrypt the given input using RSA ECB algorithm
     * @param toEncrypt The string to be encrypted
     * @return The encrypted string
     */
    @Override
    public String encrypt(String toEncrypt) {
        if (toEncrypt == null) throw new NullPointerException("The string given to .encrypt is null.");
        try {
            final Cipher c = Cipher.getInstance("RSA/ECB/NoPadding");
            RSAPublicKeySpec sp = new RSAPublicKeySpec(this.modulus, this.exponent);
            RSAPublicKey pbk = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(sp);
            c.init(Cipher.ENCRYPT_MODE, pbk);
            byte[] str = c.doFinal(toEncrypt.getBytes());
            return (Base64.encodeToString(str, Base64.DEFAULT));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * No-op: this class doesn't handle decrypting
     * @param encrypted Encrypted string
     * @return nothing
     * @throws NoSuchMethodException Because this class doen't handle decrypting
     */
    @Override
    public String decrypt(String encrypted) throws NoSuchMethodException {
        throw new NoSuchMethodException("This class doesn't handle decrypting");
    }
}
