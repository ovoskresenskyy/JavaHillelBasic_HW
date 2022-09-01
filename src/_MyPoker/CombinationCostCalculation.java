package _MyPoker;

public class CombinationCostCalculation {

    private int value;

    public int getCombinationValue(Card[] cards, Player player) {

        value = 0;
        player.combinationIndex = Math.max(player.combinationIndex, 0);

        Ranks[] ranksArray = new Ranks[cards.length];
        Suits[] suitsArray = new Suits[cards.length];

        for (int i = 0; i < cards.length; i++) {
            ranksArray[i] = cards[i].rank;
            suitsArray[i] = cards[i].suit;
        }

        Ranks[] sortedRanks = sortCards(ranksArray);
        Suits[] sortedSuits = sortCards(suitsArray);

        boolean isFlush = sortedSuits[0] == sortedSuits[4];
        if (isFlush) {
            value += 5_000 * GameTable.rankValues[sortedRanks[4].ordinal()]; // Flush
            player.combinationIndex = Math.max(player.combinationIndex, 5);
        }

        boolean isStraight = findStraight(sortedRanks, player);
        if (!isStraight) {
            findSameValues(sortedRanks, player);
        }

        if (isFlush && isStraight){
            player.combinationIndex = Math.max(player.combinationIndex, cards[4].rank.ordinal() == 12 ? 9 : 8); // Royal or Straight flush
        }

        return value;
    }

    private void findSameValues(Ranks[] sortedRanks, Player player) {

        int firstSet = sortedRanks[0].ordinal();
        int secondSet = 0;
        int firstSetQuantity = 1;
        int secondSetQuantity = 1;

        int previousCardOrdinal;
        int thisCardOrdinal;

        for (int i = 1; i < sortedRanks.length; i++) {
            previousCardOrdinal = sortedRanks[i - 1].ordinal();
            thisCardOrdinal = sortedRanks[i].ordinal();

            if (firstSet == sortedRanks[i].ordinal()) {
                firstSetQuantity++; // first set qty +1
            } else {
                if (firstSetQuantity == 1) {
                    value += GameTable.rankValues[previousCardOrdinal]; // solo card value
                    value += i == 4 ? GameTable.rankValues[thisCardOrdinal] : 0; // last solo card value

                    firstSet = sortedRanks[i].ordinal(); // init first set rank
                } else {
                    if (secondSet == sortedRanks[i].ordinal()) {
                        secondSetQuantity++; // second set qty +1
                    } else {
                        if (secondSetQuantity == 1) {
                            value += previousCardOrdinal == firstSet ? 0 : GameTable.rankValues[previousCardOrdinal]; // solo card value
                            value += i == 4 ? GameTable.rankValues[thisCardOrdinal] : 0; // last solo card value

                            secondSet = sortedRanks[i].ordinal(); // init second set rank
                        } else {
                            value += GameTable.rankValues[sortedRanks[i].ordinal()]; // solo card value
                        }
                    }
                }
            }
        }

        if (firstSetQuantity == 4) {
            value += 7_000 * GameTable.rankValues[firstSet]; // Four of a kind
            player.combinationIndex = Math.max(player.combinationIndex, 7);
        } else if (firstSetQuantity == 3) {
            if (secondSetQuantity == 1) {
                value += 3_000 * GameTable.rankValues[firstSet]; // Three of a kind
                player.combinationIndex = Math.max(player.combinationIndex, 3);
            } else if (secondSetQuantity == 2) {
                value += 6_000 * GameTable.rankValues[firstSet]; // Full house
                player.combinationIndex = Math.max(player.combinationIndex, 6);
            }
        } else if (firstSetQuantity == 2) {
            value += 1_000 * GameTable.rankValues[firstSet]; // One pair
            player.combinationIndex = Math.max(player.combinationIndex, 1);
            if (secondSetQuantity == 2) {
                value += 1_000 * GameTable.rankValues[Math.max(firstSet, secondSet)]; //Two pair
                player.combinationIndex = Math.max(player.combinationIndex, 2);
            } else if (secondSetQuantity == 3) {
                value += 6_0000 * GameTable.rankValues[secondSet]; // Full house
                player.combinationIndex = Math.max(player.combinationIndex, 6);
            }
        }
    }

    private boolean findStraight(Ranks[] sortedRanks, Player player) {

        boolean isStraight = true;
        if (sortedRanks[0].ordinal() == 0
                && sortedRanks[1].ordinal() == 1
                && sortedRanks[2].ordinal() == 2
                && sortedRanks[3].ordinal() == 3
                && sortedRanks[4].ordinal() == 12) {

            value += 4_000 * GameTable.rankValues[3]; // RANK_5
            player.combinationIndex = Math.max(player.combinationIndex, 4);
            return true; //exception for 2345A
        } else {
            for (int i = 0; i < sortedRanks.length - 1; i++) {
                if (sortedRanks[i + 1].ordinal() != sortedRanks[i].ordinal() + 1) {
                    isStraight = false;
                    break;
                }
            }
        }
        if (isStraight) {
            value += 4_000 * GameTable.rankValues[sortedRanks[4].ordinal()]; // Top Rank of Straight
            player.combinationIndex = Math.max(player.combinationIndex, 4);
        }
        return isStraight;
    }

    private Ranks[] sortCards(Ranks[] ranksArray) {

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < ranksArray.length - 1; i++) {
                if (ranksArray[i].ordinal() > ranksArray[i + 1].ordinal()) {
                    isSorted = false;
                    Ranks tempRank = ranksArray[i + 1];
                    ranksArray[i + 1] = ranksArray[i];
                    ranksArray[i] = tempRank;
                }
            }
        }
        return ranksArray;
    }

    private Suits[] sortCards(Suits[] suitsArray) {

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < suitsArray.length - 1; i++) {
                if (suitsArray[i].ordinal() > suitsArray[i + 1].ordinal()) {
                    isSorted = false;
                    Suits tempRank = suitsArray[i + 1];
                    suitsArray[i + 1] = suitsArray[i];
                    suitsArray[i] = tempRank;
                }
            }
        }
        return suitsArray;
    }
}
