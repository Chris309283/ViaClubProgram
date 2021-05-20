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
   * the methods is
   *
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
  /*
  public ArrayList<Match> getMatchesAgainst(String opponent){

    ArrayList<Match> gettingMatchesAgainst = new ArrayList<Match>();
    for (int i = 0; i < matches.size(); i++){
      gettingMatchesAgainst.add(matches.setOponent(opponent));
    }
    return gettingMatchesAgainst;

  }

   */
  public ArrayList<Match> getMatchesPlayedBy(Player player){
    ArrayList<Match> gettingMatchesPlayedBy = new ArrayList<Match>();
    for (int i = 0; i < matches.size(); i++){
      if (matches.contains())
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

  public ArrayList<Match> getMatcheslost(){
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
