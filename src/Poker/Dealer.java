package Poker;

class Dealer {

    Card drawCard(Card[] deck) {
        return deck[Poker.cardIndex++];
    }

    public void giveCardsToPlayers(Card[] cards, Player[] players) {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.cards[i] = drawCard(cards);
            }
        }
    }

    public void putTheFlop(Card[] cards, Card[] tablePool) {
        Poker.cardIndex++; // poker rules
        tablePool[0] = drawCard(cards);
        tablePool[1] = drawCard(cards);
        tablePool[2] = drawCard(cards);
    }

    public void putTheTurnOrRiver(Card[] cards, Card[] tablePool, int i) {
        Poker.cardIndex++; // poker rules
        tablePool[i] = drawCard(cards);
    }
}
