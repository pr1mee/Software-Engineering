package org.hbrs.se1.ss24.uebung2.cards;

public interface PersonCard {
    String getFirstName();

    String getLastName();

    // Die ID dient als Primärschlüssel zur Unterscheidung aller PersonCard-Objekte.
    // Die ID darf nicht innerhalb der CardBox-Klasse gesetzt werden.
    int getId();

}
