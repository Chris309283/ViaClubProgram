package model;

import model.Date;

import java.io.Serializable;

/**
 * a class for creating unavailability objects
 *
 * @author Java Gods
 * @version 1.0
 */
public class Unavailability implements Serializable
{
  private String type;
  // private boolean isAvailable;
  private int numberOfGames;
  private Date start, end;
  private ViaClubModelManager modelManager;

  /**
   * Three-argument constructor initializing the model.Unavailability
   *
   * @param start         sets the start date of the model.Unavailability
   * @param numberOfGames sets the number of games the model.Unavailability is for
   *                      isAvailable method is set initially to false
   */
  public Unavailability(Date start, int numberOfGames)
  {
    this.type = "Suspended";
    this.start = start.copy();
    this.numberOfGames = numberOfGames;
    //isAvailable=false;
  }

  /**
   * Two-argument constructor initializing the model.Unavailability
   *
   * @param start sets the start date of the model.Unavailability
   *              isAvailable method is set initially to false
   */
  public Unavailability(Date start)
  {
    this.type = "Injury";
    this.start = start.copy();
    // isAvailable=false;
    numberOfGames = -1;

  }

  public Unavailability(Date start, Date end)
  {
    this.type = "Injured";
    this.start = start.copy();
    this.end = end.copy();
    //isAvailable = false;
    numberOfGames = -1;
  }

  /**
   * Gets the type of model.Unavailability
   *
   * @return the type of model.Unavailability
   */
  public String getType()
  {
    return type;
  }

  public int getNumberOfGames()
  {
    return numberOfGames;
  }

  /**
   * ends the model.Unavailability and sets the end to the current date
   *
   * @param end sets the end of the model.Unavailability as the current date
   */

  public void setAvailable(Date end)
  {

    this.end = end;
    numberOfGames = 0;
    //isAvailable=true;
  }

  public boolean isActive()
  {
    if (type.equals("Suspended") && numberOfGames > 0)
    {
      return true;
    }

    else if ((type.equals("Injured") && !(end.isBefore(Date.today()))))
    {
      return true;
    }

    return false;
  }

  /**
   * Gets the start date of the model.Unavailability
   *
   * @return the start date of the model.Unavailability
   */

  public Date getStart()
  {
    return start.copy();
  }

  /**
   * Sets the start date of the model.Unavailability
   *
   * @param start sets the start date of the model.Unavailability
   */
  public void setStart(Date start)
  {
    this.start = start.copy();
  }

  /**
   * Gets the end date of the model.Unavailability
   *
   * @return the end date of the model.Unavailability
   */
  public Date getEnd()
  {
    return end.copy();
  }

  /**
   * Sets the end date of the model.Unavailability
   *
   * @param end sets the end date of the model.Unavailability
   */
  public void setEnd(Date end)
  {
    this.end = end.copy();
  }

  public void setNumberOfGames(int numberOfGames)
  {
    this.numberOfGames = numberOfGames;
  }

  /**
   * Outputs the number of days the model.Unavailability lasted
   *
   * @return the number of days from start date to end date
   */
  public int lasted()
  {
    return start.daysUntil(end);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Unavailability))
    {
      return false;
    }

    Unavailability other = (Unavailability) obj;
    if (end != null)
    {
      return numberOfGames == other.numberOfGames && start.equals(other.start)
          && end.equals(other.end) && type.equals(other.type);
    }
    else
    {
      return numberOfGames == other.numberOfGames && start.equals(other.start)
          && other.end == null && type.equals(other.type);
    }
  }

  public int matchesPast()
  {
    int total = 0;
    Date temp = start.copy();
    while (!temp.equals(Date.today()))
    {
      if (modelManager.getMatchesOnDate(temp) != null)
      {
        total += modelManager.getMatchesOnDate(temp).size();
      }
      temp.nextDay();
    }
    return total;
  }


  public String toString()
  {
    String finalString = "";

    if (type.equals("Suspended"))
    {
      finalString = "Type: Suspended; Number of games: " + numberOfGames;
    }
    else if (type.equals("Injured"))
    {
      finalString =
          "Type: Injured; Start Date: " + start + "; End Date: " + end;
    }

    finalString += "; is active: " + isActive();
    return finalString;
  }
}

