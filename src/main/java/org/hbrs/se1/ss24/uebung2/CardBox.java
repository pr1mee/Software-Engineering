package org.hbrs.se1.ss24.uebung2;

import java.util.Collection;
import java.util.function.Predicate;

public class CardBox {
    private Collection<PersonCard> personCards;
    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        if(containsID(personCard.getId()))
            throw new CardBoxException(personCard.getId());
        personCards.add(personCard);
    }
    public String deletePersonCard(int id) throws Exception {
        if(personCards.removeIf(new Predicate<PersonCard>() {
            @Override
            public boolean test(PersonCard personCard) {
                return personCard.getId() == id;
            }
        })) return "";
        return "Fehler: PersonCard ID nicht gefunden"; //TODO
    }
    private boolean containsID(int id){
        return personCards.stream().anyMatch(new Predicate<PersonCard>() {

            @Override
            public boolean test(PersonCard personCard) {

                return personCard.getId()==id;
            }
        });
    }
}
