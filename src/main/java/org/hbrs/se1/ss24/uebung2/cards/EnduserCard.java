package org.hbrs.se1.ss24.uebung2.cards;

public class EnduserCard extends PCard {
    private boolean isHungry;

    public EnduserCard(int id, String firstname, String lastname, boolean hungry) {
        super(id, firstname, lastname);
        isHungry = hungry;
    }

    public String toString() {
        return super.toString() + ", isHungry = " + isHungry;
    }
}
