import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTranformer;

public class Client {
    private RomanNumberTranformer rtr;

    public Client(RomanNumberTranformer rtr) {
        this.rtr = rtr;
    }

    public void printTransformation(int number) {
        String result = rtr.transformNumber(number);
        System.out.println("Die römische Schreibweise der Zahl " + number + " ist: " + result);
    }
}
