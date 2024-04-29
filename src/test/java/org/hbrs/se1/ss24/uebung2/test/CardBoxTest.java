package org.hbrs.se1.ss24.uebung2.test;

import org.hbrs.se1.ss24.uebung2.cardbox.*;
import org.hbrs.se1.ss24.uebung2.cards.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Testklasse für die CardBox, die verschiedene Szenarien für das Hinzufügen, Löschen und Anzeigen von PersonCards testet.
 */
public class CardBoxTest {
    private CardBox cardBox;

    @SuppressWarnings("FieldCanBeLocal")
    private PersonCard enduserCard1;
    private PersonCard enduserCard2;
    private PersonCard developerCard1;
    private PersonCard developerCard2;

    /**
     * Setzt die Testumgebung vor jedem Test auf, indem eine neue CardBox und vier spezifische PersonCards initialisiert werden.
     */
    @BeforeEach
    void setUp() throws CardBoxException {
        cardBox = CardBox.getInstance();
        enduserCard1 = new EnduserCard(1, "Max", "Mustermann", false);
        enduserCard2 = new EnduserCard(3, "Julia", "Schmidt", true);
        developerCard1 = new DeveloperCard(2, "Erika", "Musterfrau", true);
        developerCard2 = new DeveloperCard(4, "Tom", "Schneider", false);

        //Füge die ersten zwei Karten direkt hinzu, um einige Tests zu vereinfachen
        cardBox.addPersonCard(enduserCard1);
        cardBox.addPersonCard(developerCard1);
    }

    /**
     * Testet das Hinzufügen mehrerer gültiger PersonCards zur CardBox.
     */
    @Test
    void testAddPersonCardsValid() throws CardBoxException {
        // Überprüfe die Größe nach dem Initial-Setup
        assertEquals(2, cardBox.size());
        // Füge weitere Karten hinzu
        cardBox.addPersonCard(enduserCard2);
        cardBox.addPersonCard(developerCard2);
        assertEquals(4, cardBox.size());
    }

    /**
     * Testet das Hinzufügen einer PersonCard mit einer bereits existierenden ID, was eine Exception auslösen sollte.
     */
    @Test
    void testAddPersonCardDuplicateId() {
        assertThrows(CardBoxException.class, () -> cardBox.addPersonCard(developerCard1));
    }

    /**
     * Testet das Löschen mehrerer existierender PersonCards und überprüft das Ergebnis und die Größe der CardBox.
     */
    @Test
    void testDeletePersonCardsExisting() throws CardBoxException {
        // Füge eine zusätzliche Karte hinzu, um die Tests zu vertiefen
        cardBox.addPersonCard(developerCard2);
        assertEquals(3, cardBox.size());

        String result = cardBox.deletePersonCard(2);
        assertEquals("Löschen von ID 2 Erfolgreich", result);
        result = cardBox.deletePersonCard(4);
        assertEquals("Löschen von ID 4 Erfolgreich", result);
        assertEquals(1, cardBox.size());
    }

    /**
     * Testet das Löschen einer nicht existierenden PersonCard und erwartet eine Fehlermeldung.
     */
    @Test
    void testDeletePersonCardNonExisting() {
        String result = cardBox.deletePersonCard(99);
        assertEquals("Fehler: PersonCard ID 99 nicht gefunden", result);
    }

    /**
     * Testet die showContent-Methode der CardBox, indem der Standardausgabestrom umgeleitet und verglichen wird.
     */
    @Test
    void testShowContent() throws CardBoxException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        cardBox.addPersonCard(enduserCard2);
        cardBox.addPersonCard(developerCard2);
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
        cardBox.addPersonCard(enduserCard2);
        cardBox.addPersonCard(developerCard2);
        assertEquals(4, cardBox.size());

        cardBox.deletePersonCard(1);
        assertEquals(3, cardBox.size());
    }
}
