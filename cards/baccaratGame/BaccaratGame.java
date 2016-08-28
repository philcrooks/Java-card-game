package baccaratGame;
import cardGameTypes.*;
import cardGame.*;

public class BaccaratGame extends Game {

  public BaccaratGame() {
    super();
  }

  public BaccaratGame(String playerName, Shoe shoe) {
    super();
    addShoe(shoe);
    addPlayer(new BaccaratPlayer(playerName));
    addPlayer(new BaccaratPlayer("Dealer"));
    setDealer();
  }

  public Shoe buildShoe() {
    // This is called during call to super(). Have no shoe at that point.
    return null;
  }

  public void playGame() {
    dealHands(2);
    Player firstPlayer = getFirstPlayer();
    Player player = firstPlayer;
    do {
      player.playTurn();
      player = getNextPlayer();
    } while (player != firstPlayer);
  }
}