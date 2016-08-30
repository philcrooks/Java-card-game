package pontoonGame;
import cardGameTypes.*;
import cardGame.*;

public class PontoonPack extends Pack {

  public PontoonPack() {
    super();
  }

  protected int valueOfCard(Suit suit, Rank rank) {
    switch (rank) {
      case ACE:   return 11;
      case TWO:   return 2;
      case THREE: return 3;
      case FOUR:  return 4;
      case FIVE:  return 5;
      case SIX:   return 6;
      case SEVEN: return 7;
      case EIGHT: return 8;
      case NINE:  return 9;
      case TEN:   return 10;
      case JACK:  return 10;
      case QUEEN: return 10;
      case KING:  return 10;
    }
    // shouldn't get here
    return -1;
  }
}