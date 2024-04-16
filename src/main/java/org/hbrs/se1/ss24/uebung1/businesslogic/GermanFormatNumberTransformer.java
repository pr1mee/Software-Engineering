package org.hbrs.se1.ss24.uebung1.businesslogic;

import java.util.Locale;
/**
 * GermanFormatNumberTransformer transformiert Integer zu formatierten Strings (9.292.345.123)
 * @author Max Grünewald
 * @author Miguel Obrebski
 */
public class GermanFormatNumberTransformer extends AbstractLimitedNumberTransformer {
    public GermanFormatNumberTransformer() {
        super(1, 3000);
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
