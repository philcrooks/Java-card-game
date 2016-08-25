package cardGame;
import java.util.*;

public class Hand {

  private ArrayList<Card> hand;

  public Hand() {
    hand = new ArrayList<Card>();
  }

  public void takeACard(Deck deck){
    //deck may become discard pile in the future so this may become an interface not deck passed in
    hand.add(deck.dealCard());
  }

  public String toString(){
    String string = "";
    for( Card card : hand){
      string += card.toString() + "\n";
    }
    return string;
  }

}