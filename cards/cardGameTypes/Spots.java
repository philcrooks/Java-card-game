package cardGameTypes;


public enum Spots {
  ACE ("Ace"),
  TWO ("2"),
  THREE ("3"),
  FOUR ("4"),
  FIVE ("5"),
  SIX ("6"),
  SEVEN ("7"),
  EIGHT ("8"),
  NINE ("9"),
  TEN ("10"),
  JACK ("Jack"),
  QUEEN ("Queen"),
  KING ("King");

  private final String text;

  private Spots(String s) {
    text = s;
  }

  public String toString() {
    return text;
  }
}