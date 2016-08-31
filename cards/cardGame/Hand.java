package cardGame;
import java.util.*;

public class Hand {

  private ArrayList<Card> hand;

  public Hand() {
    hand = new ArrayList<Card>();
  }

  private Hand(Hand another) {
    hand = new ArrayList<Card>();
    ArrayList<Card> cards = another.hand;
    for (Card card : cards) {
      // Do not have to copy cards - they are immutable
      hand.add(card);
    }
    // The following line but causes warnings
    // hand = (ArrayList<Card>)another.hand.clone();
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
    // Cards are immutable
    return hand.get(0);
  }

  public Card getCard( int cardIndex ) {
    // Cards are immutable
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

  public Hand show() {
    // return a copy of the hand
    return new Hand(this);
  }

}