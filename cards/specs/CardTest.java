import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;
import cardGameTypes.*;

public class CardTest{

  Pack pack;
  Deck deck;

  @Before
  public void before(){
    pack = new Pack();
    deck = new Deck();
    deck.add(pack);
  }
  @Test
  public void packSizeCheck(){
    assertEquals(52,pack.size());
  }

  @Test
  public void pickACardFromPack(){
    assertEquals("Ace of Diamonds", pack.get(13).toString());
  }

  @Test
  public void deckSizeCheck() {
    deck.add(pack);
    assertEquals(104, deck.size());
  }

  @Test
  public void deckShuffle() {
    Card card = deck.get(13);
    deck.shuffle();
    assertEquals(false, card == deck.get(13));
  }

  @Test
  public void dealCard() {
    Card card = deck.get(0);
    assertEquals(card, deck.dealCard());
    assertEquals(false, card == deck.get(0));
  }

 @Test
  public void handGetsCards() {
    Hand hand = new Hand();
    for(int i=0; i<5; i++) {
      hand.takeACard(deck);
    }
    assertEquals("Ace of Clubs\n2 of Clubs\n3 of Clubs\n4 of Clubs\n5 of Clubs\n", hand.toString());
    assertEquals("6 of Clubs", deck.get(0).toString());
  }
 

}