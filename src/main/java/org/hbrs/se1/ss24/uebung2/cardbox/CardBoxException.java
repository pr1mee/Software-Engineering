package org.hbrs.se1.ss24.uebung2.cardbox;

public class CardBoxException extends Exception {
    public CardBoxException(int ms) {
        super("Das CardBox-Objekt mit der ID " + ms + " ist bereits vorhanden.");
    }
}
