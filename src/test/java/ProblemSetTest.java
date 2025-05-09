//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class ProblemSetTest {

   //Create your tests here if you want any


   //Example Tes
   @Test
   public void cardGetter()
   {
      Card card = new Card("one", "two", 1);
      assertEquals("one", card.getName());
      card = new Card("", "two", 1);
      assertEquals("", card.getName());
      card = new Card(null, "two", 1);
      assertEquals(null, card.getName());

   }

   @Test
   public void cardGetSuit()
   {
      Card card = new Card("one", "two", 1);
      assertEquals("two", card.getSuit());
      card = new Card("one", "", 1);
      assertEquals("", card.getSuit());
      card = new Card("one", "", 1);
      assertEquals("", card.getSuit());
      card = new Card("one", null, 1);
      assertEquals(null, card.getSuit());
   }

   @Test
   public void cardGetValue()
   {
      Card card = new Card("one", "two", 1);
      assertEquals(1, card.getValue());
      card = new Card("one", "", -1);
      assertEquals(-1, card.getValue());
   }

   @Test
   public void cardToString()
   {
      Card card = new Card("one", "two", 1);
      assertEquals("one of two", card.toString());
      card = new Card("one", "", -1);
      assertEquals("one of ", card.toString());
      card = new Card("", "", -1);
      assertEquals(" of ", card.toString());
      card = new Card(null, "", -1);
      assertEquals("null of ", card.toString());
   }

   @Test
   public void cardEquals()
   {
      Card card = new Card("one", "two", 1);
      Card card2 = new Card("one", "two", 1);
      assertEquals(true, card.equals(card2));
      card2 = new Card("one", "", 0);
      assertEquals(false, card.equals(card2));
      // card = new Card(null, "", 0);
      // card2 = new Card(null, "", 0);
      // assertEquals(true, card.equals(card2));
      assertEquals(false, card.equals("hello"));
      // assertEquals(false, card.equals(null));
   }

   @Test
   public void deckSize()
   {
      Deck deck = new Deck();
      assertEquals(52, deck.size());
   Card card = new Card(null, "", 0);
   Card card2 = new Card(null, "", 0);
   Card[] cards = new Card[]{card, card2};
      deck = new Deck(cards);
      assertEquals(2, deck.size());
   }

   @Test
   public void deckDraw()
   {
      Deck deck = new Deck();
      Card card1 = new Card("Ace", "Hearts", 1);

      assertEquals(card1, deck.draw());
   Card card = new Card("a", "", 0);
   Card card2 = new Card("b", "", 0);
   Card[] cards = new Card[]{card, card2};
      deck = new Deck(cards);
      assertEquals(card, deck.draw());
      cards = new Card[]{null, null};
         deck = new Deck(cards);
         assertEquals(null, deck.draw());
      cards = new Card[0];
      deck = new Deck(cards);
      assertEquals(null, deck.draw());
   }

   @Test
   public void deckShuffle()
   {
      Deck deck = new Deck();
      Card card1 = new Card("Ace", "Hearts", 1);
      deck.shuffle();
      assertNotEquals(card1, deck.draw());
   }

   @Test
   public void deckReshuffle()
   {
      Deck deck = new Deck();
      Card card = new Card("a", "", 0);
      Card card1 = new Card("b", "", 0);
      Card card2 = new Card("null", "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      deck.reshuffle(cards);
      assertNotEquals(card1, deck.draw());
   }

   @Test
   public void deckAdd()
   {
      Deck deck = new Deck();
      deck.addCard(null);
      Card card1 = new Card("Ace", "Hearts", 1);
      deck.addCard(card1);
      assertEquals(card1, deck.draw());
   }

   @Test
   public void DiscardPileGet()
   {
      DiscardPile pile = new DiscardPile();
      Card card1 = new Card("A", "Hearts", 1);
      Card card = new Card("a", "", 0);
      Card card2 = new Card("null", "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      pile = new DiscardPile(cards);
      assertEquals(card1, pile.getDiscardPile()[1]);
   }

   @Test
   public void DiscardPileSize()
   {
      DiscardPile pile = new DiscardPile();
      assertEquals(0, pile.size());
      Card card1 = new Card("A", "Hearts", 1);
      Card card = new Card("a", "", 0);
      Card card2 = new Card("null", "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      pile = new DiscardPile(cards);
      assertEquals(3, pile.size());
   }

   @Test
   public void DiscardPileAddCard()
   {
      DiscardPile pile = new DiscardPile();
      Card card1 = new Card("A", "Hearts", 1);
      Card card = new Card("a", "", 0);
      Card card2 = new Card("null", "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      pile.addCard(card1);
      assertEquals(1, pile.size());
      pile.addCard(card2);
      assertEquals(card2, pile.getDiscardPile()[0]);
   }

   @Test
   public void DiscardPileRemoveCard()
   {
      Card card1 = new Card("A", "Hearts", 1);
      Card card = new Card("a", "", 0);
      Card card2 = new Card("null", "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      DiscardPile pile = new DiscardPile(cards);
      pile.removeCard(card1);
      assertEquals(2, pile.size());
      assertEquals(card2, pile.getDiscardPile()[1]);
      assertEquals(null, pile.removeCard(card1));
      assertEquals(card2, pile.getDiscardPile()[1]);
   }

   @Test
   public void DiscardPileRemoveAll()
   {
      Card card1 = new Card("A", "Hearts", 1);
      Card card = new Card("a", "", 0);
      Card card2 = new Card("null", "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      DiscardPile pile = new DiscardPile(cards);
      assertEquals(cards, pile.removeAll());
      assertEquals(0, pile.size());
   }

   @Test
   public void DiscardPileToString()
   {
      Card card = new Card("A", "Hearts", 1);
      Card card1 = new Card("a", "", 0);
      Card card2 = new Card("null", "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      DiscardPile pile = new DiscardPile(cards);
      assertEquals("A of Hearts, a of , null of Hearts.", pile.toString());
      pile = new DiscardPile();
      assertEquals("", pile.toString());
   }

   @Test
   public void playerGetter()
   {
      Card card = new Card("A", "Hearts", 1);
      Card card1 = new Card("a", "", 0);
      Card card2 = new Card(null, "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      Player p = new Player("s", 1, cards);
      assertEquals("s", p.getName());
      assertEquals(1, p.getAge());
      assertEquals(cards, p.getHand());  
      cards = new Card[]{card, card1, null};
      p = new Player("s", 1, cards);
      assertEquals(cards, p.getHand());  
   }

   @Test
   public void playerSize()
   {
      Card card = new Card("A", "Hearts", 1);
      Card card1 = new Card("a", "", 0);
      Card card2 = new Card(null, "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      Player p = new Player("s", 1, cards);
      assertEquals(3, p.size());
      p = new Player("s", 1);
      assertEquals(0, p.size());
      cards = new Card[]{card, card1, null};
      p = new Player("s", 1, cards);
      assertEquals(3, p.size());
   }

   @Test
   public void playerDraw()
   {
      Card card = new Card("Ace", "Hearts", 1);
      Card card1 = new Card("a", "", 0);
      Card card2 = new Card("", "Hearts", 1);
      Card[] cards = new Card[]{card, card1, card2};
      Deck deck = new Deck();
      Player p = new Player("s", 1, cards);
      p.draw(deck);
      assertEquals(card, p.getHand()[0]);
      deck = new Deck(cards);
      p.draw(deck);
      p.draw(deck);
      assertEquals(card2 , p.getHand()[2]);
      cards = new Card[]{card, card1, null};
      p = new Player("s", 1, cards);
      assertEquals(null, p.getHand()[2]);
   }

//discard

@Test
public void playerDiscardCard()
{
   Card card = new Card("Ace", "Hearts", 1);
   Card card1 = new Card("a", "", 0);
   Card card2 = new Card("", "Hearts", 1);
   Card[] cards = new Card[]{card, card1, card2};
   DiscardPile pile = new DiscardPile();
   Player p = new Player("s", 1, cards);
   p.discardCard(null, pile);
   assertEquals(3, p.size());
   assertEquals(0, pile.size());
   assertEquals(true, p.discardCard(card, pile));
   assertEquals(card1, p.getHand()[0]);
   assertEquals(1, pile.size());
   assertEquals(card, pile.getDiscardPile()[0]);
   assertEquals(false, p.discardCard(card, pile));
   assertEquals(true, p.discardCard(card1, pile));
   assertEquals(card2, p.getHand()[0]);
   assertEquals(2, pile.size());
   assertEquals(card1, pile.getDiscardPile()[0]);
}

@Test
public void playerReturnCard()
{
   Card card = new Card("Ace", "Hearts", 1);
   Card card1 = new Card("a", "", 0);
   Card card2 = new Card("", "Hearts", 1);
   Card[] cards = new Card[]{card, card1, card2};
   Deck deck = new Deck();
   Player p = new Player("s", 1, cards);
   p.returnCard(null, deck);
   assertEquals(3, p.size());
   assertEquals(52, deck.size());
   assertEquals(true, p.returnCard(card, deck));
   assertEquals(card1, p.getHand()[0]);
   assertEquals(53, deck.size());
   assertEquals(card, deck.draw());
   assertEquals(false, p.returnCard(card, deck));
   assertEquals(true, p.returnCard(card1, deck));
   assertEquals(card2, p.getHand()[0]);
   assertEquals(53, deck.size());
   assertEquals(card1, deck.draw());
}

//toString
@Test
public void playerToString()
{
   // Card card = new Card("Ace", "Hearts", 1);
   // Card card1 = new Card("a", "", 0);
   // Card card2 = new Card("", "Hearts", 1);
   // Card[] cards = new Card[]{card, card1, card2};
   // Player p = new Player("s", 1, cards);
   // assertEquals("s, 1, Ace of Hearts, a of ,  of Hearts.", p.toString());
   Card card = new Card("Ace", "Hearts", 1);
   Card card1 = new Card("a", "", 0);
   Card card2 = new Card(null, "Hearts", 1);
   Card[] cards = new Card[]{card, card1, card2};
   Player p = new Player("s", 1, cards);
   assertEquals("s, 1, Ace of Hearts, a of , null of Hearts.", p.toString());

}

}
