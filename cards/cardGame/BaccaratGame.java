package cardGame;
import cardGameTypes.*;

public class BaccaratGame extends Game {

  public BaccaratGame( int numberOfPlayers ) {
    players = new BaccaratPlayer[numberOfPlayers];
  }

  public void playGame() {
    for (BaccaratPlayer player : (BaccaratPlayer[])players) {
      player.playTurn();
    }
  }
}