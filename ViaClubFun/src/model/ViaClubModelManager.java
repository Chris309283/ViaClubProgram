package model;


import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class ViaClubModelManager
{
  private String playerFileName;
  private String matchFileName;

  public ViaClubModelManager(String playerFileName,String matchFileName)
  {
    this.playerFileName=playerFileName;
    this.matchFileName=matchFileName;
  }

  public PlayerList getAllPlayers()
  {
    PlayerList allPlayers = new PlayerList();

    try
    {
      allPlayers = (PlayerList) MyFileHandler.readFromBinaryFile(playerFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Player file not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading player file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return allPlayers;
  }

  public MatchList getAllMatches()
  {
    MatchList allMatches = new MatchList();

    try
    {
      allMatches = (MatchList) MyFileHandler.readFromBinaryFile(matchFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Match file not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading match file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return allMatches;
  }

  public MatchList getMatchesOnDate(Date date)
  {
    MatchList temp = new MatchList();
    for (int i = 0; i < getAllMatches().size(); i++)
    {
      if (getAllMatches().get(i).getDate().equals(date))
      {
        temp.add(getAllMatches().get(i));
      }
    }
    return temp;
  }

  public PlayerList getPlayersAvailable()
  {
    PlayerList allAvailablePlayers = new PlayerList();
    PlayerList allPlayers = getAllPlayers();

    for (int i = 0; i < allPlayers.size(); i++)
    {
      if (!allPlayers.get(i).isSuspended()&&!allPlayers.get(i).isInjured())
      {
        allAvailablePlayers.add(allPlayers.get(i));
      }
    }
    return allAvailablePlayers;
  }

  public PlayerList getPlayersUnavailable()
  {
    PlayerList allUnavailablePlayers = new PlayerList();
    PlayerList allPlayers = getAllPlayers();

    for (int i = 0; i < allPlayers.size(); i++)
    {
      if (allPlayers.get(i).isSuspended()||allPlayers.get(i).isInjured())
      {
        allUnavailablePlayers.add(allPlayers.get(i));
      }
    }
    return allUnavailablePlayers;
  }

  public PlayerList getPlayersByName(String name, PlayerList list)
  {
    PlayerList allPlayersNamed = new PlayerList();

    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getName().toLowerCase().contains(name.toLowerCase()))
      {
        allPlayersNamed.add(list.get(i));
      }
    }
    return allPlayersNamed;
  }
  
  public PlayerList getPlayersByNumber(int number, PlayerList list)
  {
    PlayerList allPlayersNumbered = new PlayerList();

    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNumber()==number)
      {
        allPlayersNumbered.add(list.get(i));
      }
    }
    return allPlayersNumbered;
  }
  
  public PlayerList getPlayersByPositions(String position, PlayerList list)
  {
    PlayerList allPlayersByPositions = new PlayerList();

    for (int i = 0; i < list.size(); i++)
    {
      for (int j = 0; j < list.get(i).getPositions().size(); j++)
      {
        if (list.get(i).getPositions().get(j).toLowerCase().contains(position.toLowerCase()))
        {
          allPlayersByPositions.add(list.get(i));
        }
      }
    }
    return allPlayersByPositions;
  }



  public void saveMatches(MatchList matches)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(matchFileName,matches);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Match file not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to match file");
    }
  }

  public void savePlayers(PlayerList players)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(playerFileName, players);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Player file not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to player file");
    }
  }
}
