
class ExampleClass {
    public static void main(String[] args){
        Deck deck = new Deck();
        deck.shuffle();
    //     for (int i = 0; i<52;i++){
    //         System.out.println("hello" + deck.draw()); 
    //  }

        // Deck deck2 = new Deck();
        // ;
int size = deck.size();
//         // for (int i = 0; i<size;i++){
// System.out.println(""  + size + "    " + deck.draw()); 
        // }
DiscardPile pile = new DiscardPile();

pile.addCard(deck.draw());


pile.addCard(deck.draw());
pile.addCard(deck.draw());
pile.addCard(deck.draw());
pile.addCard(deck.draw());
pile.addCard(deck.draw());


System.out.println(pile);
Card card = new Card("Queen", "Hearts", 12);
Card card2 = new Card("Queen", "Hearts", 12);
System.out.println(card.equals(card2));
DiscardPile pile2 = new DiscardPile(pile.removeAll());
System.out.println(pile);
System.out.println(pile2);
System.out.println(pile2.size());
pile2.removeCard(card);
System.out.println(pile2);

// for (int i = 0; i<hand.length; i++){

// }
Deck deck2 = new Deck();
Player p1 = new Player("Simon", 17);

p1.draw(deck2);

p1.draw(deck2);

p1.draw(deck2);

p1.draw(deck2);

System.out.println(p1);


}
}