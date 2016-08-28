package cardGame;
import cardGameTypes.*;
import behaviours.*;
import java.util.*;

public abstract class Game implements Playability {
  private ArrayList<Player> group;
  private Player dealer;
  private Shoe shoeOfCards;
  private int dealerIndex;
  private int firstPlayerIndex;
  private int runningIndex;

  public Game() {
    group = new ArrayList<Player>();
    firstPlayerIndex = dealerIndex = runningIndex = -1;
    dealer = null;
    shoeOfCards = buildShoe();
  }

  protected void addShoe(Shoe shoe) {
    if (shoeOfCards == null) shoeOfCards = shoe;
  }

  public void shuffleCards() {
    if (shoeOfCards == null) return;
    shoeOfCards.shuffle();
  }

  public void dealHands(int noOfCards) {
    if (shoeOfCards == null) return;
    int noOfPlayers = group.size();
    if ((noOfPlayers == 0) || (firstPlayerIndex < 0) || (noOfCards <= 0)) return;
    for (int c = 0; c < noOfCards; c++) {
      for (int p = 0; p < noOfPlayers; p++) {
        group.get((p + firstPlayerIndex) % noOfPlayers).giveCard(shoeOfCards.dealCard());
      }
    }
  }

  public Card dealCard () {
    if (shoeOfCards == null) return null;
    return shoeOfCards.dealCard();
  }

  public void addPlayer(Player player) {
    player.setGame(this);
    group.add(player);
    if ((dealerIndex > 0) && (firstPlayerIndex < dealerIndex)) {
      // If the dealer index has been set, the dealer is no longer the last in the list
      firstPlayerIndex = dealerIndex + 1;
    }
  }

  public ArrayList<Player> getPlayers() {
    return group;
  }

  public Player getPlayer(int playerIndex) {
    if (group.size() <= playerIndex) return null;
    return group.get(playerIndex);
  }

  public Player switchDealer(Player newDealer) {
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

  protected abstract Shoe buildShoe();
  public abstract void playGame();
}