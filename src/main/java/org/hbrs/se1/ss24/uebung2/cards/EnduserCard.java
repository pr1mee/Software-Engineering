package org.hbrs.se1.ss24.uebung2.cards;

public class EnduserCard extends PCard {
    private boolean isHungry;

    public EnduserCard(int id, String firstname, String lastname) {
        super(id, firstname, lastname);
    }

    @Override
    public String getFirstName() {
        return "";
    }

    @Override
    public String getLastName() {
        return "";
    }

    @Override
    public int getId() {
        return 0;
    }

    public String toString() {
        return super.toString() + ", isHungry = " + isHungry;
    }
}
