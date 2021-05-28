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
   * @return it returns the int of the size of matches
   */
  public int size()
  {
    return matches.size();
  }

  /**
   * the method gets the match from a specific index, if it exist.
   * @param index which is a specific location of list
   * @return if match does not exist it returns null, otherwise it return the match.
   */
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

  /**
   * the method sets/changesa match to a specific index
   * @param index is a location in the list
   * @param match is match to that index
   */
  public void set(int index, Match match)
  {
    matches.set(index, match);
  }

  /**
   * the method has 6 parameter and a loop and inside it there is temp variable reference of type match,
   * so it goes through the loop and check if temp is equal to all parameter it returns the index as a number from that match..
   * @param startTime it is input of start time of the match
   * @param endTime it is input of end time of the match
   * @param date it is the date of the match
   * @param opponent it is the opponent in the match
   * @param matchType it is match type
   * @param isAwayGame it is is away game
   * @return it returns the int
   */
  public int getIndex(Time startTime, Time endTime, Date date, String opponent, String matchType, boolean isAwayGame)
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

  /**
   * the method will run through the loop and print out all matches
   * @return it will return the string of all all matches
   */
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
