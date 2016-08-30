package cardGame;
import java.util.*;
import cardGameTypes.*;

public abstract class Pack {

  private ArrayList<Card> pack;

  public Pack() {
    // No game-specific values provided
    pack = new ArrayList<Card>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        pack.add(new Card(suit, rank, valueOfCard(suit, rank)));
      }
    }
  }

  public Pack(int[] values) {
    // No game-specific values provided
    int i;
    pack = new ArrayList<Card>();
    for (Suit suit : Suit.values()) {
      i = 0;
      for (Rank rank : Rank.values()) {
        pack.add(new Card(suit, rank, values[i++]));
      }
    }
  }

  public Pack(Card... cards) {
    // For test purposes
    pack = new ArrayList<Card>();
    for (Card card : cards) {
      pack.add(card);
    }
  }

  public ArrayList<Card> getCards() {
    return pack;
  }

  public int size() {
    return pack.size();
  }

  abstract protected int valueOfCard(Suit suit, Rank rank);
}