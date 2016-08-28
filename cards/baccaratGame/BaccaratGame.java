package baccaratGame;
import cardGameTypes.*;
import cardGame.*;

public class BaccaratGame extends Game {
  private Shoe shoeOfCards;

  public BaccaratGame() {
    super();
  }

  public BaccaratGame(String name, Shoe shoe) {
    super();
    shoeOfCards = shoe;
    addPlayer(new BaccaratPlayer(name));
    addPlayer(new BaccaratPlayer("Dealer"));
    setDealer();
  }

  public Shoe buildShoe() {
    return shoeOfCards;
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