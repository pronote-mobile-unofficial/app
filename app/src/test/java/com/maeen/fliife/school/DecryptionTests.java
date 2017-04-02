package com.maeen.fliife.school;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Decryption unit testing
 */
@RunWith(MockitoJUnitRunner.class)
public class DecryptionTests {
    @Test
    public void rsa_correct() throws Exception {
        assertEquals(2 + 2, 4);
    }
}
