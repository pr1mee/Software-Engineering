package org.hbrs.se1.ss24.uebung2.cardbox;

/**
 * Die CardBoxException ist eine spezialisierte Ausnahme, die geworfen wird, wenn ein Konflikt mit existierenden PersonCard-IDs auftritt.
 * Diese Ausnahme wird ausgelöst, wenn versucht wird, eine PersonCard mit einer bereits in der CardBox vorhandenen ID hinzuzufügen.
 */
public class CardBoxException extends Exception {
    /**
     * Konstruktor, der eine CardBoxException mit einer spezifischen Nachricht erstellt,
     * die die ID der bereits existierenden PersonCard enthält.
     *
     * @param id Die ID der PersonCard, die den Konflikt verursacht hat.
     */
    public CardBoxException(int id) {
        super("Das CardBox-Objekt mit der ID " + id + " ist bereits vorhanden.");
    }
}
