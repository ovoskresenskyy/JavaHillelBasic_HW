package Poker;

import java.util.Arrays;

public class Deck {

    Card[] cards = DEFAULT_DECK.clone();

    static final Card[] DEFAULT_DECK = new Card[Suits.values().length * Ranks.values().length];

    static {
        int i = 0;
        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                DEFAULT_DECK[i++] = new Card(suit, rank);
            }
        }

    }

    void shuffleDeck() {
        shuffleWithRandom();
        listDeck();
        cutTheDeck();
    }

    private void cutTheDeck() {

        int pivot = (int) (Math.random() * cards.length);
        Card[] topHalfOfDeck = Arrays.copyOf(cards, pivot);
        Card[] bottomHalfOfDeck = Arrays.copyOfRange(cards, pivot, cards.length);

        for (int i = 0; i < Math.max(topHalfOfDeck.length, bottomHalfOfDeck.length); i++) {
            if (i < bottomHalfOfDeck.length) {
                cards[i] = bottomHalfOfDeck[i];
            }
            if (i < topHalfOfDeck.length) {
                cards[i + bottomHalfOfDeck.length] = topHalfOfDeck[i];
            }
        }
    }

    private void listDeck() {
        Card[] topHalfOfDeck = Arrays.copyOf(cards, cards.length / 2);
        Card[] bottomHalfOfDeck = Arrays.copyOfRange(cards, cards.length / 2, cards.length);

        int i = cards.length - 1;
        int j = topHalfOfDeck.length - 1;
        do {
            cards[i] = topHalfOfDeck[j];
            i--;
            cards[i] = bottomHalfOfDeck[j];
            i--;
            j--;
        } while (j >= 0);
    }

    private void shuffleWithRandom() {
        for (int i = 0; i < cards.length; i++) {
            int randomIndex = (int) (Math.random() * cards.length);
            Card temp = cards[randomIndex];
            cards[randomIndex] = cards[i];
            cards[i] = temp;
        }
    }
}
