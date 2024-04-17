package org.hbrs.se1.ss24.uebung2;

public interface PersonCard {
    public String getFirstName();
    public String getLastName();

    // Die ID dient als Primärschlüssel zur Unterscheidung alle PersonCard-Objekte.
    // Die ID darf nicht innerhalb der CardBox-Klasse gesetzt werden.
    public int getId();
}
