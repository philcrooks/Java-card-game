package cardGame;
import java.util.*;
import cardGameTypes.*;

public class Shoe {
  // TODO: Create a shoe that won't shuffle for test purposes

  private ArrayList<Card> shoe;
  private boolean allowShuffling = true;

  // Constructors
  public Shoe() {
    shoe = new ArrayList<Card>();
  }

  public Shoe(Pack pack) {
    shoe = new ArrayList<Card>();
    addPack(pack, 1);
  }

  public Shoe(Pack pack, boolean allowShuffling) {
    this.allowShuffling = allowShuffling;
    shoe = new ArrayList<Card>();
    addPack(pack, 1);
  }

  public Shoe(Pack pack, int times) {
    shoe = new ArrayList<Card>();
    addPack(pack, times);
  }

  // Add cards to the shoe. 
  // All Card needs to do is to support the getCards() method which returns ArrayList<Card>
  private void addPack(Pack pack) {
    //shoe.addAll(pack.getCards());
    addPack(pack, 1);
  }

  private void addPack(Pack pack, int times) {
    for ( int c = 0; c < times; c++ ) {
      shoe.addAll(pack.getCards());     
    }
  }

  public void shuffle() {
    // TODO: May want to add a random seed here
    // This should make the shuffle less predictable
    if ((shoe != null) && allowShuffling ) {
      Collections.shuffle(shoe);
    }
  }

  public Card dealCard() {
    // Card is immutable
    Card card = shoe.get(0);
    shoe.remove(0);
    return card;
  }

  // Test methods not needed for the game
  public int size() {
    return shoe.size();
  }

  public Card getCard(int index){
    // Card is immutable
    return shoe.get(index);
  }
}