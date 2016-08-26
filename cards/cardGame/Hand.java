package cardGame;
import java.util.*;

public class Hand {

  private ArrayList<Card> hand;

  public Hand() {
    hand = new ArrayList<Card>();
  }

  public void addCard(Card card){
    //deck may become discard pile in the future so this may become an interface not deck passed in
    hand.add(card);
  }

  public int getValue() {
    int value = 0;
    for (Card card : hand) {
      value += card.getValue();
    }
    return value;
  }

  public Card getLastCard() {
    // Pontton dealer should show last card
    // This method may not be needed by other games
    return hand.get(hand.size() - 1);
  }

  public String toString(){
    String string = "";
    for( Card card : hand){
      string += card.toString() + "\n";
    }
    return string;
  }

  public int getSize() {
    return hand.size();
  }

}