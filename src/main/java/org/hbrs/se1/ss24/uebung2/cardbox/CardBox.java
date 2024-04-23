package org.hbrs.se1.ss24.uebung2.cardbox;

import org.hbrs.se1.ss24.uebung2.cards.PersonCard;

import java.util.Map;
import java.util.TreeMap;

public class CardBox {
    private final Map<Integer, PersonCard> personCards;

    public CardBox() {
        this(new TreeMap<>());
    }

    public CardBox(Map<Integer, PersonCard> map) {
        personCards = map;
    }

    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        PersonCard c = personCards.put(personCard.getId(), personCard);
        if (c != null)
            throw new CardBoxException(c.getId());
    }

    public String deletePersonCard(int id) {
        PersonCard p = personCards.remove(id);
        return p == null ? "Fehler: PersonCard ID " + id + " nicht gefunden" : "Löschen von ID " + id + " Erfolgreich";
    }

    public void showContent() {
        for (PersonCard personCard : personCards.values()) {
            System.out.println(personCard.toString());
        }
    }

    public int size() {
        return personCards.size();
    }
}
