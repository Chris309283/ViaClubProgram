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

  public void removePlayer(Player player)
  {
    players.remove(player);
  }

  public ArrayList<Player> getPlayersAvailable()
  {
    ArrayList<Player> PlayersAvailable = new ArrayList<Player>();

    for ( int i = 0; i < players.size(); i++)
    {
      if (players.get(i).is)
    }
    return players;
  }
  public ArrayList<Player> getPlayersUnAvailable()
  {
    ArrayList<Player>  PlayersUnAvailable = new ArrayList<Player>();
    for ( int i = 0; i < players.size(); i++)
    {
      if (players.get(i).isSuspended()|| players.get(i).is )

    }