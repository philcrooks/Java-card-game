package behaviours;
import cardGame.*;
import java.util.*;

public interface Playability {
  // Interface required by a player to talk to the game

  public Card dealCard ();
  public Player getDealer();
  public ArrayList<Player> getPlayers();
}