package cardGame;
import cardGameTypes.*;
import java.util.*;

public class PlayerGroup {
  ArrayList<Player> group;
  Player dealer;
  int dealerIndex;
  int firstPlayerIndex;
  int runningIndex;

  public PlayerGroup() {
    group = new ArrayList<Player>();
    firstPlayerIndex = dealerIndex = runningIndex = -1;
    dealer = null;
  }

  public void addPlayer(Player player) {
    player.setGroup(this);
    group.add(player);
    if ((dealerIndex > 0) && (firstPlayerIndex < dealerIndex)) {
      // If the dealer index has been set, the dealer is no longer the last in the list
      firstPlayerIndex = dealerIndex + 1;
    }
  }

  private Player switchDealer(Player newDealer) {
    if (dealer != null) dealer.setIsDealer(false);
    newDealer.setIsDealer(true);
    dealer = newDealer;
    return dealer;
  }

  public Player setDealer() {
    dealerIndex = group.size() - 1;
    if (dealerIndex < 0) return null;
    firstPlayerIndex = 0;
    return switchDealer(group.get(dealerIndex));
  }

  public Player setDealer(Player player) {
    dealerIndex = group.indexOf(player);
    if (dealerIndex < 0) return null;
    firstPlayerIndex = (dealerIndex + 1) % group.size();
    return switchDealer(player);
  }

  public Player setDealer (String name) {
    int c = 0;
    for (Player player : group) {
      if (player.getName() == name) {
        dealerIndex = c;
        firstPlayerIndex = (dealerIndex + 1) % group.size();
        return switchDealer(player);
      }
      c += 1;
    }
    return null;
  }

  public Player getDealer() {
    return dealer;
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
    return (dealer == player);
  }
}