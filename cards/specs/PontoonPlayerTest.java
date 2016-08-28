import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;
import pontoonGame.*;

public class PontoonPlayerTest{
  Pack pack;
  Shoe deck;
  PontoonPlayer player;
  static final int[] values = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10};

  @Before
  public void before() {
    pack = new Pack(values);
    deck = new Shoe(pack);
    player = new PontoonPlayer("Phil");
  }

  @Test
  public void checkName() {
    assertEquals("Phil", player.getName());
  }

  @Test
  public void givePlayerAHand() {
    Hand hand = new Hand();
    player.giveCard(deck.dealCard());
    player.giveCard(deck.dealCard());
    assertEquals("Ace of Clubs\n2 of Clubs\n", player.showHand().toString());
    assertEquals(13, player.valueOfHand());
  }

  @Test
  public void givePlayerATurn() {
    player.giveCard(deck.dealCard());
    player.giveCard(deck.dealCard());
    // Hand has value of 13 and dealer is showing an Ace so should twist three times
    Card dealerCard = new Card(Suit.HEARTS, Rank.ACE, 11);
    player.playNonDealerTurn(dealerCard);
    Hand hand = player.showHand();
    assertEquals(5, hand.getSize());
    assertEquals(16, player.valueOfHand());
    assertEquals("Ace of Clubs\n2 of Clubs\nAce of Hearts\nAce of Hearts\nAce of Hearts\n", hand.toString());
  }

}