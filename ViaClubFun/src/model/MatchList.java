package model;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchList implements Serializable
{
  private ArrayList<Match> matches;

  public MatchList()
  {
    matches = new ArrayList<Match>();
  }

  public void add(Match match)
  {
    matches.add(match);
  }

  public void remove(Match match)
  {
    matches.remove(match);
  }

  public int size()
  {
    return matches.size();
  }

  public Match get(int index)
  {
    if (index < matches.size())
    {
      return matches.get(index);
    }
    else
    {
      return null;
    }
  }
  public void set(int index, Match match)
  {
    matches.set(index, match);
  }

  public int getIndex(Time startTime, Time endTime, Date date, String opponent,
      String matchType, boolean isAwayGame)
  {
    for (int i = 0; i < matches.size(); i++)
    {
      Match temp = matches.get(i);

      if (temp.getStartTime().equals(startTime) && temp.getEndTime().equals(endTime) && temp.getDate().equals(date)&&temp.getOpponent().equals(opponent)&&temp.getMatchType().equals(matchType)&& temp
          .getIsAwayGame()==isAwayGame)
      {
        return i;
      }
    }
    return -1;
  }


  public String toString()
  {
    String returnStr = "";
    for (int i = 0; i < matches.size(); i++)
    {
      Match temp = matches.get(i);
      returnStr += temp + "\n";
    }
    return returnStr;
  }
}
