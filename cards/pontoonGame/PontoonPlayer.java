package pontoonGame;
import cardGameTypes.*;
import cardGame.*;
import java.util.*;

public class PontoonPlayer extends Player {

  public PontoonPlayer( String name ) {
    super(name);
  }

  public int valueOfHand() {
    if (myHand == null) return 0;
    return myHand.getValue();
  }

  public void playTurn() {
    if (amDealer) {
      playDealerTurn(myGame.getPlayers());
    } else {
      PontoonPlayer dealer = (PontoonPlayer)(myGame.getDealer());
      playNonDealerTurn(dealer.showCard());
    }
  }

  private Card hitMe() {
    if (myGame == null) {
      // We're testing
      return new Card(Suit.HEARTS, Rank.ACE, 1);
    }
    return myGame.dealCard();
  }

  public void playNonDealerTurn( Card dealerShowing ) {
    boolean twist = false;
    do {
      switch (myHand.getValue()) {
        case 15:
        case 16: twist = (dealerShowing.getValue() >= 7);
                 break;
        case 17: twist = (dealerShowing.getRank() == Rank.ACE);
                 break;
        case 18:
        case 19:
        case 20:
        case 21: twist = false;
                 break;
        default: twist = true;
                 break;
      }
      if (twist) {
        myHand.addCard(hitMe());
      }
    } while (twist && (myHand.getValue() <= 21) && (myHand.getSize() <= 4));
  }

  public void playDealerTurn(ArrayList<Player> players) {
    // Dealer is always the last to play and can see everyone else's hands.
    int maxScore = 0;
    for (Player player : players) {
      if (player != this) {
        int value = player.valueOfHand();
        if ((value > maxScore) && (value <= 21)) maxScore = value;
      }
    }
    while (myHand.getValue() < maxScore) {
      myHand.addCard(hitMe());
    }
  }

  public Card showCard() {
    if ((myHand == null) || !amDealer) return null;
    return myHand.getLastCard();
  }
}