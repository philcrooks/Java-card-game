package cardGame;
import java.util.*;
import cardGameTypes.*;

public class Deck {
  private ArrayList<Card> deck;

  // Constructors
  public Deck() {
    deck = new ArrayList<Card>();
  }

  public Deck(Pack pack) {
    deck = new ArrayList<Card>();
    add(pack, 1);
  }

  public Deck(Pack pack, int times) {
    deck = new ArrayList<Card>();
    add(pack, times);
  }

  // Add cards to the deck. 
  // All Card needs to do is to support the getCards() method which returns ArrayList<Card>
  public void add(Pack pack) {
    //deck.addAll(pack.getCards());
    add(pack, 1);
  }

  public void add(Pack pack, int times) {
    for ( int c = 0; c < times; c++ ) {
      deck.addAll(pack.getCards());     
    }
  }

  public void shuffle() {
    // TODO: May want to add a random seed here
    // This should make the shuffle less predictable
    if (deck != null) {
      Collections.shuffle(deck);
    }
  }

  public Card dealCard() {
    Card card = deck.get(0);
    deck.remove(0);
    return card;
  }

  // Test methods not needed for the game
  public int size() {
    return deck.size();
  }

  public Card get(int index){
    return deck.get(index);
  }

}