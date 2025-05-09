/**
 * stores information of a player - their name, age, and their hand of cards
 * @author Simon Shao
 * @version 1.0.0
 */
public class Player{
    
    private String name;
    private int age;
    private Card[] hand;

    /**
     * initializes the player's information as what is given
     * @param name the string for the name of the player
     * @param age the int for the age of the player
     * @param hand the card list of the player's hand
     */
    public Player(String name, int age, Card[] hand){
        this.name = name;
        this.age = age;
        this.hand = hand;
    }

    /**
     * initializes the player's name and age, and defaults the hand as empty
     * @param name the string for the name of the player
     * @param age the int for the age of the player
     */
    public Player(String name, int age){
        this.name = name;
        this.age = age;
        this.hand = new Card[0];
    }
    /**
     * to access the name of player
     * @return returns the name of player
     */
    public String getName(){
        return this.name;
    }

    /**
     * access the age of player
     * @return returns the age of player
     */
    public int getAge(){
        return this.age;
    }

    /**
     * access the hand of player
     * @return returns the hand of player as a card array
     */
    public Card[] getHand(){
        return this.hand;
    }

    /**
     * access the number of cards in hand
     * @return returns an int value for the size of hand
     */
    public int size(){
        return this.hand.length;
    }

//nothing happens if null is drawn from deck
    /**
     * adds a card from the deck to hand
     * draws from top of card using the deck.draw() method
     */
    public void draw(Deck deck){

        Card[] tempHand = new Card[this.size()+1];
        for (int index = 0; index<this.size(); index++){
            tempHand[index] = this.hand[index];
        }

        int newCardIndex = this.size();
        Card card = deck.draw();

        if (card==null){
            return;
        }
        
        tempHand[newCardIndex] = card;

        this.hand = new Card[tempHand.length];
        for (int index = 0; index<this.size(); index++){
            this.hand[index] = tempHand[index];
        }
    }

//discardCard
    /**
     * removes a card from hand and adds it to the discard pile
     * null card can also be removed, but it won't be added to pile
     * @param card the card that is to be removed from hand and added to deck
     * @param discardPile the pile that the card removed from hand is added to
     * @return returns true if card exists in hand, false otherwise
     */
    public boolean discardCard(Card card, DiscardPile discardPile){
        int handLocation = -1;
        Card[] tempHand = new Card[this.size()];
        if (card ==null){
            for(int index = 0; index<this.size();index++){
                if (this.hand[index] == (card)){
                    handLocation = index;
                }
            } 
            if (handLocation == -1){
                return false;
            }
            return true;
        }
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
//allows null to leave hand
    /**
     * remove a card from hand and adds it to deck
     * can remove a null card
     * @param card the card that is to be removed from hand and added to deck
     * @param deck the deck to add the card to
     * @return returns true if card exists in hand, false otherwise
     */
    public boolean returnCard(Card card, Deck deck){
        int handLocation = -1;
        Card[] tempHand = new Card[this.size()];
        if (card ==null){
            for(int index = 0; index<this.size();index++){
                if (this.hand[index] == (card)){
                    handLocation = index;
                }
            } 
            if (handLocation == -1){
                return false;
            }
            return true;
        }
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
    /**
     * converts the information (name, age, hand) to a single string
     * will only have (name), (age). if hand is empty
     */
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
