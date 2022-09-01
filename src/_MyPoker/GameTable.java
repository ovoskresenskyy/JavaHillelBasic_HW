package _MyPoker;

enum PlayerNames {
    THOR, LOKI, THANOS, JARVIS, HULK, MAGNETO
}

public class GameTable {

    public static final int[] rankValues = new int[13];
    Player[] players;
    Card[] cards = new Card[5];

    GameTable(int quantityOfPlayers) {

        fillRankValues();

        this.players = new Player[quantityOfPlayers];
        int i = 0;
        do {
            players[i] = new Player(PlayerNames.values()[i].name());
            i++;
        } while (i < quantityOfPlayers);
    }

    private void fillRankValues() {
        rankValues[0] = 1;
        rankValues[1] = 2;

        for (int i = 2; i < Ranks.values().length; i++) {
            rankValues[i] = rankValues[i - 1] + rankValues[i - 2]; //Fibonacci
        }
    }

    public int getBestCombination(Card[] playerCards, Player player) {

        Card[] temp;

        Card[][] allCardsCombinations = new Card[20][4];
        allCardsCombinations[0] = cards;

        int num = 10;
        for (int i = 0; i < cards.length; i++) {
            temp = cards.clone();
            temp[i] = playerCards[0];
            allCardsCombinations[i + 1] = temp;

            temp = cards.clone();
            temp[i] = playerCards[1];
            allCardsCombinations[i + 6] = temp;

            int j = i + 1;
            while (j < cards.length && i < cards.length - 1) {
                temp = cards.clone();
                temp[i] = playerCards[0];
                temp[j] = playerCards[1];
                allCardsCombinations[num++] = temp;
                j++;
            }
        }

        CombinationCostCalculation calculation = new CombinationCostCalculation();
        int bestCombinationValue = 0;
        for (Card[] cardsCombination : allCardsCombinations) {
            bestCombinationValue = Math.max(bestCombinationValue, calculation.getCombinationValue(cardsCombination, player));
        }

        return bestCombinationValue;
    }

    public static String printCombination(Combinations combination) {
        return switch (combination) {
            case HIGH_CARD -> "High card";
            case PAIR -> "Pair";
            case TWO_PAIRS -> "Two pairs";
            case THREE_OF_A_KIND -> "Three of a kind";
            case STRAIGHT -> "Straight";
            case FLUSH -> "Flush";
            case FOUR_OF_A_KIND -> "Four of a kind";
            case FULL_HOUSE -> "Full house";
            case STRAIGHT_FLUSH -> "Straight flush";
            case ROYAL_FLUSH -> "Royal flush";
        };
    }

    public static String printSuit(Suits suit) {
        return switch (suit) {
            case CLUBS -> "Clubs";
            case DIAMONDS -> "Diamonds";
            case HEARTS -> "Hearts";
            case SPADES -> "Spades";
        };
    }

    public static String printRank(Ranks rank) {
        return switch (rank) {
            case RANK_2 -> "2";
            case RANK_3 -> "3";
            case RANK_4 -> "4";
            case RANK_5 -> "5";
            case RANK_6 -> "6";
            case RANK_7 -> "7";
            case RANK_8 -> "8";
            case RANK_9 -> "9";
            case RANK_10 -> "10";
            case RANK_JACK -> "J";
            case RANK_QUEEN -> "Q";
            case RANK_KING -> "K";
            case RANK_ACE -> "A";
        };
    }
}
