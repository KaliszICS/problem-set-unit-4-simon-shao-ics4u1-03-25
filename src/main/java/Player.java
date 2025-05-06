public class Player{
    
    private String name;
    private int age;
    private Card[] hand;

    public Player(String name, int age, Card[] hand){
        this.name = name;
        this.age = age;
        this.hand = hand;
    }

    public Player(String name, int age){
        this.name = name;
        this.age = age;
        this.hand = new Card[0];
    }

    public int size(){
        return this.hand.length;
    }

    public void draw(Deck deck){
        Card[] tempHand = new Card[this.size()+1];
        for (int index = 0; index<this.size(); index++){
            tempHand[index] = this.hand[index];
        }

        int newCardIndex = this.size();
        tempHand[newCardIndex] = deck.draw();

        this.hand = new Card[tempHand.length];
        for (int index = 0; index<this.size(); index++){
            this.hand[index] = tempHand[index];
        }
    }
//discardCard
    public boolean discardCard(Card card, DiscardPile discardPile){
        int handLocation = -1;
        Card[] tempHand = new Card[this.size()];

        //check if hand has card
        for(int index = 0; index<this.size();index++){
            if (this.hand[index].equals(card)){
                handLocation = index;
            }
        }

        if (handLocation == -1){
            return false;
        }

        for (int index = 0; index<handLocation; index++){
            tempHand[index] = this.hand[index];
        }
        //copy everything after card to be removed into temp, pushed to the left of index by 1 in temp
        //this leaves last index in temp null
        for (int index = handLocation+1; index<this.size(); index++){
            tempHand[index-1] = this.hand[index];
        }

        this.hand = new Card[this.size()-1];
        //copy everything from temp back
        for (int index = 0; index<this.size(); index++){
            this.hand[index] = tempHand[index];
        }

        discardPile.addCard(card);
        return true;
    }

//returnCard
    public boolean returnCard(Card card, Deck deck){
        int handLocation = -1;
        Card[] tempHand = new Card[this.size()];

        //check if hand has card
        for(int index = 0; index<this.size();index++){
            if (this.hand[index].equals(card)){
                handLocation = index;
            }
        }

        if (handLocation == -1){
            return false;
        }

        for (int index = 0; index<handLocation; index++){
            tempHand[index] = this.hand[index];
        }
        //copy everything after card to be removed into temp, pushed to the left of index by 1 in temp
        //this leaves last index in temp null
        for (int index = handLocation+1; index<this.size(); index++){
            tempHand[index-1] = this.hand[index];
        }

        this.hand = new Card[this.size()-1];
        //copy everything from temp back
        for (int index = 0; index<this.size(); index++){
            this.hand[index] = tempHand[index];
        }

        deck.addCard(card);
        return true;
    }

//toString
    public String toString(){
        //returns just name and age if hand is empty
        if (this.size() == 0){
            return this.name + ", " + this.age + ".";
        }

        String playerInfo = this.name + ", " + this.age + ", ";
        
        //add all card to info except last
        for (int index = 0; index<this.size()-1;index++){
            playerInfo = playerInfo + this.hand[index].toString() + ", ";
        }

        //add last card with period
        playerInfo = playerInfo + this.hand[this.size()-1] + ".";
        return playerInfo;
    }
}
