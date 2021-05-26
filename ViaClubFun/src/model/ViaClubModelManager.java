package model;

import model.PlayerList;
import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

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
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
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
    for (int i = 0; i < getAllMatches().Size(); i++)
    {
      if (getAllMatches().get(i).getDate().equals(date))
      {
        temp.add(getAllMatches().get(i));
      }
    }
    return temp;
  }

 /* public PlayerList getPlayersAvailable()
  {
    PlayerList temp = new PlayerList();
    for (int i = 0; i < getAllPlayers().size(); i++)
    {
      if (getAllPlayers().get(i).isAvailable)
      {
      temp.add(getAllPlayers().get(i));
      }

    }
  return temp;
  }

  */

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
