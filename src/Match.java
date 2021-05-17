import java.util.ArrayList;

public class Match
{
  private Time start, end;
  private Date date;
  private ArrayList<Player> bench, lineUp;
  private String opponent, matchType;
  private int scoreHomeTeam, scoreOpponent, teamSize;

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


  }
}
