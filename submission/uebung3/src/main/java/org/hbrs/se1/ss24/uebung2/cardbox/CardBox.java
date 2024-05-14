package org.hbrs.se1.ss24.uebung2.cardbox;

import org.hbrs.se1.ss24.uebung2.cards.PersonCard;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse CardBox dient zur Verwaltung von PersonCards.
 * Sie verwendet eine TreeMap, um die PersonCards nach ihrer ID zu speichern und zu organisieren.
 */
public class CardBox implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public static final Path PATH = Paths.get("cardbox.dat");
    private static CardBox instance;
    private List<PersonCard> personCards;

    static {
        resetInstance();
    }

    public static void resetInstance() {
        instance = new CardBox();
    }

    public static CardBox getInstance() {
        return instance;
    }

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


    /**
     * Fügt eine neue PersonCard hinzu. Wenn eine Karte mit derselben ID bereits existiert, wird eine CardBoxException ausgelöst.
     *
     * @param personCard Die hinzuzufügende PersonCard.
     * @throws CardBoxException wenn eine Karte mit derselben ID bereits existiert.
     */
    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        if (this.contains(personCard.getId())) {
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
        for (PersonCard p : personCards) {
            if (p.getId() == id) {
                personCards.remove(p);
                return "ID " + id + " gelöscht";
            }
        }
        return "ID " + id + " nicht gefunden";
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
    public void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(PATH));

        out.writeObject(personCards);
        out.close();

/*
        try {
        } catch (IOException e) {
            throw new CardBoxStorageException(e.getMessage());
        }*/
    }

    /**
     * Lädt die durch save() gespeicherte Liste
     *
     * @throws CardBoxStorageException Wenn was beim Laden schiefgeht
     */
    public void load() throws CardBoxStorageException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(PATH))) {
            Object o = in.readObject();
            in.close();
            if (o instanceof List<?>) {
                //noinspection unchecked
                this.personCards = ((List<PersonCard>) o);
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new CardBoxStorageException(e.getMessage());
        }
    }

    public List<PersonCard> getCurrentList() {

        return personCards;
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