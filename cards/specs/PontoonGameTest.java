import static org.junit.Assert.*;
import org.junit.*;
import pontoonGame.*;

public class PontoonGameTest {
  PontoonGame game;
  PontoonPlayer player1;
  PontoonPlayer player2;
  PontoonPlayer player3;

  @Before
  public void before(){
    game = new PontoonGame();
    player1 = new PontoonPlayer("Matthew");
    player2 = new PontoonPlayer("Mark");
    player3 = new PontoonPlayer("Luke");
  }

  @Test
  public void checkEmptyGroup() {
    assertEquals(null, game.setDealer());
    assertEquals(null, game.setDealer("Matthew"));
    assertEquals(null, game.setDealer(player1));
    assertEquals(null, game.getFirstPlayer());
    assertEquals(null, game.getNextPlayer());
    assertEquals(false, game.isDealer(player1));
  }

  @Test
  public void checkGroupWithOnePlayer() {
    game.addPlayer(player1);
    assertEquals(player1, game.setDealer());
    assertEquals(player1, game.setDealer("Matthew"));
    assertEquals(player1, game.setDealer(player1));
    assertEquals(player1, game.getFirstPlayer());
    assertEquals(player1, game.getNextPlayer());
    assertEquals(true, game.isDealer(player1));
  }

  @Test
  public void checkGroupWithOnePlayerForError() {
    game.addPlayer(player1);
    assertEquals(null, game.getFirstPlayer());
    assertEquals(null, game.setDealer("Mark"));
    assertEquals(null, game.setDealer(player2));
    assertEquals(null, game.getNextPlayer());
    assertEquals(false, game.isDealer(player2));
  }

  @Test
  public void checkGroupWithTwoPlayersDefaultDealer() {
    game.addPlayer(player1);
    game.addPlayer(player2);
    assertEquals(player2, game.setDealer());
    assertEquals(true, game.isDealer(player2));
    assertEquals(false, game.isDealer(player1));
    assertEquals(player1, game.getFirstPlayer());
    assertEquals(player2, game.getNextPlayer());
    assertEquals(player1, game.getNextPlayer());
  }

  @Test
  public void checkGroupWithTwoPlayersNonDefaultDealer() {
    game.addPlayer(player1);
    game.addPlayer(player2);
    assertEquals(player1, game.setDealer("Matthew"));
    assertEquals(true, game.isDealer(player1));
    assertEquals(false, game.isDealer(player2));
    assertEquals(player2, game.getFirstPlayer());
    assertEquals(player1, game.getNextPlayer());
  }

  @Test
  public void checkGroupWithThreePlayersDefaultDealer() {
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.addPlayer(player3);
    assertEquals(player3, game.setDealer());
    assertEquals(true, game.isDealer(player3));
    assertEquals(false, game.isDealer(player1));
    assertEquals(false, game.isDealer(player2));
    assertEquals(player1, game.getFirstPlayer());
    assertEquals(player2, game.getNextPlayer());
    assertEquals(player3, game.getNextPlayer());
    assertEquals(player1, game.getNextPlayer());
  }

  @Test
  public void checkGroupWithThreePlayersNonDefaultDealer() {
    game.addPlayer(player1);
    game.addPlayer(player2);
    assertEquals(player2, game.setDealer());
    game.addPlayer(player3);
    assertEquals(true, game.isDealer(player2));
    assertEquals(false, game.isDealer(player1));
    assertEquals(false, game.isDealer(player3));
    assertEquals(player3, game.getFirstPlayer());
    assertEquals(player1, game.getNextPlayer());
    assertEquals(player2, game.getNextPlayer());
    assertEquals(player3, game.getNextPlayer());
    assertEquals(player1, game.setDealer(player1));
    assertEquals(player2, game.getFirstPlayer());
  }

  @Test
  public void dealHandToGroupWithThreePlayers() {
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.addPlayer(player3);
    game.setDealer(player2);
    game.dealHands(2);
    assertEquals("2 of Clubs\n5 of Clubs\n", player1.showHand().toString());
    assertEquals("3 of Clubs\n6 of Clubs\n", player2.showHand().toString());
    assertEquals("Ace of Clubs\n4 of Clubs\n", player3.showHand().toString());
    assertEquals("7 of Clubs", game.dealCard().toString());
  }

  @Test
  public void newGameWithFourNamedPlayers() {
    PontoonGame newGame = new PontoonGame("Matthew", "Mark", "Luke", "John");
    newGame.dealHands(2);
    assertEquals("Ace of Clubs\n6 of Clubs\n", newGame.getFirstPlayer().showHand().toString());
    assertEquals("2 of Clubs\n7 of Clubs\n", newGame.getNextPlayer().showHand().toString());
    assertEquals("3 of Clubs\n8 of Clubs\n", newGame.getNextPlayer().showHand().toString());
    assertEquals("4 of Clubs\n9 of Clubs\n", newGame.getNextPlayer().showHand().toString());
    PontoonPlayer player = (PontoonPlayer)newGame.getNextPlayer();
    assertEquals(true, newGame.isDealer(player));
    assertEquals("5 of Clubs\n10 of Clubs\n", player.showHand().toString());
    assertEquals("Ace of Clubs\n6 of Clubs\n", newGame.getNextPlayer().showHand().toString());
  }

  @Test
  public void runGame() {
    PontoonGame newGame = new PontoonGame("Matthew", "Mark", "Luke", "John");
    System.out.println();
    newGame.playGame();
  }
}