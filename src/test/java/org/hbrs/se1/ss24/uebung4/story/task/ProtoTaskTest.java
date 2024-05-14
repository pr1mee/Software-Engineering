package org.hbrs.se1.ss24.uebung4.story.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProtoTaskTest {
    private ProtoTask protoTask;
    private String description = "Sample task description";

    @BeforeEach
    void setUp() {
        protoTask = new ProtoTask(description);
    }

    @Test
    void testGetID() {
        assertNotNull(protoTask.getID());
        assertFalse(protoTask.getID().isEmpty());
    }

    @Test
    void testToString() {
        String expectedString = protoTask.getID() + " " + description;
        assertEquals(expectedString, protoTask.toString());
    }

    @Test
    void testDescription() {
        assertTrue(protoTask.toString().contains(description));
    }
}
