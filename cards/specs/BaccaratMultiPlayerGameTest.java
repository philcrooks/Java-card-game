import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import baccaratGame.*;

public class BaccaratMultiPlayerGameTest {
  BaccaratMultiPlayerGame game;
  
  @Before
  public void before(){
    game = new BaccaratMultiPlayerGame("Matthew", "Mark", "Luke", "John");
  }

  @Test
  public void runGames() {
    game.playGames();
  }
}