package org.hbrs.se1.ss24.uebung4;

import org.hbrs.se1.ss24.uebung4.story.UserStory;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Client {
    private Set<UserStory> userStories;
    private static final String DEF_FILE = "stories.ser";

    public Client() {
        userStories = new HashSet<>();
    }

    public void addStory(UserStory story) {
        userStories.add(story);
    }

    void save() throws IOException {
        save(DEF_FILE);
    }

    public void save(String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userStories);
        System.out.println("Saved");

    }

    public void load() throws IOException, ClassNotFoundException {
        this.load(DEF_FILE);
    }

    public void load(String fileName) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        userStories = (Set<UserStory>) o;

        System.out.println("Set has been loaded");
        ois.close();
        fis.close();
    }

    public UserStory getStory(String storyID) throws IOException {
        for (UserStory story : userStories) {
            if (story.getID().equals(storyID)) {
                return story;
            }
        }
        throw new IOException("No story with ID " + storyID + " found");
    }

    public String storiesToString() {
        String s = "";
        for (UserStory story : userStories) {
            s = s.concat(story.toString() + "\n");
        }
        return s;
    }
}
