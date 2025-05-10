/**
 * contains an array of cards, which can be added to or removed from
 */
public class DiscardPile{

    private Card[] pile;

    /**
     * initializes an empty card list
     */
    public DiscardPile(){
        this.pile = new Card[0];
    }

    /**
     * initializes discard pile as the card array given
     * @param pile the array of cards that is set as the discard pile
     */
    public DiscardPile(Card[] pile){
        this.pile = pile;
    }    

    //getter
    /**
     * to access the array of the card pile
     * @return returns the discard pile as an array of cards
     */
    public Card[] getDiscardPile(){
        return this.pile;
    }

    //size
    /**
     * to access how many cards are in the discard pile
     * @return returns an int as the number of cards in the pile
     */
    public int size(){
        return this.pile.length;
    }

    /**
     * adds a card to the top of the pile (index 0)
     * does not allow null cards to be added
     * @param card the card to be added to the pile
     */
    public void addCard (Card card){
        if (card==null){
            return;
        }
        Card[] tempPile = new Card[this.size()+1];
        
        for (int index = 0; index<this.size(); index++){
            tempPile[index+1] = this.pile[index];
        }

        tempPile[0] = card;

        this.pile = new Card[tempPile.length];
        for (int index = 0; index<this.size(); index++){
            this.pile[index] = tempPile[index];
        }

    }

    //removeCard
    /**
     * removes a card from the pile and returns it
     * returns null if the card was not found
     * if multiple identical cards exists, the last identical card will be removed
     * @param card the card that is to be removed from the pile
     * @return returns the card that was removed
     */
    public Card removeCard(Card card){
        Card[] tempPile = new Card[this.size()];
        int cardLocation = -1;
        //check if contains
        for(int index = 0; index<this.size();index++){
            if (this.pile[index].equals(card)){
                cardLocation = index;
            }
        }

        if (cardLocation == -1){
            return null;
        }
        //copy everything before card to be removed
        for (int index = 0; index<cardLocation; index++){
            tempPile[index] = this.pile[index];
        }
        //copy everything after card to be removed into tempPile, pushed to the left of index by 1 in temp
        //this leaves last index in temp null
        for (int index = cardLocation+1; index<this.size(); index++){
            tempPile[index-1] = this.pile[index];
        }

        this.pile = new Card[this.size()-1];
        //copy everything from temp back
        for (int index = 0; index<this.size(); index++){
            this.pile[index] = tempPile[index];
        }

        return card;
    }

    //removeAll
    /**
     * empties the pile
     * @return returns the card array of the pile
     */
    public Card[] removeAll(){
        Card[] tempCard = this.pile;

        this.pile = new Card[0];

        return tempCard;
    }

    //toString
    /**
     * converts the array of cards in the pile to a string seperated by comma and ends with a period
     * @return returns the string version of the card list
     */
    @Override
    public String toString(){
        String pileString = "";
        if (this.size() == 0){
            return pileString;
        }
        for (int index = 0; index<this.size()-1;index++){
            pileString = pileString + this.pile[index].toString() + ", ";
        }

        pileString = pileString + this.pile[this.size()-1] + ".";
        return pileString;
    }
}
