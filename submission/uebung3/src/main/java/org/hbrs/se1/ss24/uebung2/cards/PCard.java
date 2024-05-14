package org.hbrs.se1.ss24.uebung2.cards;

import java.io.Serializable;

/**
 * Die Klasse PCard implementiert das PersonCard-Interface und stellt eine Personenkarte dar.
 * Jede Personenkarte hat eine eindeutige ID sowie Vornamen und Nachnamen.
 */
public class PCard implements PersonCard, Serializable {
    protected final int id;          // Eindeutige ID der Person
    protected String firstname;      // Vorname der Person
    protected String lastname;       // Nachname der Person

    /**
     * Konstruktor für eine neue PCard.
     *
     * @param id        Die eindeutige ID der Person.
     * @param firstname Der Vorname der Person.
     * @param lastname  Der Nachname der Person.
     */
    public PCard(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Gibt den Vornamen der Person zurück.
     *
     * @return Der Vorname der Person.
     */
    @Override
    public String getFirstName() {
        return firstname;
    }

    /**
     * Gibt den Nachnamen der Person zurück.
     *
     * @return Der Nachname der Person.
     */
    @Override
    public String getLastName() {
        return lastname;
    }

    /**
     * Gibt die ID der Person zurück.
     *
     * @return Die eindeutige ID der Person.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Gibt eine String-Repräsentation der PCard zurück, die ID, Vorname und Nachname enthält.
     *
     * @return Eine String-Repräsentation der PCard.
     */
    public String toString() {
        return "ID = " + id + ", Vorname = " + firstname + ", Nachname = " + lastname;
    }
}
