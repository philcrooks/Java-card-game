package baccaratGame;
import cardGameTypes.*;
import cardGame.*;

public class BaccaratPlayer extends Player {
  Card thirdCard;

  public BaccaratPlayer( String name ) {
    super(name);
    thirdCard = null;
  }

  public int valueOfHand() {
    if (myHand == null) return 0;
    return myHand.getValue() % 10;
  }

  private void playDealerTurn() {
    if (thirdCard == null) {
      if (valueOfHand() < 6) {
        myHand.addCard(myGame.dealCard());
      }
    } else {
      int value3rd = thirdCard.getValue();
      switch(valueOfHand()) {
        case 0:
        case 1:
        case 2: myHand.addCard(myGame.dealCard());
                break;
        case 3: if (value3rd != 8) myHand.addCard(myGame.dealCard());
                break;
        case 4: if ((value3rd >= 2) && (value3rd <= 7)) myHand.addCard(myGame.dealCard());
                break;
        case 5: if ((value3rd >= 4) && (value3rd <= 7)) myHand.addCard(myGame.dealCard());
                break;
        case 6: if ((value3rd == 6) || (value3rd == 7)) myHand.addCard(myGame.dealCard());
                break;
        default: // Do nothing
                break;
      }
    }
  }

  public void playTurn() {
    if (amDealer) {
      playDealerTurn();
     } else {
      // Not the dealer
      if (valueOfHand() < 6) {
        thirdCard = myGame.dealCard();
        myHand.addCard(thirdCard);
      }
    }
  }
}

// If neither the Player nor Banker is dealt a total of 8 or 9 in the first two cards (known as a "natural"), the tableau is consulted, first for Player's rule, then Banker's.

// Player's rule
// If Player has an initial total of 0–5, he draws a third card. If Player has an initial total of 6 or 7, he stands.
// Banker's rule
// If Player stood pat (i.e., has only two cards), the banker regards only his own hand and acts according to the same rule as Player. That means Banker draws a third card with hands 0–5 and stands with 6 or 7.
// If Player drew a third card, the Banker acts according to the following more complex rules:

// If the banker total is 2 or less, then the banker draws a card, regardless of what the player's third card is.
// If the banker total is 3, then the bank draws a third card unless the player's third card was an 8.
// If the banker total is 4, then the bank draws a third card if the player's third card was 2, 3, 4, 5, 6, 7.
// If the banker total is 5, then the bank draws a third card if the player's third card was 4, 5, 6, or 7.
// If the banker total is 6, then the bank draws a third card if the player's third card was a 6 or 7.
// If the banker total is 7, then the banker stands.