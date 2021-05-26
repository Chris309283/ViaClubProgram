package model;

import model.Date;

/**
 * a class for creating unavailability objects
 * @author Java Gods
 * @version 1.0
 */
public class Unavailability
{
  private String type;
  private boolean isAvailable;
  private int numberOfGames;
  private Date start, end;

  /**
   * Three-argument constructor initializing the model.Unavailability
   * @param start sets the start date of the model.Unavailability
   * @param numberOfGames sets the number of games the model.Unavailability is for
   * isAvailable method is set initially to false
   */
  public Unavailability(Date start, int numberOfGames){
    this.type="Suspended";
    this.start=start.copy();
    this.numberOfGames=numberOfGames;
    isAvailable=false;
  }

  /**
   *Two-argument constructor initializing the model.Unavailability
   * @param type sets the type of model.Unavailability either Suspended or Injured
   * @param start sets the start date of the model.Unavailability
   * isAvailable method is set initially to false
   */
  public Unavailability(String type, Date start){
    this.type=type;
    this.start=start.copy();
    isAvailable=false;
    numberOfGames=-1;

  }

  /**
   * Gets the type of model.Unavailability
   * @return the type of model.Unavailability
   */
  public String getType(){
    return type;
}
  /**
   * ends the model.Unavailability and sets the end to the current date
   * @param end sets the end of the model.Unavailability as the current date
   */
  public void setAvailable(Date end){

    this.end=end;
    if(end.isBefore(Date.today())){
      isAvailable=false;
    }
    isAvailable=true;
  }

  /**
   *Gets the start date of the model.Unavailability
   * @return the start date of the model.Unavailability
   */

  public Date getStart(){
    return start.copy();
  }

  /**
   * Sets the start date of the model.Unavailability
   * @param start sets the start date of the model.Unavailability
   */
  public void setStart(Date start){
    this.start=start.copy();
  }

  /**
   * Gets the end date of the model.Unavailability
   * @return the end date of the model.Unavailability
   */
  public Date getEnd(){
    return end.copy();
  }

  /**
   *Sets the end date of the model.Unavailability
   * @param end sets the end date of the model.Unavailability
   */
  public void setEnd(Date end){
    this.end=end.copy();
  }

  /**
   * Outputs the number of days the model.Unavailability lasted
   * @return the number of days from start date to end date
   */
  public int lasted(){
   return start.daysUntil(end);
  }

  public String toString()
  {
    String finalString="";

    if(type.equals("Suspended")){
      finalString="Type: Suspended; Number of games: "+numberOfGames;
    }
    else if(type.equals("Injured")){
      finalString="Type: Injured; Start Date: "+start+"; End Date: "+end;
    }
    return finalString;
  }
}

