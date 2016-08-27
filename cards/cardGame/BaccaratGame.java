package cardGame;
import cardGameTypes.*;

public class BaccaratGame extends Game {

  public BaccaratGame( int numberOfPlayers ) {

  }

  public Deck buildDeck() {
    Pack pack = new Pack(new int[]{1,2,3,4,5,6,7,8,9,0,0,0,0});
    return new Deck(pack);
  }

  public void playGame() {

  }
}