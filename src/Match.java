import java.util.ArrayList;
import java.util.Locale;

public class Match
{
  private Time start, end;
  private Date date;
  private ArrayList<Player> bench, lineUp;
  private String opponent, matchType;
  private int scoreHomeTeam, scoreOpponent, benchSize, teamSize;
  private boolean isAwayGame;

  public Match(Time start, Time end, Date date, String opponent,
      String matchType)
  {
    this.start = start;
    this.end = end;
    this.date = date;
    this.opponent = opponent;
    this.matchType = matchType;
    this.bench = new ArrayList<>();
    this.lineUp = new ArrayList<>();
    this.scoreHomeTeam = 0;
    this.scoreOpponent = 0;
    this.teamSize = 11;
    this.isAwayGame = false;

    switch (matchType.toLowerCase())
    {
      case "cup":
        this.benchSize = 6;
        break;
      case "league":
        this.benchSize = 5;
        break;
      case "friendly":
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
    this.scoreHomeTeam = scoreHomeTeam;
  }

  public int getScoreOpponent()
  {
    return scoreOpponent;
  }

  public void setScoreOpponent(int goals)
  {
    this.scoreOpponent = scoreOpponent;
  }

  public String getMatchScore()
  {
    return scoreHomeTeam + " - " + scoreOpponent;
  }

  public void setIsAwayGame(boolean status)
  {
    isAwayGame=status;
  }

  public boolean getIsAwayGame()
  {
    return isAwayGame;
  }

  public void addToLineUp(Player player)
  {
    lineUp.add(player.copy());
  }

  public void addToBench(Player player)
  {
    bench.add(player.copy());
  }

  public void removeFromLineUp(Player player)
  {
    lineUp.remove(player);
  }

  public void removeFromBench(Player player)
  {
    bench.remove(player);
  }

  public ArrayList<Player> getLineUp()
  {
    return lineUp;
  }

  public ArrayList<Player> getBench()
  {
    return bench;
  }

  public void setMatchType(String matchType)
  {
    this.matchType = matchType;
  }

  public String getMatchType()
  {
    return matchType;
  }

  public Match copy()
  {
    return new Match(start,end,opponent,matchType);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Match))
    {
      return false;
    }

    Match other = (Match) obj;
    return start.equals(other.start) && end.equals(other.end) && date.equals(other.date) && lineUp
        .equals(other.lineUp) && bench.equals(other.bench) && opponent.equals(other.opponent) && matchType.equals(other.matchType) && scoreHomeTeam == other.scoreHomeTeam && scoreOpponent == other
        .getScoreOpponent() && benchSize == other.benchSize && teamSize == other.teamSize && isAwayGame == other.isAwayGame;
  }
}
