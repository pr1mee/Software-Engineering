package org.hbrs.se1.ss24.uebung2.cards;

public class DeveloperCard extends PCard {
    private boolean hasEnoughCoffee;

    public DeveloperCard(int id, String firstname, String lastname, boolean hasEnoughCoffee) {
        super(id, firstname, lastname);
        this.hasEnoughCoffee = hasEnoughCoffee;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasEnoughCoffee = " + hasEnoughCoffee;
    }
}
