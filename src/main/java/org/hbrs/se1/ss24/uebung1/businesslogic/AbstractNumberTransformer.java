package org.hbrs.se1.ss24.uebung1.businesslogic;

public abstract class AbstractNumberTransformer implements NumberTransformer {

    int MIN = 1;
    int MAX = 3000;

    @Override
    public final String transformNumber(int number) {
        return (number < MIN || number > MAX) //Wertebereich
                ? "Die Zahl befindet sich ausserhalb des maximalen Wertebereichs ]1:3000["
                : transform(number);
    }

    protected abstract String transform(int number);
}
