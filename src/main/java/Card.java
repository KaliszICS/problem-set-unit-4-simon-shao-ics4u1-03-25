public class Card{

    //Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
    private String name;
    //Hearts, Spades, Diamonds, Clubs
    private String suit;
    //1-13 for Ace to King
    private int value;

    //build
    public Card(String name, String suit, int value){
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    //get
    public String getName(){
        return this.name;
    }

    public String getSuit(){
        return this.suit;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return this.name + " of " + this.suit;
    }

    @Override
    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass()){
            return false;
        }

        Card card = (Card) obj;
        if (this.name.equals(card.getName())&&this.suit.equals(card.getSuit())){
            return true;
        }
        else{
            return false;
        }
    }

}