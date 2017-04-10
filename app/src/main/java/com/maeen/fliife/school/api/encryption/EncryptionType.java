package com.maeen.fliife.school.api.encryption;

public enum EncryptionType {
    NOTHING(0),
    UNICODE(1),
    AES(2),
    RSA(3);

    private final int value;

    EncryptionType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
