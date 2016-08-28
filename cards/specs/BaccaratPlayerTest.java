import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;
import baccaratGame.*;

public class BaccaratPlayerTest {

  Pack pack;
  Shoe deck;
  BaccaratPlayer player;
  static final int[] values = new int[]{1,2,3,4,5,6,7,8,9,0,0,0,0};

  @Before
  public void before() {
    pack = new Pack(values);
    deck = new Shoe(pack);
    player = new BaccaratPlayer("Phil");
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
    assertEquals(3, player.valueOfHand());
  }

  @Test
  public void givePlayerATurn() {
    player.giveCard(deck.dealCard());
    player.giveCard(deck.dealCard());
    // Value of the hand is 3 which is less than 6 so player should get another card
    player.playTurn();
    Hand hand = player.showHand();
    assertEquals(3, hand.getSize());
    assertEquals(2, player.valueOfHand());
    assertEquals("Ace of Clubs\n2 of Clubs\n9 of Hearts\n", hand.toString());
  }



}