package model;

import java.util.ArrayList;

public class MatchList
{
  private ArrayList<Match> matches;

  public MatchList(){
    matches= new ArrayList<Match>();
  }
  public void addMatch(Match match){
    matches.add(match);
  }
  public void removeMatch(Match match){
    if(matches.contains(match)){
      matches.remove(match);
    }
  }
  public int getSize(){
    return matches.size();
  }

}
