/**
 * contains a deck of cards which can be editted and shuffled
 * @author Simon Shao
 * @version 1.0.0
 */
import java.util.Random;

public class Deck{

    private Card[] deck;
    private String[] suitType = new String[]{"Hearts", "Clubs", "Diamonds", "Spades"};
    private String[] nameType = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};


    //build
    /**
     * initialize deck as given
     * @param deck the array of cards that is set as the deck. 
     */
    public Deck(Card[] deck){
        this.deck = deck;
    }

    /**
     * default deck of 52 cards
     * default name order of ace to king
     * default suit order of hearts, clubs, diamonds, spades
     * default value of each card as their name (ace is 1, jack, queen, king, is 11, 12, 13)
     */
    public Deck(){
        int numberOfCards = 52;
        int index = 0;
        this.deck = new Card[numberOfCards];

        //set suit
        for (int curSuit = 0; curSuit<this.suitType.length; curSuit++){
            //set name
            for (int nameIndex = 0; nameIndex<this.nameType.length; nameIndex++){
                //nameIndex +1 represents the value of the names
                this.deck[index] = new Card(this.nameType[nameIndex], this.suitType[curSuit], nameIndex+1);
                index++;
            }
        }
    }
    
    /**
     * to access how many cards are in the deck
     * @return returns the number of cards in the deck
     */
    public int size(){
        return this.deck.length;
    }

    /**
     * draws a card from the top of deck (deck's size is reduced)
     * the top of deck is the 0th index of the card array
     * @return returns the card that was drawn
     */
    public Card draw(){
        if (this.size()==0){
            return null;
        }
        Card top = this.deck[0];
        Card[] tempDeck = new Card[this.deck.length-1];
        for (int index = 0; index<tempDeck.length; index++){
            //copies all cards except the first one to temp
            tempDeck[index] = this.deck[index+1];
        }

        this.deck = new Card[tempDeck.length];

        for (int index = 0; index<this.deck.length; index++){
            //copies all cards back
            this.deck[index] = tempDeck[index];
        }

        return top;
    }

    /**
     * randomizes the order of cards in the deck
     */
    public void shuffle(){

        Random random = new Random();
        int currCards = 0;

        //make a copy
        Card[] tempDeck = new Card[this.deck.length];

        for (int index = 0; index<tempDeck.length; index++){
            //copies all cards to temp
            tempDeck[index] = this.deck[index];
        }

        this.deck = new Card[tempDeck.length];

        //this.deck[random] = tempDeck[i]
        while (currCards<this.deck.length){
            //generates a random index within bound of deck size
            int randomIndex = random.nextInt(this.deck.length);

            //if there is nothing inside
            if (this.deck[randomIndex]==null){
                this.deck[randomIndex] = tempDeck[currCards];
                currCards++;
            }
        }
    }

    //no add null
    /**
     * adds a card to the deck
     * does not allow null cards to be added
     * @param card the card that is to be added to the deck
     */
    public void addCard(Card card){
        if(card==null){
            return;
        }
        
        Card[] tempDeck = new Card[this.deck.length+1];

        for (int index = 0; index<this.size(); index++){
            //copies all cards to temp, leaving top card (0) empty
            tempDeck[index + 1] = this.deck[index];
        }

        //adds provided card to last index
        tempDeck[0] = card;

        this.deck = new Card[tempDeck.length];

        for (int index = 0; index<this.size(); index++){
            //copies all cards back
            this.deck[index] = tempDeck[index];
        }
    }

    /**
     * adds multiple cards in the form of a card array and reshuffles the deck after adding them
     * @param cards the card array that is to be added to the deck
     */
    public void reshuffle(Card[] cards){
        int deckSize = this.size() + cards.length;

        Card[] tempDeck = new Card[deckSize];
        for (int index = 0; index<this.size(); index++){
            //copies all cards to temp
            tempDeck[index] = this.deck[index];
        }
        
        for (int index = 0; index<cards.length; index++){
            tempDeck[index+this.size()] = cards[index];
        }

        this.deck = new Card[tempDeck.length];

        for (int index = 0; index<deckSize; index++){
            //copies all cards
            this.deck[index] = tempDeck[index];
        }

        this.shuffle();
    }

}