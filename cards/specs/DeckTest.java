import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;

public class DeckTest{
  Pack pack;
  Shoe deck;
  Shoe doubleDeck;
  static final int[] values = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10};

  @Before
  public void before(){
    pack = new Pack(values);
    deck = new Shoe(pack);
    doubleDeck = new Shoe(pack, 2);
  }

  @Test
  public void packSizeCheck(){
    assertEquals(52, pack.size());
  }

  @Test
  public void pickACardFromDeck(){
    assertEquals("Ace of Diamonds", deck.getCard(13).toString());
  }

  @Test
  public void deckSizeCheck() {
    deck.addPack(pack);
    assertEquals(104, deck.size());
    assertEquals(104, doubleDeck.size());
  }

  @Test
  public void cardValueCheck() {
    assertEquals(11, deck.getCard(0).getValue());
  }

  @Test
  public void deckShuffle() {
    Card card = deck.getCard(13);
    deck.shuffle();
    assertEquals(false, card == deck.getCard(13));
  }

  @Test
  public void dealCard() {
    Card card = deck.getCard(0);
    assertEquals(card, deck.dealCard());
    assertEquals(false, card == deck.getCard(0));
  }

 @Test
  public void handGetsCards() {
    Hand hand = new Hand();
    for(int i=0; i<5; i++) {
      hand.addCard(deck.dealCard());
    }
    assertEquals("Ace of Clubs\n2 of Clubs\n3 of Clubs\n4 of Clubs\n5 of Clubs\n", hand.toString());
    assertEquals("6 of Clubs", deck.getCard(0).toString());
  }
 

}