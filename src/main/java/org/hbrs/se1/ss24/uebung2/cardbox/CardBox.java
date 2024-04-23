package org.hbrs.se1.ss24.uebung2.cardbox;

import org.hbrs.se1.ss24.uebung2.cards.PersonCard;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class CardBox {
    private Map<Integer, PersonCard> personCards;

    public CardBox() {
        personCards = new HashMap<>();
    }

    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        PersonCard c = personCards.put(personCard.getId(), personCard);
        if (c != null)
            throw new CardBoxException(c.getId());
    }

    public String deletePersonCard(int id) throws Exception {
        if (personCards.remove(id) == null)
            return "Fehler: PersonCard ID " + id + " nicht gefunden";
        return "";
    }

    public void showContent() {
        for (PersonCard personCard : personCards.values()) {
            System.out.println(personCard.toString());
        }
    }
}
