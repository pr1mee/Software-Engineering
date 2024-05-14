package org.hbrs.se1.ss24.uebung4.story.Task;

import java.io.Serializable;
import java.util.UUID;

public class ProtoTask implements Serializable {
    private final String id = UUID.randomUUID().toString();
    private final String description;

    public ProtoTask(String des) {
        description = des;
    }

    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + description;
    }
}
