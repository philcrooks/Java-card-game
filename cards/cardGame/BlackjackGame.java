package cardGame;
import cardGameTypes.*;

public class BlackjackGame extends Game {
  
  public BlackjackGame( int numberOfPlayers ) {
    players = new BlackjackPlayer[numberOfPlayers];
  }

  public void playGame() {
    for (Player player : players) {
      player.playTurn();
    }
  }
}