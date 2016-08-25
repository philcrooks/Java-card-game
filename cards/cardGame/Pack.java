package cardGame;
import java.util.*;
import cardGameTypes.*;

public class Pack {

  private ArrayList<Card> pack;

  public Pack() {
    pack = new ArrayList<Card>();
    for (Suits suit : Suits.values()) {
      for (Spots spot : Spots.values()) {
        pack.add(new Card(suit, spot));
      }
    }
  }

  public ArrayList<Card> getCards() {
    return pack;
  }

  public int size() {
    return pack.size();
  }

  public Card get(int index){
    return pack.get(index);
  }

}