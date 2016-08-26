package cardGame;
import cardGameTypes.*;
import java.util.*;

public class PontoonGame extends Game {

  public PontoonGame( int numberOfPlayers ) {
    players = new PontoonPlayer[numberOfPlayers];
    pack = new Pack(cardValues());
  }

  private EnumMap<Rank, Integer> cardValues() {
    // I the Rank changes this code should break at Compile-time
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

  public void playGame() {
    for (PontoonPlayer player : (PontoonPlayer[])players) {
      player.playTurn();
    }
  }
}