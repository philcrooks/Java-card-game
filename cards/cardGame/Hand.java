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

  public Card getFirstCard() {
    // Pontton dealer should show first card
    // This method may not be needed by other games
    return hand.get(0);
  }

  public Card getCard( int cardIndex ) {
    return hand.get(cardIndex);
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

  public void replaceCard(Card oldCard, Card newCard) {
    int cardIndex = hand.indexOf(oldCard);
    hand.set(cardIndex, newCard);
  }

}