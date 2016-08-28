package baccaratGame;
import cardGameTypes.*;
import cardGame.*;

public class BaccaratGame extends Game {
  private Shoe shoe;

  public BaccaratGame() {
    super();
  }

  public BaccaratGame(String playerName, Shoe shoe) {
    super();
    this.shoe = shoe;
    addPlayer(new BaccaratPlayer(playerName));
    addPlayer(new BaccaratPlayer("Dealer"));
    setDealer();
  }

  public Shoe buildShoe() {
    return shoe;
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