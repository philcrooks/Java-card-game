package cardGame;
import cardGameTypes.*;

public abstract class Player {
  private String name;
  private Hand hand;

  public Player( String name ) {
    this.name = name;
  }

  public void giveHand(Hand hand) {
    this.hand = hand;
  }

  public abstract void playTurn();
}