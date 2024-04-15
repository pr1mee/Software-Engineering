package org.hbrs.se1.ss24.uebung1.businesslogic;

import java.util.Locale;

public class GermanFormatNumberTransformer extends AbstractNumberTransformer {

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlen";
    }

    @Override
    protected String transform(int number) {
        return String.format(Locale.GERMAN, "%,d", number);
    }

}
