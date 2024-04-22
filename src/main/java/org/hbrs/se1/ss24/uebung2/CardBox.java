package org.hbrs.se1.ss24.uebung2;

import java.util.Collection;

public class CardBox {
    private Collection<PersonCard> personCards;
    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        if(containsID(personCard.getId()))
            throw new CardBoxException(personCard.getId());
        personCards.add(personCard);
    }
    private boolean containsID(int id){
        for(PersonCard personCard : personCards){
            if(personCard.getId().equals(id))return true;
        }
        return false;
    }
}
