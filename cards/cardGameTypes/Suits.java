package cardGameTypes;

public enum Suits {
  CLUBS ("Clubs"),
  DIAMONDS ("Diamonds"),
  HEARTS ("Hearts"),
  SPADES ("Spades");

  private String text;

  private Suits(String s) {
    text = s;
  }

  public String toString() {
    return text;
  }
}