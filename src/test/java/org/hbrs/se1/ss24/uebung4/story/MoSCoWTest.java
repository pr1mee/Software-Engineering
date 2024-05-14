package org.hbrs.se1.ss24.uebung4.story;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoSCoWTest {

    @Test
    void testMorph_M() {
        assertEquals(MoSCoW.M, MoSCoW.morph('M'));
    }

    @Test
    void testMorph_S() {
        assertEquals(MoSCoW.S, MoSCoW.morph('S'));
    }

    @Test
    void testMorph_C() {
        assertEquals(MoSCoW.C, MoSCoW.morph('C'));
    }

    @Test
    void testMorph_W() {
        assertEquals(MoSCoW.W, MoSCoW.morph('W'));
    }

    @Test
    void testMorph_Invalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MoSCoW.morph('X');
        });
        assertEquals("Unrecognized moscow prio: X", exception.getMessage());
    }
}
