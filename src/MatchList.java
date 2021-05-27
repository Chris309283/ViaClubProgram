import java.util.ArrayList;


/**
 * a class, which is a list of matches
 */

public class MatchList
{
  private ArrayList<Match> matches;

  /**
   * a constructor with none-argument, which assign list values to the fields
   */

  public MatchList(){
    matches = new ArrayList<Match>();
  }

  /**
   * this method add a match to the list, it has one parameter (match)
   * @param match which is input in the method
   */
  public void addMatch(Match match){
    matches.add(match);
  }

  /**
   * this method type is void, and the purpose is to remove a match to the list, it has one parameter (match)
   * @param match which is input in the method
   *
   */


  public void removeMatch(Match match){
    matches.remove(match);
  }


  /**
   * this method remove a match to the list, it has one parameter (match)
   * @param date which is input in the method
   */

  public ArrayList<Match> getMatchesOnDate(Date date){
    ArrayList<Match> gettingMatchesOnDate = new ArrayList<Match>();
    for (int i = 0; i < matches.size(); i++){
      if (matches.get(i).getDate().equals(date)){
        gettingMatchesOnDate.add(matches.get(i));
      }
    }
    return gettingMatchesOnDate;

  }

  /**
   * the method has first date and second date, we need to get all matches between our first and second date.
   * @param date is input, which is the first date
   * @param date2 is input, which is the second date
   * @return it will return gettingMatchesBetweenDates
   */
  public ArrayList<Match> getMatchesBetweenDates(Date date, Date date2){
    ArrayList<Match> gettingMatchesBetweenDates = new ArrayList<Match>();
    for (int i = 0; i < matches.size(); i++){
      if (!(matches.get(i).getDate().isBefore(date)) && matches.get(i).getDate().isBefore(date2) ){
        gettingMatchesBetweenDates.add(matches.get(i));
      }
    }
    return gettingMatchesBetweenDates;
  }


  public ArrayList<Match> getMatchesAgainst(String opponent){
    // it searches acrross all matches and if it find the input opponent then it will be putted to our array
    ArrayList<Match> gettingMatchesAgainst = new ArrayList<Match>();
    for (int i = 0; i < matches.size(); i++){
      if (matches.get(i).getOpponent().equals(opponent)){
        gettingMatchesAgainst.add(matches.get(i));
      }
    }
    return gettingMatchesAgainst;

  }


  public ArrayList<Match> getMatchesPlayedBy(Player player){
    ArrayList<Match> gettingMatchesPlayedBy = new ArrayList<Match>();

    for (int i = 0; i < matches.size(); i++){
      //first get all players for current match
      ArrayList<Player> = matches.get(i).getLineUP;
      //PlayerList.getAllPlayers

      //we use for loop again to get a list of players
      for (int j = 0; j < matches.size(); j++){
      if (matches.get(i).equals(player)){
        gettingMatchesPlayedBy.add(matches.get(i));
      }


      }

    }
  }
  public ArrayList<Match> getMatchesWon(){
    ArrayList<Match> gettingMatchesWon = new ArrayList<Match>();

    for (int i = 0; i < matches.size(); i++){
      if (matches.get(i).getScoreHomeTeam() > matches.get(i).getScoreOpponent()){
        gettingMatchesWon.add(matches.get(i));
      }
    }
    return gettingMatchesWon;
  }

  public ArrayList<Match> getMatchesLost(){
    ArrayList<Match> gettingMatchesWon = new ArrayList<Match>();

    for (int i = 0; i < matches.size(); i++){
      if (matches.get(i).getScoreHomeTeam() < matches.get(i).getScoreOpponent()){
        gettingMatchesWon.add(matches.get(i));
      }
    }
    return gettingMatchesWon;
  }



  public ArrayList<Match> getAllMatches(){
    return matches;
  }


}
