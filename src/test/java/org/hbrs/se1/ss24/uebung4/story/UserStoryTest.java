package org.hbrs.se1.ss24.uebung4.story;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserStoryTest {
    private UserStory userStory;
    private String description = "Sample user story description";
    private MoSCoW priority = MoSCoW.M;

    @BeforeEach
    void setUp() {
        userStory = new UserStory(description, priority);
    }

    @Test
    void testAddTask() {
        Task task = new Task("Sample task");
        userStory.addTask(task);
        assertTrue(userStory.toString().contains(task.toString()));
    }

    @Test
    void testToString() {
        Task task = new Task("Sample task");
        userStory.addTask(task);
        String expectedString = userStory.getID() + " " + description + " " + priority + "\n" + task.toString() + "\n";
        assertEquals(expectedString, userStory.toString());
    }

    @Test
    void testDefaultConstructor() {
        UserStory defaultUserStory = new UserStory();
        assertEquals("This is the default description", defaultUserStory.toString().split(" ")[1]);
        assertEquals(MoSCoW.EMPTY, defaultUserStory.toString().split(" ")[2]);
    }
}
