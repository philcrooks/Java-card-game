package cardGame;
import cardGameTypes.*;

public abstract class Game {
  protected Pack pack;
  protected Deck deck;
  protected Player[] players;

  public void dealCards( int numberOfPacks,
                         Player[] players,
                         int cardsPerPlayer ) {
    // Get the cards
    deck = new Deck(pack, numberOfPacks);
    deck.shuffle();

    // Deal the cards into hands
    int numberOfPlayers = players.length;
    Hand[] hands = new Hand[numberOfPlayers];
    for ( int c = 0; c < cardsPerPlayer; c ++) {
      for (Hand hand : hands) {
        hand.addCard(dealCard());
      }
    }

    // Give hands to the players
    for ( int c = 0; c < numberOfPlayers; c++ ) {
      players[c].giveHand(hands[c]);
    }
  }


  public Card dealCard() {
    return deck.dealCard();
  }

  public abstract void playGame();
}
