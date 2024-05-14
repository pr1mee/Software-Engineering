package org.hbrs.se1.ss24.uebung4;

import org.hbrs.se1.ss24.uebung4.story.MoSCoW;
import org.hbrs.se1.ss24.uebung4.story.Task.Task;
import org.hbrs.se1.ss24.uebung4.story.UserStory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Console {
    static final Client client = new Client();
    static final HashSet<Task> tasks = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Bitte geben Sie den Befehl ein:");
            input = scanner.nextLine();

            // Überprüfen, ob der Befehl "exit" lautet
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Programm beendet.");
                break;
            }

            String[] commandArray = parseInput(input);
            cmd(commandArray);
        }

        scanner.close();
    }

    static String[] parseInput(String input) {
        // Liste, um die Argumente zu speichern
        ArrayList<String> arguments = new ArrayList<>();

        // Regulärer Ausdruck, um Textsequenzen zwischen Anführungszeichen zu erkennen
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");
        Matcher matcher = pattern.matcher(input);

        // Matcher durchsucht die Eingabe nach Mustern
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                // Hinzufügen der gefundenen Textsequenz (ohne Anführungszeichen)
                arguments.add(matcher.group(1));
            } else {
                // Hinzufügen der gefundenen normalen Argumente
                arguments.add(matcher.group(2));
            }
        }

        // Konvertieren der Liste in ein Array und Rückgabe
        return arguments.toArray(new String[0]);
    }

    static void cmd(String[] c) {
        switch (c[0]) {
            case "story":
                if (c.length == 3) story(c[1], c[2]);
                else System.out.println("Beachte Syntax: story <\"Beschreibung\"> <Prio als Character>");
                break;
            case "task":
                task(c[1]);
                break;
            case "assign":
                if (c.length == 3)
                    assign(c[1], c[2]);
                else System.out.println("Beachte Syntax: assign <Story-ID> <Task-ID>");
                break;
            case "stories":
                stories();
                break;
            case "tasks":
                tasks();
                break;
            case "load":

                if (c.length == 1) load();
                else load(c[1]);
                break;
            case "save":
                if (c.length == 1) save();
                else save(c[1]);
                break;
            default:
                System.out.println("Die Eingabe war ungültig");
        }
    }

    private static void save() {
        try {
            client.save();
        } catch (Exception e) {
            System.out.println("Fehler beim Speichern");
        }
    }

    private static void load() {
        try {
            client.load();
        } catch (Exception e) {
            System.out.println("Fehler beim Laden");
        }
    }

    private static void save(String s) {
        try {
            client.save(s);
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern");
        }
    }

    private static void load(String filename) {
        try {
            if (filename.isEmpty()) {
                client.load();
            } else client.load(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Fehler beim Lesen der Datei.");
        }

    }

    static void tasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    static void stories() {
        System.out.println("Stories:");
        System.out.println(client.storiesToString());
    }

    private static void assign(String storyID, String taskID) {
        UserStory u;
        try {
            u = Console.client.getStory(storyID);
            for (Task task : Console.tasks) {
                if (task.getID().equals(taskID)) {
                    u.addTask(task);
                    tasks.remove(task);
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("Client ID nicht gefunden.");
        }
        System.out.println("Task nicht gefunden");
    }

    private static void task(String des) {
        tasks.add(new Task(des));
    }

    private static void story(String des, String prio) {
        client.addStory(new UserStory(des, MoSCoW.morph(prio.charAt(0))));
    }
}
