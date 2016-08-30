import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;
import baccaratGame.*;
import behaviours.*;
import java.util.*;

public class BaccaratPlayerTest implements Playability {
  // TODO: Create a method for dealing a card - different packs for different tests
  Pack packTwist;
  Pack packStick;
  Shoe shoe;
  BaccaratPlayer player;

  public Player getDealer() { return null; }
  public ArrayList<Player> getPlayers() { return null; }
  public Card dealCard () { return shoe.dealCard(); }

  @Before
  public void before() {
    Card spades10 = new Card(Suit.SPADES, Rank.TEN, 0);
    Card hearts5 = new Card(Suit.HEARTS, Rank.FIVE, 5);
    Card clubs6 = new Card(Suit.CLUBS, Rank.SIX, 6);
    packTwist = new GenericPack(spades10, hearts5, clubs6);
    packStick = new GenericPack(spades10, clubs6, hearts5);
    player = new BaccaratPlayer("Phil");
  }

  @Test
  public void checkName() {
    assertEquals("Phil", player.getName());
  }

  @Test
  public void givePlayerAHand() {
    shoe = new Shoe(packStick, false);
    Hand hand = new Hand();
    player.giveCard(shoe.dealCard());
    player.giveCard(shoe.dealCard());
    assertEquals("10 of Spades\n6 of Clubs\n", player.showHand().toString());
    assertEquals(6, player.valueOfHand());
  }

  @Test
  public void givePlayerATurn__Stick() {
    shoe = new Shoe(packStick, false);
    player.setGame(this);
    player.giveCard(shoe.dealCard());
    player.giveCard(shoe.dealCard());
    // Value of the hand is 3 which is less than 6 so player should get another card
    player.playTurn();
    Hand hand = player.showHand();
    assertEquals(2, hand.getSize());
    assertEquals(6, player.valueOfHand());
    assertEquals("10 of Spades\n6 of Clubs\n", player.showHand().toString());
  }

  @Test
  public void givePlayerATurn__Twist() {
    shoe = new Shoe(packTwist, false);
    player.setGame(this);
    player.giveCard(shoe.dealCard());
    player.giveCard(shoe.dealCard());
    // Value of the hand is 3 which is less than 6 so player should get another card
    player.playTurn();
    Hand hand = player.showHand();
    assertEquals(3, hand.getSize());
    assertEquals(1, player.valueOfHand());
    assertEquals("10 of Spades\n5 of Hearts\n6 of Clubs\n", player.showHand().toString());
  }


}