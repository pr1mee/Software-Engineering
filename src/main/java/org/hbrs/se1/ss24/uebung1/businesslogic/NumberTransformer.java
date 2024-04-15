package org.hbrs.se1.ss24.uebung1.businesslogic;

/**
 * interface für NumberTransformer
 */
public interface NumberTransformer {
    /**
     * Transformiert eine Zahl
     * 
     * @param number Die Zahl, die transformiert werden soll
     * @return Die Zahl number, transformiert
     */
    String transformNumber(int number);

    /**
     * Gibt die Art des Transformers aus.
     * 
     * @return Art des Transformers
     */
    String getTransformerType();
}