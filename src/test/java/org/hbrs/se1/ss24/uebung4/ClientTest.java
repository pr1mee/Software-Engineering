package org.hbrs.se1.ss24.uebung4;

import org.hbrs.se1.ss24.uebung4.Client;
import org.hbrs.se1.ss24.uebung4.story.MoSCoW;
import org.hbrs.se1.ss24.uebung4.story.UserStory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client();
    }

    @Test
    void testAddStory() {
        UserStory story = new UserStory("1", MoSCoW.S);
        client.addStory(story);
        assertTrue(client.userStories.contains(story));
    }

    @Test
    void testSaveAndLoad() throws IOException, ClassNotFoundException {
        client.addStory(new UserStory("1", MoSCoW.S));
        String testFileName = "test_stories.ser";
        client.save(testFileName);
        Client newClient = new Client();
        newClient.load(testFileName);
        assertEquals(newClient.userStories, client.userStories);
    }
}
