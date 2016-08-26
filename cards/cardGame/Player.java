package cardGame;
import cardGameTypes.*;

public abstract class Player {
  private String name;
  protected Hand hand;
  protected Game game;

  public Player( String name, Game game ) {
    this.name = name;
    this.game = game;
  }

  public String getName() {
    return name;
  }

  public void giveHand(Hand hand) {
    this.hand = hand;
  }

  public int valueOfHand() {
    if (hand == null) return 0;
    return hand.getValue();
  }

  public Hand showHand() {
    return hand;  
  }

  public abstract void playTurn();
}