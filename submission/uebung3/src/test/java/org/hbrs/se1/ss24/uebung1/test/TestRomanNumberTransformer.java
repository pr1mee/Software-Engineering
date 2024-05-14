package org.hbrs.se1.ss24.uebung1.test;

import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.hbrs.se1.ss24.uebung1.businesslogic.TransformerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit-Testklasse für RomanNumberTransformer.class
 *
 * @author Max Grünewald
 * @author Miguel Obrebski
 */

class TestRomanNumberTransformer {

    private static final RomanNumberTransformer rntr = TransformerFactory.getRomanNumberTransformer();
    private static final String INVALID_STRING = RomanNumberTransformer.INVALID_STRING;

    @Test
    void testRomanNumbers() {

        assertEquals(INVALID_STRING, rntr.transformNumber(0));
        assertEquals("I", rntr.transformNumber(1));
        assertEquals("MMCMXCIX", rntr.transformNumber(2999));
        assertEquals(INVALID_STRING, rntr.transformNumber(3001));
        assertEquals(INVALID_STRING, rntr.transformNumber(10000));
        assertEquals(INVALID_STRING, rntr.transformNumber(-Integer.MAX_VALUE));
    }

}


