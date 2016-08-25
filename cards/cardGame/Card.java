package cardGame;
import cardGameTypes.*;

public class Card {
  private Suits suit;
  private Spots spot;

  public Card (Suits suit, Spots spot) {
    this.suit = suit;
    this.spot = spot;
  }

  public String toString() {
    return spot.toString() + " of " + suit.toString();
  }
}