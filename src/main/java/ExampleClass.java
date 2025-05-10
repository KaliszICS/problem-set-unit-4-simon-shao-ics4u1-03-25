
class ExampleClass {
    public static void main(String[] args){
    //testing: Card

    Card card = new Card("One", "happy", 1);
    Deck deck = new Deck();
    deck.shuffle();
    int size = deck.size();
    for (int i = 0; i <size; i++){
        System.out.println(deck.draw());
    }
    }
}