package org.hbrs.se1.ss24.uebung1.businesslogic;

import java.util.Locale;

public class GermanFormatNumberTransformer implements NumberTransformer {

    @Override
    public String transformNumber(int number) {
        return String.format(Locale.GERMAN, "%,d", number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlen";
    }

}
