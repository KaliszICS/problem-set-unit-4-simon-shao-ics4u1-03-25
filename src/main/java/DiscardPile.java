

public class DiscardPile{

    private Card[] pile;


    public DiscardPile(){
        this.pile = new Card[0];
    }

    public DiscardPile(Card[] pile){
        this.pile = pile;
    }    

    //getter
    public Card[] getDiscardPile(){
        return this.pile;
    }

    //size
    public int size(){
        return this.pile.length;
    }

    //addCard
    public void addCard (Card card){
        Card[] tempPile = new Card[this.size()+1];
        
        for (int index = 0; index<this.size(); index++){
            tempPile[index] = this.pile[index];
        }

        int newCardIndex = this.size();
        tempPile[newCardIndex] = card;

        this.pile = new Card[tempPile.length];
        for (int index = 0; index<this.size(); index++){
            this.pile[index] = tempPile[index];
        }

    }

    //removeCard
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
    public Card[] removeAll(){
        Card[] tempCard = this.pile;

        this.pile = new Card[0];

        return tempCard;
    }
    //toString
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
