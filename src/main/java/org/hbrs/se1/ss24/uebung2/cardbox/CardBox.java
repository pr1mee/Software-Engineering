package org.hbrs.se1.ss24.uebung2.cardbox;

import org.hbrs.se1.ss24.uebung2.cards.PersonCard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse CardBox dient zur Verwaltung von PersonCards.
 * Sie verwendet eine TreeMap, um die PersonCards nach ihrer ID zu speichern und zu organisieren.
 */
public class CardBox {
    private static CardBox instance = new CardBox();
    private final List<PersonCard> personCards;

    /**
     * Konstruktor, der eine leere TreeMap für PersonCards initialisiert.
     */
    private CardBox() {
        this(new ArrayList<>());
    }

    /**
     * Überladener Konstruktor, der es ermöglicht, eine existierende List von PersonCards zu verwenden.
     *
     * @param l Die zu verwendende List von PersonCards.
     */
    private CardBox(List<PersonCard> l) {
        personCards = l;
    }

    public static CardBox getInstance() {
        return instance;
    }

    /**
     * Fügt eine neue PersonCard hinzu. Wenn eine Karte mit derselben ID bereits existiert, wird eine CardBoxException ausgelöst.
     *
     * @param personCard Die hinzuzufügende PersonCard.
     * @throws CardBoxException wenn eine Karte mit derselben ID bereits existiert.
     */
    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        if (contains(personCard.getId())) {
            throw new CardBoxException(personCard.getId());
        }
        personCards.add(personCard);
    }

    private boolean contains(int id) {
        for (PersonCard p : personCards) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
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
     * Gibt die Anzahl der PersonCards in der CardBox zurück.
     *
     * @return Die Anzahl der PersonCards.
     */
    public int size() {
        return personCards.size();
    }

    /**
     * Speichert die CardBox
     *
     * @throws CardBoxStorageException Falls was schiefgeht :)
     */
    public void save() throws CardBoxStorageException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("cardBox.dat")))) {
            out.writeObject(getInstance());
        } catch (IOException e) {
            throw new CardBoxStorageException(e.getMessage());
        }
    }

    /**
     * Lädt die durch save() gespeicherte Liste
     *
     * @throws CardBoxStorageException Wenn was beim Laden schiefgeht
     */
    public void load() throws CardBoxStorageException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get("cardBox.dat")))) {
            Object o = in.readObject();
            if (o instanceof CardBox) {
                instance = (CardBox) o;
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new CardBoxStorageException(e.getMessage());
        }
    }

    public List<PersonCard> getCurrentList() {

        return personCards;
    }

    public static class CardBoxStorageException extends Exception {
        public CardBoxStorageException(String message) {
            super(message);
        }
    }


    public static class PersonCardView {

        /**
         * Zeigt den Inhalt der CardBox auf der Konsole an. Jede PersonCard wird durch ihren eigenen toString-Aufruf dargestellt.
         *
         * @param personCards Die Liste mit den Karten.
         */
        public static void showContent(List<PersonCard> personCards) {
            for (PersonCard personCard : personCards) {
                System.out.println(personCard.toString());
            }
        }
    }
}