package cardGame;
import cardGameTypes.*;

public abstract class Player {
  private String name;
  protected boolean amDealer;
  protected Hand myHand;
  protected Game myGame;

  public Player( String name) {
    this.name = name;
    amDealer = false;
    myGame = null;
    myHand = new Hand();
  }

  public String getName() {
    return name;
  }

  public String toString () {
    return name;
  }

  public void setIsDealer(boolean isDealer) {
    amDealer = isDealer;
  }

  public void setGame(Game game) {
    myGame = game;
  }

  public void giveCard(Card card) {
    myHand.addCard(card);
  }

  public int valueOfHand() {
    if (myHand == null) return 0;
    return myHand.getValue();
  }

  public Hand showHand() {
    return myHand;  
  }

  public abstract void playTurn();
}