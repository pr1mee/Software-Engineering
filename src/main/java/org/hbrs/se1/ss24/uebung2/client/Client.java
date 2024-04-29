package org.hbrs.se1.ss24.uebung2.client;

import org.hbrs.se1.ss24.uebung2.cardbox.CardBox;
import org.hbrs.se1.ss24.uebung2.cardbox.CardBoxException;
import org.hbrs.se1.ss24.uebung2.cards.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.cards.EnduserCard;
import org.hbrs.se1.ss24.uebung2.cards.PersonCard;

import java.util.List;

public class Client {
    public static void main(String[] args) throws CardBoxException {
        CardBox.getInstance().addPersonCard(new DeveloperCard((int) (Math.random() * 100), "Konrad", "Zuse", true));
        CardBox.getInstance().addPersonCard(new EnduserCard((int) (Math.random() * 100), "Zonrad", "Kuse", true));

        List<PersonCard> l = CardBox.getInstance().getCurrentList();

        CardBox.PersonCardView.showContent(l);
    }
}