import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;
import pontoonGame.*;
import behaviours.*;
import java.util.*;

public class PontoonPlayerTest implements Playability {
  // TODO: Create a method for dealing a card - different packs for different tests
  Pack packStick;
  Pack packTwist;
  Pack packAcesLow;
  PontoonPlayer player;
  Shoe shoe;

  public Player getDealer() { return null; }
  public ArrayList<Player> getPlayers() { return null; }
  public Card dealCard () { return shoe.dealCard(); }

  @Before
  public void before() {
    Card spades10 = new Card(Suit.SPADES, Rank.TEN, 10);
    Card heartsAce = new Card(Suit.HEARTS, Rank.ACE, 11);
    Card spadesAce = new Card(Suit.SPADES, Rank.ACE, 11);
    Card clubs6 = new Card(Suit.CLUBS, Rank.SIX, 6);
    Card diamonds4 = new Card(Suit.DIAMONDS, Rank.FOUR, 4);
    packStick = new GenericPack(spades10, heartsAce, clubs6);
    packTwist = new GenericPack(spades10, clubs6, diamonds4);
    packAcesLow = new GenericPack(heartsAce, diamonds4, spadesAce, spades10, clubs6);
    player = new PontoonPlayer("Phil");
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
    assertEquals("10 of Spades\nAce of Hearts\n", player.showHand().toString());
    assertEquals(21, player.valueOfHand());
  }

  @Test
  public void givePlayerATurn__Stick() {
    shoe = new Shoe(packStick, false);
    player.setGame(this);
    player.giveCard(shoe.dealCard());
    player.giveCard(shoe.dealCard());
    // Hand has value of 13 and dealer is showing an Ace so should twist three times
    Card dealerCard = new Card(Suit.SPADES, Rank.ACE, 11);
    player.playNonDealerTurn(dealerCard);
    Hand hand = player.showHand();
    assertEquals(2, hand.getSize());
    assertEquals(21, player.valueOfHand());
    assertEquals("10 of Spades\nAce of Hearts\n", player.showHand().toString());
  }

  @Test
  public void givePlayerATurn__Twist() {
    shoe = new Shoe(packTwist, false);
    player.setGame(this);
    player.giveCard(shoe.dealCard());
    player.giveCard(shoe.dealCard());
    // Hand has value of 13 and dealer is showing an Ace so should twist three times
    Card dealerCard = new Card(Suit.SPADES, Rank.ACE, 11);
    player.playNonDealerTurn(dealerCard);
    Hand hand = player.showHand();
    assertEquals(3, hand.getSize());
    assertEquals(20, player.valueOfHand());
    assertEquals("10 of Spades\n6 of Clubs\n4 of Diamonds\n", player.showHand().toString());
  }

  @Test
  public void givePlayerATurn__TwistAcesLow() {
    shoe = new Shoe(packAcesLow, false);
    player.setGame(this);
    player.giveCard(shoe.dealCard());
    player.giveCard(shoe.dealCard());
    // Hand has value of 13 and dealer is showing an Ace so should twist three times
    Card dealerCard = new Card(Suit.SPADES, Rank.ACE, 11);
    player.playNonDealerTurn(dealerCard);
    Hand hand = player.showHand();
    assertEquals(5, hand.getSize());
    assertEquals(22, player.valueOfHand());
    assertEquals("Ace of Hearts\n4 of Diamonds\nAce of Spades\n10 of Spades\n6 of Clubs\n", player.showHand().toString());
  }

}