package org.monopoly.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author walshj05
 * Tests for the ChanceDeck class
 */
class ChanceDeckTest {

    @Test
    void testEnvironmentWorks() {
        assertTrue(true);
    }

    @Test
    void testChanceDeckCreation() {
        ChanceDeck chanceDeck = new ChanceDeck();
        assertNotNull(chanceDeck, "ChanceDeck object should be created");
    }

    @Test
    void testDrawCard() {
        ChanceDeck chanceDeck = new ChanceDeck();
        String card = chanceDeck.drawCard();
        assertNotNull(card, "Card should be drawn");
    }

    @Test
    void testDrawCardReshuffle() {
        ChanceDeck chanceDeck = new ChanceDeck();
        for (int i = 0; i < 16; i++) {
            chanceDeck.drawCard();
        }
        String card = chanceDeck.drawCard();
        assertNotNull(card, "Card should be drawn after reshuffling");
    }

    @Test
    void testDrawCardReshuffleResetsDeckSizeToSixteen() {
        ChanceDeck chanceDeck = new ChanceDeck();
        for (int i = 0; i < 15; i++) {
            chanceDeck.drawCard();
        }
        assertEquals(0, chanceDeck.drawPile.size(), "Deck size should be reset to 15 after reshuffling");
        String card = chanceDeck.drawCard();
        assertEquals(14, chanceDeck.drawPile.size(), "Deck size should be 14 after drawing a card");
        assertNotNull(card, "Card should be drawn after reshuffling");
    }

    @Test
    void testDrawCardReshuffleResetsDiscardPile() {
        ChanceDeck chanceDeck = new ChanceDeck();
        for (int i = 0; i < 15; i++) {
            chanceDeck.drawCard();
        }
        assertEquals(15, chanceDeck.discardPile.size(), "Discard pile should contain 15 cards after reshuffling");
        String card = chanceDeck.drawCard();
        assertEquals(1, chanceDeck.discardPile.size(), "Discard pile should contain 1 card after drawing a card");
        assertNotNull(card, "Card should be drawn after reshuffling");
    }

    @Test
    void testDrawCardReshuffleResetsDiscardPileToDrawPile() {
        ChanceDeck chanceDeck = new ChanceDeck();
        for (int i = 0; i < 15; i++) {
            chanceDeck.drawCard();
        }
        String card = chanceDeck.drawCard();
        assertEquals(14, chanceDeck.drawPile.size(), "Draw pile should contain 15 cards after drawing a card");
        assertEquals(1, chanceDeck.discardPile.size(), "Discard pile should contain 1 card after drawing a card");
        assertNotNull(card, "Card should be drawn after reshuffling");
    }

    @Test
    void testDrawCardReturnsValidString(){
        ChanceDeck chanceDeck = new ChanceDeck();
        boolean validCard = false;
        for (int i = 0; i < 16; i++) {
            String card = chanceDeck.drawCard();
            if (card.equals("Advance to Boardwalk.")) {
                validCard = true;
                break;
            }
        }
        assertTrue(validCard, "Card drawn should be 'Advance to Boardwalk.'");
    }
    @Test
    void testTwoValidCardsCanBeDrawnInTheSameShuffledState(){
        ChanceDeck chanceDeck = new ChanceDeck();
        boolean validCard1 = false;
        boolean validCard2 = false;
        for (int i = 0; i < 16; i++) {
            String card = chanceDeck.drawCard();
            if (card.equals("Advance to Boardwalk.")) {
                validCard1 = true;
            }
            if (card.equals("Advance to Go (Collect $200).")) {
                validCard2 = true;
            }
            if (validCard1 && validCard2) {
                break;
            }
        }
        assertTrue(validCard1 && validCard2, "Card drawn should be 'Advance to Boardwalk.'");
    }
}