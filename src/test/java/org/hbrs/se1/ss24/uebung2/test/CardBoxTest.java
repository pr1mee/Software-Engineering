package org.hbrs.se1.ss24.uebung2.test;

import org.hbrs.se1.ss24.uebung2.cardbox.CardBox;
import org.hbrs.se1.ss24.uebung2.cardbox.CardBoxException;
import org.hbrs.se1.ss24.uebung2.cards.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.cards.EnduserCard;
import org.hbrs.se1.ss24.uebung2.cards.PersonCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardBoxTest {
    private CardBox cardBox;
    private PersonCard enduserCard;
    private PersonCard developerCard;

    @BeforeEach
    void setUp() {
        cardBox = new CardBox();
        enduserCard = new EnduserCard(1, "Max", "Mustermann", false);
        developerCard = new DeveloperCard(2, "Erika", "Musterfrau", true);
    }

    @Test
    void testAddPersonCardValid() throws CardBoxException {
        cardBox.addPersonCard(enduserCard);
        assertEquals(1, cardBox.size());
    }

    @Test
    void testAddPersonCardDuplicateId() {
        assertThrows(CardBoxException.class, () -> {
            cardBox.addPersonCard(enduserCard);
            cardBox.addPersonCard(enduserCard); // Gleiche ID sollte Exception auslösen
        });
    }

    @Test
    void testDeletePersonCardExisting() throws CardBoxException {
        cardBox.addPersonCard(developerCard);
        String result = cardBox.deletePersonCard(2);
        assertEquals("Löschen von ID " + 2 + " Erfolgreich", result);
        assertEquals(0, cardBox.size());
    }

    @Test
    void testDeletePersonCardNonExisting() {
        String result = cardBox.deletePersonCard(3);
        assertEquals("Fehler: PersonCard ID 3 nicht gefunden", result);
    }

    @Test
    void testShowContent() throws CardBoxException {//vorm test:
       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

//beim test dann:
        cardBox.addPersonCard(developerCard);
        cardBox.addPersonCard(enduserCard);
        cardBox.showContent();
        String capturedOutput = outputStream.toString().trim();
        String expectedOutput = "ID = 1, Vorname = Max, Nachname = Mustermann, isHungry = false\r\n" +
                "ID = 2, Vorname = Erika, Nachname = Musterfrau, hasEnoughCoffee = true";
        assertEquals(expectedOutput, capturedOutput);
//nachm test zurückstezen:
        System.setOut(originalOut);
    }

    @Test
    void testSize() throws CardBoxException {
        assertEquals(0, cardBox.size());
        cardBox.addPersonCard(enduserCard);
        assertEquals(1, cardBox.size());
        cardBox.addPersonCard(developerCard);
        assertEquals(2, cardBox.size());
    }
}
