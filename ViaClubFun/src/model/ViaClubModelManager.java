package model;

import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A model manager providing a singe access point to the model
 *
 * @author JavaGods
 * @version 1.0
 */
public class ViaClubModelManager
{
  private String playerFileName;
  private String matchFileName;

  /**
   * Two-argument constructor setting the file names
   *
   * @param playerFileName the name and the path of the file where players will be saved and retrieved
   * @param matchFileName the name and the path of the file where matches will be sabed and retrieved
   */
  public ViaClubModelManager(String playerFileName, String matchFileName)
  {
    this.playerFileName = playerFileName;
    this.matchFileName = matchFileName;
  }

  /**
   * Gets
   * @return
   */
  public PlayerList getAllPlayers()
  {
    PlayerList allPlayers = new PlayerList();

    try
    {
      allPlayers = (PlayerList) MyFileHandler
          .readFromBinaryFile(playerFileName);
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

  public MatchList getMatchesBetweenDates(Date date1, Date date2)
  {
    MatchList allMatches = getAllMatches();
    MatchList betweenMatches = new MatchList();

    Date dateStart = date1.copy();
    for (int i = 0; i < allMatches.size(); i++)
    {
      while (!dateStart.equals(date2))
      {
        if (getMatchesOnDate(date1) != null)
        {
          for (int j = 0; j < getMatchesOnDate(dateStart).size(); j++)
          {
            betweenMatches.add(getMatchesOnDate(dateStart).get(j));
          }

        }
        dateStart.nextDay();
      }
    }
    return betweenMatches;
  }

  public MatchList getMatchesAgainst(String opponent, MatchList matchList)
  {
    MatchList allMatches = matchList;
    MatchList opponentList = new MatchList();
    for (int i = 0; i < allMatches.size(); i++)
    {
      if (allMatches.get(i).getOpponent().toLowerCase()
          .contains(opponent.toLowerCase()))
      {
        opponentList.add(allMatches.get(i));
      }
    }
    return opponentList;
  }
  public MatchList getTypeMatches(String type,MatchList matchList){
    MatchList allMatches= matchList;
    MatchList temp= new MatchList();

    for (int i = 0; i < allMatches.size(); i++)
    {
      if(allMatches.get(i).getMatchType().equals(type)){
        temp.add(allMatches.get(i));
      }
    }
    return temp;
  }

  public MatchList getMatchesWon()
  {
    MatchList allMatches = getAllMatches();
    MatchList wonList = new MatchList();

    for (int i = 0; i < allMatches.size(); i++)
    {
      if (allMatches.get(i).getScoreHomeTeam() > allMatches.get(i)
          .getScoreOpponent())
      {
        wonList.add(allMatches.get(i));
      }
    }
    return wonList;
  }

  public MatchList getMatchesLost()
  {
    MatchList allMatches = getAllMatches();
    MatchList lostList = new MatchList();

    for (int i = 0; i < allMatches.size(); i++)
    {
      if (allMatches.get(i).getScoreHomeTeam() < allMatches.get(i)
          .getScoreOpponent())
      {
        lostList.add(allMatches.get(i));
      }
    }
    return lostList;
  }

  public MatchList getMatchesDraw()
  {
    MatchList allMatches = getAllMatches();
    MatchList drawList = new MatchList();

    for (int i = 0; i < allMatches.size(); i++)
    {
      if ((allMatches.get(i).getScoreHomeTeam() == allMatches.get(i)
          .getScoreOpponent()) && allMatches.get(i).getDate()
          .isBefore(Date.today()))
      {
        drawList.add(allMatches.get(i));
      }
    }
    return drawList;
  }

  public PlayerList getPlayersAvailable()
  {
    PlayerList allAvailablePlayers = new PlayerList();
    PlayerList allPlayers = getAllPlayers();

    for (int i = 0; i < allPlayers.size(); i++)
    {
      if (!allPlayers.get(i).isSuspended() && !allPlayers.get(i).isInjured())
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
      if (allPlayers.get(i).isSuspended() || allPlayers.get(i).isInjured())
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
      if (list.get(i).getNumber() == number)
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
        if (list.get(i).getPositions().get(j).toLowerCase()
            .contains(position.toLowerCase()))
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
      MyFileHandler.writeToBinaryFile(matchFileName, matches);
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

  public void updateSuspensions()
  {
    PlayerList allPlayers = getAllPlayers();
    PlayerList tempList = new PlayerList();

    for (int i = 0; i < allPlayers.size(); i++)
    {
      if (allPlayers.get(i).isSuspended())
      {
        tempList.add(allPlayers.get(i));
      }
    }

    for (int i = 0; i < tempList.size(); i++)
    {

      int total = 0;

      for (int j = 0; j < tempList.get(i).getAllUnavailabilities().size(); j++)
      {

        Date tempDate = tempList.get(i).getAllUnavailabilities().get(j)
            .getStart().copy();

        while (!tempDate.equals(Date.today()))
        {
          if (getMatchesOnDate(tempDate) != null)
          {

            total += getMatchesOnDate(tempDate).size();
          }
          tempDate.nextDay();

        }
        Player tempPlayer = allPlayers.get(tempList.get(i).getName());

        if (total >= tempList.get(i).getAllUnavailabilities().get(j)
            .getNumberOfGames())
        {
          tempPlayer.getAllUnavailabilities().get(j).setNumberOfGames(0);
        }
      }
    }
    savePlayers(allPlayers);
  }

  public void updateBenchedInARow()
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      allPlayers.get(i).setBenchedInARow(0);

    }
    for (int i = 0; i < allPlayers.size(); i++)
    {
      int streak = 0;
      for (int j = 0; j < getAllMatches().size(); j++)
      {

        if (getAllMatches().get(j).getBench().contains(allPlayers.get(i))
            && !(getAllMatches().get(j).getLineUp()
            .contains(allPlayers.get(i))))
        {
          streak++;
        }
        else
        {
          streak = 0;
        }
      }
      allPlayers.get(i).setBenchedInARow(streak);
    }

    savePlayers(allPlayers);
  }

  public MatchList getAllMatchesToday()
  {
    MatchList temp = new MatchList();
    temp = getMatchesOnDate(Date.today());
    return temp;
  }

  public MatchList getAllMatchesPast()
  {
  MatchList allMatches= getAllMatches();
  MatchList matchesBetween=new MatchList();
    for (int i = 0; i <allMatches.size() ; i++)
    {
      if (allMatches.get(i).getDate().isBefore(Date.today())){
        matchesBetween.add(allMatches.get(i));
      }
    }
    return matchesBetween;
  }

  public MatchList getAllFutureMatches()
  {
    MatchList allMatches= getAllMatches();
    MatchList matchesBetween=new MatchList();
    for (int i = 0; i <allMatches.size() ; i++)
    {
      if (Date.today().isBefore(allMatches.get(i).getDate())){
        matchesBetween.add(allMatches.get(i));
      }
    }
    return matchesBetween;
  }
}
