package org.hbrs.se1.ss24.uebung4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        // Setup initial state if necessary
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testParseInput() {
        String input = "\"Sample task\" add";
        String[] expectedOutput = {"Sample task", "add"};
        assertArrayEquals(expectedOutput, Console.parseInput(input));
    }

    @Test
    void testTaskCommand() {
        String input = "task \"Sample task\"";
        String[] commandArray = Console.parseInput(input);
        Console.cmd(commandArray);
        Console.tasks();
        assertTrue(outputStreamCaptor.toString().contains("Sample task"));
    }

    @Test
    void testStoryCommand() {
        String input = "story \"Sample story\" M";
        String[] commandArray = Console.parseInput(input);
        Console.cmd(commandArray);
        Console.stories();
        assertTrue(outputStreamCaptor.toString().contains("Sample story"));
    }

    @Test
    void testAssignCommand() {
        Console.cmd(Console.parseInput("task \"Sample task\""));
        Console.cmd(Console.parseInput("story \"Sample story\" M"));
        String storyID = Console.client.getStories().iterator().next().getID();
        String taskID = Console.tasks.iterator().next().getID();
        Console.cmd(Console.parseInput("assign " + storyID + " " + taskID));
        Console.stories();
        assertTrue(outputStreamCaptor.toString().contains(taskID));
    }
}
