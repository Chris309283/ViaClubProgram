package model;

import java.io.Serializable;
import java.util.ArrayList;

 /**
 * a class of which is a list of matches
 * @author Java Gods
 * @version 1.0
 */
public class MatchList implements Serializable
{


  private ArrayList<Match> matches;


  /**
   * a constructor, which initialize the matches. it is without parameter
   */
  public MatchList()
  {
    matches = new ArrayList<Match>();
  }

  /**
   * the method  add match to our list
   * @param match of type Match which will be added to the list
   */
  public void add(Match match)
  {
    matches.add(match);
  }

  /**
   * the method remove a match from the list
   * @param match is input to the parameter which the user can remove a match from matches
   */

  public void remove(Match match)
  {
    matches.remove(match);
  }

  /**
   * the method which gets the size of matches
   * @return it return the size of matches
   */
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
