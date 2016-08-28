import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;
import baccaratGame.*;

public class BaccaratGameTest {
  BaccaratGame game;
  Pack pack;
  Shoe shoe;
  static final int[] values = new int[]{1,2,3,4,5,6,7,8,9,0,0,0,0};
  
  @Before
  public void before(){
    pack = new Pack(values);
    shoe = new Shoe(pack);
    game = new BaccaratGame("Phil", shoe);
  }

  @Test
  public void checkGame() {
    Player player = game.getFirstPlayer();
    Player dealer = game.getNextPlayer();
    assertEquals("Phil", player.getName());
    assertEquals(true, game.isDealer(dealer));
    assertEquals("Ace of Clubs", game.dealCard().toString());
  }
}