package cardGame;
import cardGameTypes.*;

public abstract class Game {
  protected Deck deck;
  protected Player[] players;

  public Game () {

  }

  // public Player[] getPlayers() {

  // }

  public void dealCards( int numberOfPacks,
                         Player[] players,
                         int cardsPerPlayer ) {
    // Get the cards
    Pack pack = new Pack();
    deck = new Deck(pack, numberOfPacks);
    deck.shuffle();

    // Deal the cards into hands
    int numberOfPlayers = players.length;
    Hand[] hands = new Hand[numberOfPlayers];
    for ( int c = 0; c < cardsPerPlayer; c ++) {
      for (Hand hand : hands) {
        hand.giveCard(deck);
      }
    }

    // Give hands to the players
    for ( int c = 0; c < numberOfPlayers; c++ ) {
      players[c].giveHand(hands[c]);
    }
  }

  public abstract void playGame();
}
