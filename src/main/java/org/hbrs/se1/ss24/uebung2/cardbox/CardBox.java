package org.hbrs.se1.ss24.uebung2.cardbox;

import org.hbrs.se1.ss24.uebung2.cards.PersonCard;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 * Die Klasse CardBox dient zur Verwaltung von PersonCards.
 * Sie verwendet eine TreeMap, um die PersonCards nach ihrer ID zu speichern und zu organisieren.
 */
public class CardBox {
    private final Map<Integer, PersonCard> personCards;
    private static CardBox instance = new CardBox();

    /**
     * Konstruktor, der eine leere TreeMap für PersonCards initialisiert.
     */
    private CardBox() {
        this(new TreeMap<>());
    }

    /**
     * Überladener Konstruktor, der es ermöglicht, eine existierende Map von PersonCards zu verwenden.
     *
     * @param map Die zu verwendende Map von PersonCards.
     */
    private CardBox(Map<Integer, PersonCard> map) {
        personCards = map;
    }

    /**
     * Fügt eine neue PersonCard hinzu. Wenn eine Karte mit derselben ID bereits existiert, wird eine CardBoxException ausgelöst.
     *
     * @param personCard Die hinzuzufügende PersonCard.
     * @throws CardBoxException wenn eine Karte mit derselben ID bereits existiert.
     */
    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        PersonCard c = personCards.put(personCard.getId(), personCard);
        if (c != null)
            throw new CardBoxException(c.getId());
    }

    /**
     * Löscht eine PersonCard anhand ihrer ID.
     *
     * @param id Die ID der zu löschenden PersonCard.
     * @return Eine Nachricht, die das Ergebnis des Löschvorgangs angibt.
     */
    public String deletePersonCard(int id) {
        PersonCard p = personCards.remove(id);
        return p == null ? "Fehler: PersonCard ID " + id + " nicht gefunden" : "Löschen von ID " + id + " Erfolgreich";
    }

    /**
     * Zeigt den Inhalt der CardBox auf der Konsole an. Jede PersonCard wird durch ihren eigenen toString-Aufruf dargestellt.
     */
    public void showContent() {
        for (PersonCard personCard : personCards.values()) {
            System.out.println(personCard.toString());
        }
    }

    /**
     * Gibt die Anzahl der PersonCards in der CardBox zurück.
     *
     * @return Die Anzahl der PersonCards.
     */
    public int size() {
        return personCards.size();
    }

    public static CardBox getInstance() {
        return instance;
    }

    public void save() throws CardBoxStorageException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cards.dat"))) {
            out.writeObject(personCards);
        } catch (IOException e) {
            throw new CardBoxStorageException(e.getMessage());
        }
    }

    public void load() throws CardBoxStorageException {
        try (ObjectInputStream out = new ObjectOutputStream(new FileOutputStream("cards.dat"))) {
            out.writeObject(personCards);
        } catch (IOException e) {
            throw new CardBoxStorageException(e.getMessage());
        }
    }

    private class CardBoxStorageException extends Exception {
    }
}
