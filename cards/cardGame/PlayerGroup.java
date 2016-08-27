package cardGame;
import cardGameTypes.*;
import java.util.*;

public class PlayerGroup {
  ArrayList<Player> group;
  int firstPlayerIndex;
  int dealerIndex;
  int runningIndex;

  public PlayerGroup() {
    group = new ArrayList<Player>();
    firstPlayerIndex = dealerIndex = runningIndex = -1;
  }

  public void addPlayer(Player player) {
    group.add(player);
    if ((dealerIndex > 0) && (firstPlayerIndex < dealerIndex)) {
      // If the dealer index has been set, the dealer is no longer the last in the list
      firstPlayerIndex = dealerIndex + 1;
    }
  }

  public Player setDealer() {
    dealerIndex = group.size() - 1;
    if (dealerIndex < 0) return null;
    firstPlayerIndex = 0;
    return group.get(dealerIndex);
  }

  public Player setDealer(Player player) {
    dealerIndex = group.indexOf(player);
    if (dealerIndex < 0) return null;
    firstPlayerIndex = (dealerIndex + 1) % group.size();
    return player;
  }

  public Player setDealer (String name) {
    int c = 0;
    for (Player player : group) {
      if (player.getName() == name) {
        dealerIndex = c;
        firstPlayerIndex = (dealerIndex + 1) % group.size();
        return player;
      }
      c += 1;
    }
    return null;
  }

  public Player getFirstPlayer() {
    runningIndex = firstPlayerIndex;
    if (runningIndex < 0) return null;
    return group.get(runningIndex++);
  }

  public Player getNextPlayer() {
    if (runningIndex < 0) return null;
    runningIndex = runningIndex % group.size();
    return group.get(runningIndex++);
  }

  public boolean isDealer(Player player) {
    if (dealerIndex < 0) return false;
    return (group.get(dealerIndex) == player);
  }
}