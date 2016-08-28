package baccaratGame;
import cardGameTypes.*;
import cardGame.*;
import java.util.*;

class BaccaratMulti {
  private ArrayList<BaccaratGame> games;
  private Shoe shoe;

  public void BaccaratMulti(String... players) {
    Pack pack = new Pack(new int[]{1,2,3,4,5,6,7,8,9,0,0,0,0});
    shoe = new Shoe(pack, 4);
    shoe.shuffle();
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
    for (BaccaratGame game : games) {
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
      System.out.println(dealer.showHand());
      System.out.println(player + " has " + playerScore + " points in the following cards:");
      System.out.println(player.showHand());
    }
  }
}