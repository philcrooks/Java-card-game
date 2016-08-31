package cardGame;
import java.util.*;
import cardGameTypes.*;

public abstract class Pack {

  private List<Card> immutablePack;

  public Pack() {
    // No game-specific values provided
    ArrayList<Card> pack = new ArrayList<Card>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        pack.add(new Card(suit, rank, valueOfCard(suit, rank)));
      }
    }
    immutablePack = Collections.unmodifiableList(pack);
  }

  public Pack(int[] values) {
    int i;
    ArrayList<Card> pack = new ArrayList<Card>();
    for (Suit suit : Suit.values()) {
      i = 0;
      for (Rank rank : Rank.values()) {
        pack.add(new Card(suit, rank, values[i++]));
      }
    }
    immutablePack = Collections.unmodifiableList(pack);
  }

  public Pack(Card... cards) {
    // For test purposes
    ArrayList<Card>pack = new ArrayList<Card>();
    for (Card card : cards) {
      pack.add(card);
    }
    immutablePack = Collections.unmodifiableList(pack);
  }

  public List<Card> getCards() {
    // Someone could change the values in the ArrayList
    return immutablePack;
  }

  public int size() {
    return immutablePack.size();
  }

  abstract protected int valueOfCard(Suit suit, Rank rank);
}