package cardGame;
import cardGameTypes.*;

public abstract class Player {
  private String name;
  protected boolean amDealer;
  protected Hand myHand;
  protected PlayerGroup myGroup;

  public Player( String name) {
    this.name = name;
    amDealer = false;
    myGroup = null;
    myHand = new Hand();
  }

  public String getName() {
    return name;
  }

  public void setIsDealer(boolean isDealer) {
    amDealer = isDealer;
  }

  public void setGroup(PlayerGroup group) {
    myGroup = group;
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