import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;
import baccaratGame.*;
import pontoonGame.*;

public class DeckTest{
  Pack pack;
  Pack pontoonPack;
  Pack baccaratPack;
  Shoe deck;
  Shoe doubleDeck;
  static final int[] values = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10};

  @Before
  public void before(){
    pack = new GenericPack(values);
    pontoonPack = new PontoonPack();
    baccaratPack = new BaccaratPack();
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
    assertEquals(52, deck.size());
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
    // It is possible that the card won't move!!!
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

  @Test
  public void baccaratPack() {
    for (Card card : baccaratPack.getCards()) {
      switch (card.getRank()) {
        case ACE:   assertEquals(1, card.getValue()); break;
        case TWO:   assertEquals(2, card.getValue()); break;
        case THREE: assertEquals(3, card.getValue()); break;
        case FOUR:  assertEquals(4, card.getValue()); break;
        case FIVE:  assertEquals(5, card.getValue()); break;
        case SIX:   assertEquals(6, card.getValue()); break;
        case SEVEN: assertEquals(7, card.getValue()); break;
        case EIGHT: assertEquals(8, card.getValue()); break;
        case NINE:  assertEquals(9, card.getValue()); break;
        case TEN:   assertEquals(0, card.getValue()); break;
        case JACK:  assertEquals(0, card.getValue()); break;
        case QUEEN: assertEquals(0, card.getValue()); break;
        case KING:  assertEquals(0, card.getValue()); break;
      }
    }
  }
 
  @Test
  public void pontoonPack() {
    for (Card card : pontoonPack.getCards()) {
      switch (card.getRank()) {
        case ACE:   assertEquals(11, card.getValue()); break;
        case TWO:   assertEquals(2, card.getValue()); break;
        case THREE: assertEquals(3, card.getValue()); break;
        case FOUR:  assertEquals(4, card.getValue()); break;
        case FIVE:  assertEquals(5, card.getValue()); break;
        case SIX:   assertEquals(6, card.getValue()); break;
        case SEVEN: assertEquals(7, card.getValue()); break;
        case EIGHT: assertEquals(8, card.getValue()); break;
        case NINE:  assertEquals(9, card.getValue()); break;
        case TEN:   assertEquals(10, card.getValue()); break;
        case JACK:  assertEquals(10, card.getValue()); break;
        case QUEEN: assertEquals(10, card.getValue()); break;
        case KING:  assertEquals(10, card.getValue()); break;
      }
    }
  }
}