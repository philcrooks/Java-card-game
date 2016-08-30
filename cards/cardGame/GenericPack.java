package cardGame;
import cardGameTypes.*;

public class GenericPack extends Pack {

  public GenericPack() {
    super();
  }

  public GenericPack(int[] values) {
    super(values);
  }

  public GenericPack(Card... cards) {
    super(cards);
  }

  protected int valueOfCard(Suit suit, Rank rank) {
    return 0;
  }
}