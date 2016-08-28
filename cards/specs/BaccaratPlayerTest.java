import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;
import baccaratGame.*;
import behaviours.*;
import java.util.*;

public class BaccaratPlayerTest implements Playability {
  // TODO: Create a method for dealing a card - different packs for different tests
  Pack pack;
  Shoe shoe;
  BaccaratPlayer player;
  static final int[] values = new int[]{1,2,3,4,5,6,7,8,9,0,0,0,0};

  public Player getDealer() { return null; }
  public ArrayList<Player> getPlayers() { return null; }
  public Card dealCard () { return shoe.dealCard(); }

  @Before
  public void before() {
    pack = new Pack(values);
    shoe = new Shoe(pack, false);
    player = new BaccaratPlayer("Phil");
  }

  @Test
  public void checkName() {
    assertEquals("Phil", player.getName());
  }

  @Test
  public void givePlayerAHand() {
    Hand hand = new Hand();
    player.giveCard(shoe.dealCard());
    player.giveCard(shoe.dealCard());
    assertEquals("Ace of Clubs\n2 of Clubs\n", player.showHand().toString());
    assertEquals(3, player.valueOfHand());
  }

  @Test
  public void givePlayerATurn() {
    player.giveCard(shoe.dealCard());
    player.giveCard(shoe.dealCard());
    // Value of the hand is 3 which is less than 6 so player should get another card
    player.playTurn();
    Hand hand = player.showHand();
    assertEquals(3, hand.getSize());
    assertEquals(2, player.valueOfHand());
    assertEquals("Ace of Clubs\n2 of Clubs\n9 of Hearts\n", hand.toString());
  }



}