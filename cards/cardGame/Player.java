package cardGame;
import cardGameTypes.*;
import behaviours.*;

public abstract class Player {
  private String name;
  protected boolean amDealer;
  protected Hand myHand;
  protected Playability myGame;

  public Player( String name ) {
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

  public void setGame(Playability game) {
    myGame = game;
  }

  public void giveCard(Card card) {
    myHand.addCard(card);
  }

  public Hand showHand() {
    return myHand.show(); 
  }

  public abstract void playTurn();
  public abstract int valueOfHand();
}