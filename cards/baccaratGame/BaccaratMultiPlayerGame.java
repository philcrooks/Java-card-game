package baccaratGame;
import cardGame.*;
import java.util.*;

public class BaccaratMultiPlayerGame {
  private ArrayList<BaccaratGame> games;

  public BaccaratMultiPlayerGame(String... players) {
    Pack pack = new BaccaratPack();
    Shoe shoe = new Shoe(pack, 4);
    shoe.shuffle();
    games = new ArrayList<BaccaratGame>();
    for (String player : players) {
      games.add(new BaccaratGame(player, shoe));
    }
  }

  public void playGames() {
    for (BaccaratGame game : games) {
      game.dealHands(2);
    }
    for (BaccaratGame game : games) {
      game.getFirstPlayer().playTurn();
      game.getNextPlayer().playTurn();  // Always the dealer
    }
    BaccaratPlayer player;
    BaccaratPlayer dealer;
    int playerScore;
    int dealerScore;
    int gameNumber = 1;
    for (BaccaratGame game : games) {
      System.out.println("*** Game #" + gameNumber + " ***" );
      player = (BaccaratPlayer)game.getFirstPlayer();
      dealer = (BaccaratPlayer)game.getNextPlayer();
      playerScore = player.valueOfHand();
      dealerScore = dealer.valueOfHand();
      if (playerScore == dealerScore) {
        System.out.println("A draw.");
      } else {
        Player winner = dealer;
        if (playerScore > dealerScore) winner = player;
        System.out.println(winner + " wins!");
      }
      System.out.println(dealer + " has " + dealerScore + " points in the following cards:");
      System.out.print(dealer.showHand());
      System.out.println(player + " has " + playerScore + " points in the following cards:");
      System.out.println(player.showHand());
      gameNumber += 1;
    }
  }
}