package cardGame;
import cardGameTypes.*;

public class PontoonGame extends Game {

  public PontoonGame( int numberOfPlayers ) {
    players = new BlackjackPlayer[numberOfPlayers];
  }

  public void playGame() {
    for (Player player : players) {
      player.playTurn();
    }
  }
}