package cardGame;
import java.util.*;
import cardGameTypes.*;

public class Pack {

  private ArrayList<Card> pack;

  public Pack() {
    // No game-specific values provided
    pack = new ArrayList<Card>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        pack.add(new Card(suit, rank));
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

  public Pack(EnumMap<Rank, Integer> values) {
    pack = new ArrayList<Card>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        pack.add(new Card(suit, rank, (int)values.get(rank)));
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
}