/**
 * contains a deck of cards
 */

import java.util.HashMap;
import java.util.Random;

public class Deck{

    private Card[] deck;


    //build
    public Deck(Card[] deck){
        this.deck = deck;
    }

    public Deck(){
        int numberOfCards = 52;
        int index = 0;
        String[] suitType = new String[]{"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] nameType = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        this.deck = new Card[numberOfCards];

        //set suit
        for (int curSuit = 0; curSuit<suitType.length; curSuit++){
            //set name
            for (int nameValue = 0; nameValue<nameType.length; nameValue++){
                this.deck[index] = new Card(nameType[nameValue], suitType[curSuit], nameValue);
                index++;
            }
        }
    }
    
    public int size(){
        return this.deck.length;
    }

    public Card draw(){
        if (this.size()==0){
            return null;
        }
        Card top = this.deck[0];
        if (this.size() == 0){
            return null;
        }
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

    public void reshuffle(Card[] cards){
        int deckSize = this.size() + cards.length;

        Card[] tempDeck = new Card[deckSize];
        for (int index = 0; index<this.size(); index++){
            //copies all cards to temp
            tempDeck[index] = this.deck[index];
        }
        
        for (int index = 0; index<cards.length; index++){
            //rewrite this later or rename the variables
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