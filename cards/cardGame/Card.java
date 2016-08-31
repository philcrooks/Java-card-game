package cardGame;
import cardGameTypes.*;

public class Card {

  // This class is immutable. A card cannot be changed once it has been created.
  // To change the value of a card, a copy of the card is created and a new value allocated. 

  private Suit suit;
  private Rank rank;
  private int value;

  public Card (Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    this.value = 0;
  }

  public Card (Suit suit, Rank rank, int value) {
    this.suit = suit;
    this.rank = rank;
    this.value = value;
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    return rank.toString() + " of " + suit.toString();
  }

  public Card revalue(int newValue ) {
    Card newCard = new Card(suit, rank, newValue);
    return newCard;
  }
}