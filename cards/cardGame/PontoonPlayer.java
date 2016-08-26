package cardGame;
import cardGameTypes.*;

public class PontoonPlayer extends Player {

  public PontoonPlayer( String name, Game game ) {
    super(name, game);
  }

  public void playTurn() {
    if (((PontoonGame)game).whoIsDealer() == this) {
      playDealerTurn();
    } else {
      playNonDealerTurn(((PontoonGame)game).getCardShowing());
    }
  }

  private Card twist() {
    if (game == null) {
      // We're testing
      return new Card(Suit.HEARTS, Rank.ACE, 1);
    }
    return game.dealCard();
  }

  public void playNonDealerTurn( Card dealerShowing ) {
    boolean hitMe = false;
    do {
      switch (hand.getValue()) {
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
        hand.addCard(twist());
      }
    } while (hitMe && (hand.getValue() <= 21) && (hand.getSize() <= 4));
  }

  public void playDealerTurn() {

  }

  public Card showCard() {
    if (hand == null) return null;
    return (hand.getLastCard());
  }
}