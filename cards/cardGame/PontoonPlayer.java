package cardGame;
import cardGameTypes.*;

public class PontoonPlayer extends Player {

  public PontoonPlayer( String name ) {
    super(name);
  }

  public void playTurn() {
    if (amDealer) {
      playDealerTurn();
    } else {
      PontoonPlayer dealer = (PontoonPlayer)(myGame.getDealer());
      playNonDealerTurn(dealer.showCard());
    }
  }

  private Card twist() {
    if (myGame == null) {
      // We're testing
      return new Card(Suit.HEARTS, Rank.ACE, 1);
    }
    return myGame.dealCard();
  }

  public void playNonDealerTurn( Card dealerShowing ) {
    boolean hitMe = false;
    do {
      switch (myHand.getValue()) {
        case 15:
        case 16: hitMe = (dealerShowing.getValue() >= 7);
                 break;
        case 17: hitMe = (dealerShowing.getRank() == Rank.ACE);
                 break;
        case 18:
        case 19:
        case 20:
        case 21: hitMe = false;
                 break;
        default: hitMe = true;
                 break;
      }
      if (hitMe) {
        myHand.addCard(twist());
      }
    } while (hitMe && (myHand.getValue() <= 21) && (myHand.getSize() <= 4));
  }

  public void playDealerTurn() {

  }

  public Card showCard() {
    if ((myHand == null) || !amDealer) return null;
    return myHand.getLastCard();
  }
}