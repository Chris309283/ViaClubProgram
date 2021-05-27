package model;

import java.io.Serializable;

public class Match implements Serializable
{
  private Time startTime, endTime;
  private Date date;
  private PlayerList bench, lineUp;
  private String opponent, matchType;
  private int scoreHomeTeam, scoreOpponent, benchSize, teamSize;
  private boolean isAwayGame;

  public Match(Time startTime, Time endTime, Date date, String opponent,
      String matchType, boolean isAwayGame)
  {
    this.startTime = startTime;
    this.endTime = endTime;
    this.date = date;
    this.opponent = opponent;
    this.matchType = matchType;
    this.bench = null;
    this.lineUp = null;
    this.scoreHomeTeam = 0;
    this.scoreOpponent = 0;
    this.teamSize = 11;
    this.isAwayGame = isAwayGame;

    switch (matchType)
    {
      case "Cup":
        this.benchSize = 6;
        break;
      case "League":
        this.benchSize = 5;
        break;
      case "Friendly":
        this.benchSize = 100;
        break;
      default: this.benchSize = 0;
    }
  }

  public int getScoreHomeTeam()
  {
    return scoreHomeTeam;
  }

  public void setScoreHomeTeam(int goals)
  {
    this.scoreHomeTeam = goals;
  }

  public int getScoreOpponent()
  {
    return scoreOpponent;
  }

  public void setScoreOpponent(int goals)
  {
    this.scoreOpponent = goals;
  }

  public String getMatchScore()
  {
    return scoreHomeTeam + " - " + scoreOpponent;
  }

  public String getMatchType()
  {
    return matchType;
  }

  public void setMatchType(String matchType)
  {
    this.matchType = matchType;
  }

  public Date getDate()
  {
    return date;
  }

  public String getOpponent()
  {
    return opponent;
  }

  public void setOpponent(String opponent)
  {
    this.opponent = opponent;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public void setStartTime(Time startTime)
  {
    this.startTime = startTime;
  }

  public Time getEndTime()
  {
    return endTime;
  }

  public void setEndTime(Time endTime)
  {
    this.endTime = endTime;
  }

  public boolean getIsAwayGame()
  {
    return isAwayGame;
  }

  public void setIsAwayGame(boolean status)
  {
    isAwayGame=status;
  }

  public void addLineUp(PlayerList lineUp)
  {
    this.lineUp=lineUp;
  }

  public PlayerList getLineUp()
  {
    return lineUp;
  }

  public void addBench(PlayerList bench)
  {
    this.bench=bench;
  }

  public PlayerList getBench()
  {
    return bench;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Match))
    {
      return false;
    }

    Match other = (Match) obj;
    return startTime.equals(other.startTime) && endTime.equals(other.endTime) && date.equals(other.date) && lineUp
        .equals(other.lineUp) && bench.equals(other.bench) && opponent.equals(other.opponent) && matchType.equals(other.matchType) && scoreHomeTeam == other.scoreHomeTeam && scoreOpponent == other
        .scoreOpponent && benchSize == other.benchSize && teamSize == other.teamSize && isAwayGame == other.isAwayGame;
  }

  public String toString()
  {
    String returnStr = matchType + " Match\n" + "Opponent: " + opponent + "\nDate: " + date + "\nTime: " + startTime + " - " + endTime + "\nScore: " + getMatchScore() + "\nStarting line up:";

    if (lineUp!=null)
    {
      for (int i = 0; i <lineUp.size(); i++)
      {
        returnStr += "\n" + lineUp.get(i);
      }
      returnStr += "\nBench:";
    }
    if (bench!=null)
    {
      for (int i = 0; i <bench.size(); i++)
      {
        returnStr += "\n" + bench.get(i);
      }
      return returnStr;
    }
    return returnStr;
  }
}
