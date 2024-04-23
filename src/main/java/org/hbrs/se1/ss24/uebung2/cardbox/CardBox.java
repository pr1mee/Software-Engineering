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
        if (personCards.remove(id) == null)
            return "Fehler: PersonCard ID " + id + " nicht gefunden";
        return "";
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
