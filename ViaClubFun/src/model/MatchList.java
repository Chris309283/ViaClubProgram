package model;

import java.util.ArrayList;

public class MatchList
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
    if (matches.contains(match))
    {
      matches.remove(match);
    }
  }

  public int Size()
  {
    return matches.size();
  }

  public Match get(int index)
  {
    return matches.get(index);
  }

}
