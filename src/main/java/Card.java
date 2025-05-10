/**
 * a card that has accessible name, suit, and value, and can be compared to other cards
 * @author Simon Shao
 * @version 1.0.0
 */
public class Card{

    //Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
    private String name;
    //Hearts, Spades, Diamonds, Clubs
    private String suit;
    //1-13 for Ace to King
    private int value;

    //build
    /**
     * makes a card object with information given
     * @param name variable for the string name of the card
     * @param suit variable for the string name for suit of the card
     * @param value variable the int value of the card
     */
    public Card(String name, String suit, int value){
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    //get
    /**
     * used to access the name of the card
     * @return returns the string for the name of the card
     */
    public String getName(){
        return this.name;
    }

    /**
     * used to access the suit of the card
     * @return returns the string for the suit of the card
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * used to access the value of the card
     * @return returns the value of card
     */
    public int getValue(){
        return this.value;
    }

    /**
     * convert the entire card to the string format of (name) of (suit)
     * @return returns the full form of the card as a string
     */
    @Override
    public String toString(){
        return this.name + " of " + this.suit + " and value of " + this.value ;
    }

    /**
     * compares two cards to see if they are identical in suit, name, value
     * @return returns true if they are identical, else it returns false
     */
    @Override
    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass()){
            return false;
        }

        Card card = (Card) obj;

        //same name, value, and suit
        if (this.name.equals(card.getName()) && this.suit.equals(card.getSuit()) && this.getValue() == card.getValue()){
            return true;
        }
        else{
            return false;
        }
    }

}