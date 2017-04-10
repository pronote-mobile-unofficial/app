package com.maeen.fliife.school.api.profiles;

public enum ProfileType {
    TEACHER(1),
    PARENT(2),
    STUDENT(3);

    private final int value;

    ProfileType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
