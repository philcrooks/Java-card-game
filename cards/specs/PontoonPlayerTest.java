import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;

public class PontoonPlayerTest{
  Pack pack;
  Deck deck;
  PontoonPlayer player;
  static final int[] values = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10};

  @Before
  public void before() {
    pack = new Pack(values);
    deck = new Deck(pack);
    player = new PontoonPlayer("Phil");
  }

  @Test
  public void checkName() {
    assertEquals("Phil", player.getName());
  }

  @Test
  public void givePlayerAHand() {
    Hand hand = new Hand();
    hand.addCard(deck.dealCard());
    hand.addCard(deck.dealCard());
    assertEquals("Ace of Clubs\n2 of Clubs\n", hand.toString());
    player.giveHand(hand);
    assertEquals(13, player.valueOfHand());
    assertEquals(hand, player.showHand());
  }

  @Test
  public void givePlayerATurn() {
    Hand hand = new Hand();
    hand.addCard(deck.dealCard());
    hand.addCard(deck.dealCard());
    player.giveHand(hand);
    // Hand has value of 13 and dealer is showing an Ace so should twist three times
    Card dealerCard = new Card(Suit.HEARTS, Rank.ACE, 11);
    player.playNonDealerTurn(dealerCard);
    hand = player.showHand();
    assertEquals(5, hand.getSize());
    assertEquals(16, hand.getValue());
    assertEquals("Ace of Clubs\n2 of Clubs\nAce of Hearts\nAce of Hearts\nAce of Hearts\n", hand.toString());
  }



}