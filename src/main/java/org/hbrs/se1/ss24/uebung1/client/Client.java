import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.hbrs.se1.ss24.uebung1.businesslogic.TransformerFactory;

public class Client {
    private RomanNumberTransformer rtr;

    public Client() {
        this(TransformerFactory.getRomanNumberTransformer());
    }

    public Client(RomanNumberTransformer rtr) {
        this.rtr = rtr;
    }

    public void printTransformation(int number) {
        String result = rtr.transformNumber(number);
        System.out.println("Die römische Schreibweise der Zahl " + number + " ist: " + result);
    }
}
