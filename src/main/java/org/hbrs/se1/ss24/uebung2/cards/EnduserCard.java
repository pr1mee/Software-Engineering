package org.hbrs.se1.ss24.uebung2.cards;

/**
 * Die Klasse EnduserCard erweitert die Klasse PCard, um den Hungerzustand des Endnutzers zu repräsentieren.
 * Sie enthält Informationen zu Personendaten sowie den spezifischen Zustand, ob der Endnutzer hungrig ist.
 */
public class EnduserCard extends PCard {
    private final boolean isHungry;

    /**
     * Konstruktor zum Erstellen einer EnduserCard mit ID, Vorname, Nachname und Hungerzustand.
     *
     * @param id        Die ID der Person, eindeutiger Bezeichner.
     * @param firstname Der Vorname der Person.
     * @param lastname  Der Nachname der Person.
     * @param hungry    Der Hungerzustand der Person, true für hungrig, false sonst.
     */
    public EnduserCard(int id, String firstname, String lastname, boolean hungry) {
        super(id, firstname, lastname);
        isHungry = hungry;
    }

    /**
     * Gibt eine String-Repräsentation der EnduserCard zurück, inklusive der von PCard geerbten Attribute sowie des Hungerzustands.
     *
     * @return Eine String-Repräsentation der Karte.
     */
    public String toString() {
        return super.toString() + ", isHungry = " + isHungry;
    }
}
