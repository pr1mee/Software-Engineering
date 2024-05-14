package org.hbrs.se1.ss24.uebung2.test;

import org.hbrs.se1.ss24.uebung2.cardbox.CardBox;
import org.hbrs.se1.ss24.uebung2.cardbox.CardBoxException;
import org.hbrs.se1.ss24.uebung2.cardbox.CardBoxStorageException;
import org.hbrs.se1.ss24.uebung2.cards.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.cards.EnduserCard;
import org.hbrs.se1.ss24.uebung2.cards.PersonCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.smartcardio.Card;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Testklasse für die CardBox, die verschiedene Szenarien für das Hinzufügen, Löschen und Anzeigen von PersonCards testet.
 */
public class CardBoxTest {
    private static CardBox cardBox;

    @SuppressWarnings("FieldCanBeLocal")
    private static final PersonCard ec1;
    private static final PersonCard ec2;
    private static final PersonCard dc1;
    private static final PersonCard dc2;

    static {
        ec1 = new EnduserCard(1, "Max", "Mustermann", false);
        ec2 = new EnduserCard(3, "Julia", "Schmidt", true);
        dc1 = new DeveloperCard(2, "Erika", "Musterfrau", true);
        dc2 = new DeveloperCard(4, "Tom", "Schneider", false);
    }

    /**
     * Setzt die Testumgebung vor jedem Test auf, indem eine neue CardBox und vier spezifische PersonCards initialisiert werden.
     */
    @BeforeEach
    void setUp() throws CardBoxException {

        cardBox = CardBox.getInstance();
        //Füge die ersten zwei Karten direkt hinzu, um einige Tests zu vereinfachen
        cardBox.addPersonCard(ec1);
        cardBox.addPersonCard(dc1);
    }

    @AfterEach
    void reset() {
        CardBox.resetInstance();
    }

    /**
     * Testet das Hinzufügen mehrerer gültiger PersonCards zur CardBox.
     */
    @Test
    void testAddPersonCardsValid() throws CardBoxException {
        // Überprüfe die Größe nach dem Initial-Setup
        assertEquals(2, cardBox.size());
        // Füge weitere Karten hinzu
        cardBox.addPersonCard(ec2);
        cardBox.addPersonCard(dc2);
        assertEquals(4, cardBox.size());
    }

    /**
     * Testet das Hinzufügen einer PersonCard mit einer bereits existierenden ID, was eine Exception auslösen sollte.
     */
    @Test
    void testAddPersonCardDuplicateId() {
        assertThrows(CardBoxException.class, () -> cardBox.addPersonCard(dc1));
    }

    /**
     * Testet das Löschen mehrerer existierender PersonCards und überprüft das Ergebnis und die Größe der CardBox.
     */
    @Test
    void testDeletePersonCardsExisting() throws CardBoxException {
        // Füge eine zusätzliche Karte hinzu, um die Tests zu vertiefen
        cardBox.addPersonCard(dc2);
        assertEquals(3, cardBox.size());

        String result = cardBox.deletePersonCard(2);
        assertEquals("ID 2 gelöscht", result);
        result = cardBox.deletePersonCard(4);
        assertEquals("ID 4 gelöscht", result);
        assertEquals(1, cardBox.size());
    }

    /**
     * Testet das Löschen einer nicht existierenden PersonCard und erwartet eine Fehlermeldung.
     */
    @Test
    void testDeletePersonCardNonExisting() {
        String result = cardBox.deletePersonCard(99);
        assertEquals("ID 99 nicht gefunden", result);
    }

    /**
     * Testet die showContent-Methode der CardBox, indem der Standardausgabestrom umgeleitet und verglichen wird.
     */
    @Test
    void testShowContent() throws CardBoxException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        cardBox.addPersonCard(ec2);
        cardBox.addPersonCard(dc2);
        CardBox.PersonCardView.showContent(cardBox.getCurrentList());
        String capturedOutput = outputStream.toString().trim();
        String expectedOutput = "ID = 1, Vorname = Max, Nachname = Mustermann, isHungry = false\r\n" +
                "ID = 2, Vorname = Erika, Nachname = Musterfrau, hasEnoughCoffee = true\r\n" +
                "ID = 3, Vorname = Julia, Nachname = Schmidt, isHungry = true\r\n" +
                "ID = 4, Vorname = Tom, Nachname = Schneider, hasEnoughCoffee = false";
        assertEquals(expectedOutput, capturedOutput);

        System.setOut(originalOut);
    }

    /**
     * Testet die Größe der CardBox nach dem Hinzufügen und Löschen von PersonCards.
     */
    @Test
    void testSizeChanges() throws CardBoxException {
        assertEquals(2, cardBox.size());
        cardBox.addPersonCard(ec2);
        cardBox.addPersonCard(dc2);
        assertEquals(4, cardBox.size());

        cardBox.deletePersonCard(1);
        assertEquals(3, cardBox.size());
    }

    @Test
    void saveTest() throws CardBoxStorageException, IOException, ClassNotFoundException {
        Files.deleteIfExists(CardBox.PATH);
        cardBox.save();
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(CardBox.PATH));
        Object o = in.readObject();

        assertEquals(cardBox.getCurrentList(),(List<PersonCard>) o);
        CardBox.resetInstance();
        cardBox = CardBox.getInstance();
        cardBox.load();
        assertEquals((List<PersonCard>) o, cardBox.getCurrentList());
    }
}