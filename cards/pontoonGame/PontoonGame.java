package pontoonGame;
import cardGameTypes.*;
import cardGame.*;
import java.util.*;

public class PontoonGame extends Game {
  
  public PontoonGame() {
    super();
  }

  public PontoonGame(String... names) {
    super();
    for (String name : names) {
      addPlayer(new PontoonPlayer(name));
    }
    addPlayer(new PontoonPlayer("Dealer"));
    setDealer();
  }

  protected Shoe buildShoe() {
    Pack pack = new Pack(new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10});
    return new Shoe(pack, 4);
  }

  public void playGame() {
    shuffleCards();
    dealHands(2);
    Player firstPlayer = getFirstPlayer();
    Player player = firstPlayer;
    do {
      player.playTurn();
      player = getNextPlayer();
    } while (player != firstPlayer);

    // work out who won.
    // Winners are those who have more points than the dealer without going bust.
    Player dealer = getDealer();
    int dealerScore = dealer.valueOfHand();
    System.out.print("The dealer was holding " + dealerScore + " points");
    if (dealerScore > 21) System.out.print(" (bust)");
    System.out.println(":");
    System.out.println(dealer.showHand());

    int playerScore;
    player = getFirstPlayer();
    do {
      playerScore = player.valueOfHand();
      if ((playerScore <= 21) && ((playerScore > dealerScore) || (dealerScore > 21))) {
        // Player beat the dealer
        System.out.println(player + " beat the dealer!");
      }
      System.out.print(player + " was holding " + playerScore + " points");
      if (playerScore > 21) System.out.print(" (bust)");
      System.out.println(":");
      System.out.println(player.showHand());
      player = getNextPlayer();
    } while (player != dealer);
  }
}