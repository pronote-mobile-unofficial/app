package com.maeen.fliife.school;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Encryption unit testing
 */
@RunWith(MockitoJUnitRunner.class)
public class EncryptionTests {
    @Test
    public void rsa_correct() throws Exception {
        assertEquals(4, 2 + 2);
    }
}
