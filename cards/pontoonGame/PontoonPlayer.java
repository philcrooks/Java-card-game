package pontoonGame;
import cardGameTypes.*;
import cardGame.*;
import java.util.*;

public class PontoonPlayer extends Player {

  public PontoonPlayer( String name ) {
    super(name);
  }

  public int valueOfHand() {
    // TODO: find some way of revaluing the hand for low value od aces.
    if (myHand == null) return 0;
    return myHand.getValue();
  }

  public int revalueHand() {
    // Player is bust and needs to devalue the first non-devalued Ace
    Card myCard;
    for (int c = 0; c < myHand.getSize(); c++) {
      myCard = myHand.getCard(c);
      if ((myCard.getRank() == Rank.ACE) && (myCard.getValue() == 11)) {
        Card newCard = myCard.revalue(1);
        myHand.replaceCard(myCard, newCard);
        break;
      }
    }
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
        if (valueOfHand() > 21) revalueHand();
      }
    } while (twist && (valueOfHand() <= 21) && (myHand.getSize() <= 4));
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
    while ((myHand.getValue() < maxScore) && (myHand.getValue() < 21) && (myHand.getSize() <= 4)) {
      myHand.addCard(hitMe());
    }
  }

  public Card showCard() {
    if ((myHand == null) || !amDealer) return null;
    return myHand.getLastCard();
  }
}