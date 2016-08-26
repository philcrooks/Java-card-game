import static org.junit.Assert.*;
import org.junit.*;
import cardGameTypes.*;
import cardGame.*;

public class PontoonTest{
  Pack pack;
  Deck deck;
  PontoonPlayer player;
  static final int[] values = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10};

  @Before
  public void before() {
    pack = new Pack(values);
    deck = new Deck(pack);
    player = new PontoonPlayer("Phil", (PontoonGame) null);
  }

  @Test
  public void checkName() {
    assertEquals("Phil", player.getName());
  }



}