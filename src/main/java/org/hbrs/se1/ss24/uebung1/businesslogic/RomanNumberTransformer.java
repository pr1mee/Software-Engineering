package org.hbrs.se1.ss24.uebung1.businesslogic;

/**
 * Konvertiert int zu römischen String-Zahlen
 * 
 * @author Miguel Obrebski
 * @author Max Grünewald
 */
public class RomanNumberTransformer extends AbstractLimitedNumberTransformer {

    private static final String[] romanSymbols = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM",
            "M" };
    public static final int[] ROMAN_VALUES = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
    //public static final String INVALID_STRING = AbstractLimitedNumberTransformer.INVALID_STRING;

    public RomanNumberTransformer() {
        super(1, 3000);
    }

    @Override
    protected String transform(int number) {

        StringBuilder romanNumeral = new StringBuilder();
        for (int i = ROMAN_VALUES.length - 1; i >= 0; i--) {
            while (number >= ROMAN_VALUES[i]) {
                romanNumeral.append(romanSymbols[i]);
                number -= ROMAN_VALUES[i];
            }
        }
        return romanNumeral.toString();
    }

    @Override
    public String getTransformerType() {
        return "Transformer für römische Zahlenformatierungen";
    }
}