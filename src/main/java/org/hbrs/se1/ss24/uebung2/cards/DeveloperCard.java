package org.hbrs.se1.ss24.uebung2.cards;

/**
 * Die DeveloperCard-Klasse erweitert die PCard-Klasse um eine Eigenschaft, die anzeigt,
 * ob der Entwickler genügend Kaffee hat. Diese Klasse repräsentiert spezifischer die Daten
 * eines Entwicklers.
 */
public class DeveloperCard extends PCard {
    private final boolean hasEnoughCoffee; // Flag, das anzeigt, ob der Entwickler genügend Kaffee hat.

    /**
     * Konstruktor zur Erstellung einer neuen DeveloperCard.
     * @param id Die eindeutige ID der Karte.
     * @param firstname Der Vorname des Entwicklers.
     * @param lastname Der Nachname des Entwicklers.
     * @param hasEnoughCoffee Status, ob der Entwickler genügend Kaffee zur Verfügung hat.
     */
    public DeveloperCard(int id, String firstname, String lastname, boolean hasEnoughCoffee) {
        super(id, firstname, lastname); // Aufruf des Superklassen-Konstruktors mit ID, Vorname und Nachname.
        this.hasEnoughCoffee = hasEnoughCoffee; // Initialisierung der hasEnoughCoffee-Eigenschaft.
    }

    /**
     * Gibt eine String-Darstellung der DeveloperCard zurück.
     * Diese Methode erweitert die String-Darstellung der Superklasse um die Information,
     * ob genügend Kaffee vorhanden ist.
     * @return Eine String-Repräsentation dieser DeveloperCard.
     */
    @Override
    public String toString() {
        return super.toString() + ", hasEnoughCoffee = " + hasEnoughCoffee;
    }
}
