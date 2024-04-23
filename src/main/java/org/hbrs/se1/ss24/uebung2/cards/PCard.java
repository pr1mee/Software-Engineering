package org.hbrs.se1.ss24.uebung2.cards;

public class PCard implements PersonCard{
    protected String firstname;
    protected String lastname;
    protected final int id;

    public PCard(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String getFirstName() {
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public int getId() {
        return id;
    }
    public String toString(){
        return "ID = "+id+", Vorname = "+firstname+", Nachname = "+lastname;
    }
}
