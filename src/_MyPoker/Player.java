package _MyPoker;

class Player {

    String name;
    Card[] cards;
    public int combinationIndex;

    Player(String name){
        this.name = name;
        this.cards = new Card[2];
    }

}
