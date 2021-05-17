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
     players.add(player);
  }
  public void removePlayer( Player player)
  {
    players.remove(player);
  }

  public ArrayList<Player> getPlayersAvailable()
  {
    return players;
  }
  public ArrayList<Player> getPlayersUnAvailable()
  {
    return players;
  }

  public ArrayList<Player> getPlayersByName( String name)
  {
    return players;
  }

}
