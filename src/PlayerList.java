import java.util.ArrayList;
  /**
   * a class, which is a list of players
   *  * @author Java Gods
   *  * @version 1.0
   *  */

public class PlayerList
{
  private ArrayList<Player> players;

  /**
   * a constructor with none-argument, which assign list values to the fields
   */

  public PlayerList()
  {
    players = new ArrayList<Player>();

    /**
     * this method add a match to the list, it has one parameter (player)
     * @param players which is input in the method
     */
  }

  public void addPlayer(Player player)
  {
    players.add(player);
  }

  public void removePlayer(Player player)
  {
    players.remove(player);
  }

  public ArrayList<Player> getPlayersAvailable(Date date)
  {
    ArrayList<Player> PlayersAvailable = new ArrayList<Player>();

    for ( int i = 0; i < players.size(); i++)
    {
      ArrayList<Unavailability> playerUnAvailabilities = players.get(i).getAllUnavailabilities();
      for (int j = 0; j < playerUnAvailabilities.size(); j++)
      {

        boolean isAvailable = true;

      if (date.isBefore(playerUnAvailabilities.get(j).getStart()) || (!date
          .isBefore(playerUnAvailabilities.get(j).getEnd()) && !date.equals(playerUnAvailabilities.get(j).getEnd())))
        {
          isAvailable =true;

        }
      else
        {
          isAvailable = false;
        }

      if (isAvailable = true) { PlayersAvailable.add(players.get(i));}


      }
    }
  return PlayersAvailable;

  }
  public ArrayList<Player> getPlayersUnAvailable()
  {
    ArrayList<Player>  PlayersUnAvailable = new ArrayList<Player>();
    for ( int i = 0; i < players.size(); i++)
    {
      if (players.get(i).isSuspended()|| players.get(i).isInjured());
    }
    return PlayersUnAvailable;
  }

  public ArrayList<Player> getPlayersByName( String name)
  {
    ArrayList<Player> PlayersByName = new ArrayList<Player>();
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).getName().equals(name))
      {
        PlayersByName.add(players.get(i));
      }
    }
    return PlayersByName;
  }

  public ArrayList<Player> getPlayersByNumber( int number)
  {
    ArrayList<Player> PlayersByNumber = new ArrayList<Player>();
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).getNumber() == number)
      {
        PlayersByNumber.add(players.get(i));
      }
  }
    return PlayersByNumber;
  }
  public ArrayList<Player> getAllPlayers()
  {
    return players;
  }

  public ArrayList<Player> getInjuredPlayers()
  {
    ArrayList<Player> InjuredPlayers = new ArrayList<Player>();
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).isInjured());
    }
    return InjuredPlayers;
  }
  public ArrayList<Player> getSuspendedPlayers()
  {
    ArrayList<Player> SuspendedPlayers = new ArrayList<Player>();
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).isSuspended());
    }
    return SuspendedPlayers;

  }

}