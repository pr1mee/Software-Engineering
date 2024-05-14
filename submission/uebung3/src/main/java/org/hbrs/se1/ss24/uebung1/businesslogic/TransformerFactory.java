package org.hbrs.se1.ss24.uebung1.businesslogic;

/**
 * Factory-Klasse für Transformer
 *
 * @author Max Grünewald
 * @author Miguel Obrebski
 */
public class TransformerFactory {
    /**
     * statischer, fertiger Transformer
     */
    private static final RomanNumberTransformer rntr = new RomanNumberTransformer();
    private static final GermanFormatNumberTransformer gfntr = new GermanFormatNumberTransformer();

    /**
     * @return ein Objekt der Klasse RomanNumberTransformer
     */
    public static RomanNumberTransformer getRomanNumberTransformer() {
        return rntr;
    }

    /**
     * @return ein Objekt der Klasse GermanFormatNumberTransformer
     */
    public static GermanFormatNumberTransformer getGermanFormatNumberTransformer() {
        return gfntr;
    }

}