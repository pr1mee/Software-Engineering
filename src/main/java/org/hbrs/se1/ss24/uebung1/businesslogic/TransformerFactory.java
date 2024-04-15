package org.hbrs.se1.ss24.uebung1.businesslogic;

/**
 * Factory-Klasse für Transformer
 * 
 * @author Miguel Obrebski
 */
public class TransformerFactory {
    /**
     * statische, fertige Transformer
     */
    private static RomanNumberTransformer rntr = new RomanNumberTransformer();
    private static GermanFormatNumberTransformer gfntr = new GermanFormatNumberTransformer();

    /**
     * 
     * @return ein Objekt der Klasse RomanNumberTransformer
     */
    public static RomanNumberTransformer getRomanNumberTransformer() {
        return rntr;
    }


    /**
     * 
     * @return ein Objekt der Klasse GermanFormatNumberTransformer
     */
    public static GermanFormatNumberTransformer getGermanFormatNumberTransformer() {
        return gfntr;
    }

}