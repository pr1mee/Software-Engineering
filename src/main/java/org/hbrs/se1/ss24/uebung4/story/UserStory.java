package org.hbrs.se1.ss24.uebung4.story;

import org.hbrs.se1.ss24.uebung4.story.Task.ProtoTask;
import org.hbrs.se1.ss24.uebung4.story.Task.Task;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserStory extends ProtoTask implements Serializable {
    private final MoSCoW priority;
    private final Set<Task> tasks;

    public UserStory() {
        this("This is the default description", MoSCoW.EMPTY);
    }

    public UserStory(String description, MoSCoW priority) {
        super(description);
        this.priority = priority;
        this.tasks = new HashSet<>();
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString() + " " + priority + "\n");
        for (Task t : tasks) {
            s.append(t.toString()).append("\n");
        }
        return s.toString();
    }
}
