package org.hbrs.se1.ss24.uebung4.story.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task;
    private String description = "Sample task description";

    @BeforeEach
    void setUp() {
        task = new Task(description);
    }

    @Test
    void testGetID() {
        assertNotNull(task.getID());
        assertFalse(task.getID().isEmpty());
    }

    @Test
    void testToString() {
        String expectedString = task.getID() + " " + description;
        assertEquals(expectedString, task.toString());
    }

    @Test
    void testDescription() {
        assertTrue(task.toString().contains(description));
    }
}
