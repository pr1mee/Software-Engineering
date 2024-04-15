package org.hbrs.se1.ss24.uebung1.businesslogic;

import java.util.Locale;

public class GermanFormatNumberTransformer extends AbstractLimitedNumberTransformer {
    public GermanFormatNumberTransformer() {
        this(1, 3000);
    }

    private GermanFormatNumberTransformer(int min, int max) {
        super(min, max);
    }

    @Override
    protected String transform(int number) {
        return String.format(Locale.GERMAN, "%,d", number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlen";
    }

}
