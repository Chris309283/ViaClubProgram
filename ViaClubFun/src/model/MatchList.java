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

  public int Size()
  {
    return matches.size();
  }

  public Match get(int index)
  {
    return matches.get(index);
  }

  public String toString()
  {
    String returnStr ="";
    for (int i = 0; i < matches.size(); i++)
    {
      Match temp = matches.get(i);
      returnStr += temp + "\n";
    }
    return returnStr;
  }
}
