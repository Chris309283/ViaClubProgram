import java.util.ArrayList;

public class PlayerList
{
  private ArrayList<Player> players;


  public PlayerList()
  {
    players = new ArrayList<Player>();
  }
  public void addPlayer(Player player)
  {
     player.add(players);
  }

}
