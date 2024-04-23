package org.hbrs.se1.ss24.uebung2.cards;

public class DeveloperCard extends PCard {
    private boolean hasEnoughCoffee;

    public DeveloperCard(int id, String firstname, String lastname) {
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

    @Override
    public String toString() {
        return super.toString() + ", hasEnoughCoffee = " + hasEnoughCoffee;
    }
}
