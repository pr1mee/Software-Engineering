package org.hbrs.se1.ss24.uebung1.businesslogic;

/**
 * Der AbstractLimitedNumberTransformer limitiert die Wertebereiche von
 * NumberTransformer Klassen
 * 
 * @author Miguel Obrebski
 */
public abstract class AbstractLimitedNumberTransformer implements NumberTransformer {

    private final int min;
    private final int max;

    /**
     * [min:max]
     * 
     * @param min Minimum des Limits (inklusive)
     * @param max Maximum des Limits (inklusive)
     */
    public AbstractLimitedNumberTransformer(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    /**
     * Wandelt Zahlen im Bereich von 0 bis 3000 um
     * 
     * @param number Die umzuwandelnde Zahl
     * @return Entweder eine Fehlermeldung, falls die Zahl ausserhalb des
     *         Zahlenbereichs von 0 bis 3000 ist oder die umgewandelte Zahl
     */
    public final String transformNumber(int number) {
        return (number < min || number > max) // Wertebereich
                ? "Die Zahl befindet sich ausserhalb des maximalen Wertebereichs [1:3000]"
                : transform(number);
    }

    /**
     * Wandelt number zu einem String im gegebenen Format um.
     * 
     * @param number Die umzuwandelnde Zahl
     * @return Ein String, der die Zahl im gewünschten Format darstellen soll
     */
    protected abstract String transform(int number);
}
