import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;

public class PlayerGroupTest {
  PlayerGroup group;
  PontoonPlayer player1;
  PontoonPlayer player2;
  PontoonPlayer player3;
  Pack pack;
  Deck deck;

  @Before
  public void before(){
    pack = new Pack(new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10});
    deck = new Deck(pack);
    group = new PlayerGroup(deck);
    player1 = new PontoonPlayer("Matthew");
    player2 = new PontoonPlayer("Mark");
    player3 = new PontoonPlayer("Luke");
  }

  @Test
  public void checkEmptyGroup() {
    assertEquals(null, group.setDealer());
    assertEquals(null, group.setDealer("Matthew"));
    assertEquals(null, group.setDealer(player1));
    assertEquals(null, group.getFirstPlayer());
    assertEquals(null, group.getNextPlayer());
    assertEquals(false, group.isDealer(player1));
  }

  @Test
  public void checkGroupWithOnePlayer() {
    group.addPlayer(player1);
    assertEquals(player1, group.setDealer());
    assertEquals(player1, group.setDealer("Matthew"));
    assertEquals(player1, group.setDealer(player1));
    assertEquals(player1, group.getFirstPlayer());
    assertEquals(player1, group.getNextPlayer());
    assertEquals(true, group.isDealer(player1));
  }

  @Test
  public void checkGroupWithOnePlayerForError() {
    group.addPlayer(player1);
    assertEquals(null, group.getFirstPlayer());
    assertEquals(null, group.setDealer("Mark"));
    assertEquals(null, group.setDealer(player2));
    assertEquals(null, group.getNextPlayer());
    assertEquals(false, group.isDealer(player2));
  }

  @Test
  public void checkGroupWithTwoPlayersDefaultDealer() {
    group.addPlayer(player1);
    group.addPlayer(player2);
    assertEquals(player2, group.setDealer());
    assertEquals(true, group.isDealer(player2));
    assertEquals(false, group.isDealer(player1));
    assertEquals(player1, group.getFirstPlayer());
    assertEquals(player2, group.getNextPlayer());
    assertEquals(player1, group.getNextPlayer());
  }

  @Test
  public void checkGroupWithTwoPlayersNonDefaultDealer() {
    group.addPlayer(player1);
    group.addPlayer(player2);
    assertEquals(player1, group.setDealer("Matthew"));
    assertEquals(true, group.isDealer(player1));
    assertEquals(false, group.isDealer(player2));
    assertEquals(player2, group.getFirstPlayer());
    assertEquals(player1, group.getNextPlayer());
  }

  @Test
  public void checkGroupWithThreePlayersDefaultDealer() {
    group.addPlayer(player1);
    group.addPlayer(player2);
    group.addPlayer(player3);
    assertEquals(player3, group.setDealer());
    assertEquals(true, group.isDealer(player3));
    assertEquals(false, group.isDealer(player1));
    assertEquals(false, group.isDealer(player2));
    assertEquals(player1, group.getFirstPlayer());
    assertEquals(player2, group.getNextPlayer());
    assertEquals(player3, group.getNextPlayer());
    assertEquals(player1, group.getNextPlayer());
  }

  @Test
  public void checkGroupWithThreePlayersNonDefaultDealer() {
    group.addPlayer(player1);
    group.addPlayer(player2);
    assertEquals(player2, group.setDealer());
    group.addPlayer(player3);
    assertEquals(true, group.isDealer(player2));
    assertEquals(false, group.isDealer(player1));
    assertEquals(false, group.isDealer(player3));
    assertEquals(player3, group.getFirstPlayer());
    assertEquals(player1, group.getNextPlayer());
    assertEquals(player2, group.getNextPlayer());
    assertEquals(player3, group.getNextPlayer());
    assertEquals(player1, group.setDealer(player1));
    assertEquals(player2, group.getFirstPlayer());
  }

  @Test
  public void dealHandToGroupWithThreePlayers() {
    group.addPlayer(player1);
    group.addPlayer(player2);
    group.addPlayer(player3);
    group.setDealer(player2);
    group.dealHands(2);
    assertEquals("2 of Clubs\n5 of Clubs\n", player1.showHand().toString());
    assertEquals("3 of Clubs\n6 of Clubs\n", player2.showHand().toString());
    assertEquals("Ace of Clubs\n4 of Clubs\n", player3.showHand().toString());
    assertEquals("7 of Clubs", group.dealCard().toString());
  }
}