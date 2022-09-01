package Poker;

public class Poker {
    public static int cardIndex;

    public static void main(String[] args) {

        GameTable gameTable = new GameTable(6);
        Dealer dealer = new Dealer();
        Deck deck = new Deck();
        deck.shuffleDeck();

        cardIndex = 0;

        dealer.giveCardsToPlayers(deck.cards, gameTable.players);
        dealer.putTheFlop(deck.cards, gameTable.cards);
        dealer.putTheTurnOrRiver(deck.cards, gameTable.cards, 3);
        dealer.putTheTurnOrRiver(deck.cards, gameTable.cards, 4);

        System.out.println("Super hero poker!");
        System.out.print("Cards on board: ");

        for (Card card : gameTable.cards) {
            System.out.print(GameTable.printRank(card.rank) + " " + GameTable.printSuit(card.suit) + "  ");
        }
        System.out.println();
        System.out.println();

        int playersBestCombinationValue;
        int bestOfAllCombinationValue = 0;
        String winner = "";

        for (Player player : gameTable.players) {

            playersBestCombinationValue = gameTable.getBestCombination(player.cards, player);

            if (playersBestCombinationValue > bestOfAllCombinationValue) {
                bestOfAllCombinationValue = playersBestCombinationValue;
                winner = player.name;
            }

            System.out.println("Player: " + player.name);
            System.out.println("Hand cards: " + GameTable.printRank(player.cards[0].rank) + " " + GameTable.printSuit(player.cards[0].suit)
                    + "  " + GameTable.printRank(player.cards[1].rank) + " " + GameTable.printSuit(player.cards[1].suit));

            System.out.println("With Best combination: " + GameTable.printCombination(Combinations.values()[player.combinationIndex]));
            System.out.println("value: " + playersBestCombinationValue);
            System.out.println();
        }

        System.out.println("============================");
        System.out.println("Winner: " + winner);
        System.out.println("============================");
    }
}
