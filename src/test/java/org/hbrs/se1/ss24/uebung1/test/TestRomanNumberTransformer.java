package org.hbrs.se1.ss24.uebung1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.hbrs.se1.ss24.uebung1.businesslogic.TransformerFactory;
import org.junit.jupiter.api.Test;
/**
 * JUnit-Testklasse für RomanNumberTransformer.class
 * @author Max Grünewald
 * @author Miguel Obrebski
 */

class TestRomanNumberTransformer {

    private static final RomanNumberTransformer rntr = TransformerFactory.getRomanNumberTransformer();
    private static final String INVALID_STRING = RomanNumberTransformer.INVALID_STRING;
    @Test
    void testRomanNumbers() {
        
        testValidRangeEdgeValues();
        testValidTypicalValues();
        testInvalidLowerValues();
        testInvalidUpperValues();
    }

    @Test
    void testValidRangeEdgeValues() {
        assertEquals("I", rntr.transformNumber(1));
        assertEquals("MMM", rntr.transformNumber(3000));
    }

    @Test
    void testValidTypicalValues() {
        assertEquals("D", rntr.transformNumber(500));
        assertEquals("MD", rntr.transformNumber(1500));
        assertEquals("MMD", rntr.transformNumber(2500));
        assertEquals("MMCMXCIX", rntr.transformNumber(2999));
    }

    @Test
    void testInvalidLowerValues() {
        // edge
        assertEquals(INVALID_STRING, rntr.transformNumber(0));
        // typisch
        assertEquals(INVALID_STRING, rntr.transformNumber(-1));
        assertEquals(INVALID_STRING, rntr.transformNumber(-100));
        assertEquals(INVALID_STRING, rntr.transformNumber(-Integer.MAX_VALUE));
    }

    @Test
    void testInvalidUpperValues() {
        //edge
        assertEquals(INVALID_STRING, rntr.transformNumber(3001));
        //typisch
        assertEquals(INVALID_STRING, rntr.transformNumber(5000));
        assertEquals(INVALID_STRING, rntr.transformNumber(10000));
        assertEquals(INVALID_STRING, rntr.transformNumber(Integer.MAX_VALUE));
    }
}


