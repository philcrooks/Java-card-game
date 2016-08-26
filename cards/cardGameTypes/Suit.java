package cardGameTypes;

public enum Suit {
  CLUBS ("Clubs"),
  DIAMONDS ("Diamonds"),
  HEARTS ("Hearts"),
  SPADES ("Spades");

  private String text;
  private static final int size = Suit.values().length;

  private Suit(String s) {
    text = s;
  }
  
  public int getSize() {
    return size;
  }

  public String toString() {
    return text;
  }
}