package cardGame;
import cardGameTypes.*;
import java.util.*;

public class PontoonGame extends Game {
  private PontoonPlayer dealer;

  public PontoonGame( int numberOfPlayers ) {
    players = new PontoonPlayer[numberOfPlayers];
    dealer = (PontoonPlayer)players[numberOfPlayers-1]; 
    pack = new Pack(cardValues());
  }

  private EnumMap<Rank, Integer> cardValues() {
    // I the Rank changes this code should break at Compile-time
    // It's a rather heavy-weight way of getting the values into the pack.
    EnumMap<Rank, Integer> values = new EnumMap<>(Rank.class);
    values.put(Rank.ACE,   11);
    values.put(Rank.TWO,    2);
    values.put(Rank.THREE,  3);
    values.put(Rank.FOUR,   4);
    values.put(Rank.FIVE,   5);
    values.put(Rank.SIX,    6);
    values.put(Rank.SEVEN,  7);
    values.put(Rank.EIGHT,  8);
    values.put(Rank.NINE,   9);
    values.put(Rank.TEN,   10);
    values.put(Rank.JACK,  10);
    values.put(Rank.QUEEN, 10);
    values.put(Rank.KING,  10);      
    return values;
  }

  public PontoonPlayer whoIsDealer() {
    return dealer;
  }

  public Card getCardShowing() {
    return dealer.showCard();
  }

  public void playGame() {
    for (PontoonPlayer player : (PontoonPlayer[])players) {
      player.playTurn();
    }
  }
}