package cardGame;
import java.util.*;
import cardGameTypes.*;

public class Deck {
  private ArrayList<Card> deck;

  public Deck() {
    deck = new ArrayList<Card>();
  }

  public void add(Pack pack) {
    deck.addAll(pack.getCards());
  }

  public void shuffle() {
    // TODO: May want to add a random seed here
    // This should make the shuffle less predictable
    if (deck != null) Collections.shuffle(deck);
  }

  public int size() {
    return deck.size();
  }

  public Card get(int index){
    return deck.get(index);
  }

  public Card dealCard() {
    Card card = deck.get(0);
    deck.remove(0);
    return card;
  }
}