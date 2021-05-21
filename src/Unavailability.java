/**
 * a class for creating unavailability objects
 *
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
   * Three-argument constructor initializing the Unavailability
   *
   * @param start         sets the start date of the Unavailability
   * @param numberOfGames sets the number of games the Unavailability is for
   *                      isAvailable method is set initially to false
   */
  public Unavailability(Date start, int numberOfGames)
  {
    this.type = "Suspended";
    this.start = start.copy();
    this.numberOfGames = numberOfGames;
    isAvailable = false;
  }

  /**
   * Two-argument constructor initializing the Unavailability
   *
   * @param type  sets the type of Unavailability either Suspended or Injured
   * @param start sets the start date of the Unavailability
   *              isAvailable method is set initially to false
   */
  public Unavailability(String type, Date start)
  {
    this.type = type;
    this.start = start.copy();
    isAvailable = false;
    numberOfGames = -1;

  }

  /**
   *
   * @return
   */


  public boolean getIsAvailable(){
    return isAvailable;
  }

  /**
   * Gets the type of Unavailability
   *
   * @return the type of Unavailability
   */
  public String getType()
  {
    return type;
  }

  /**
   * ends the Unavailability and sets the end to the current date
   *
   * @param end sets the end of the Unavailability as the current date
   */
  public void setAvailable(Date end)
  {

    this.end = end;
    isAvailable = true;
  }

  /**
   * Gets the start date of the Unavailability
   *
   * @return the start date of the Unavailability
   */

  public Date getStart()
  {
    return start.copy();
  }

  /**
   * Sets the start date of the Unavailability
   *
   * @param start sets the start date of the Unavailability
   */
  public void setStart(Date start)
  {
    this.start = start.copy();
  }

  /**
   * Gets the end date of the Unavailability
   *
   * @return the end date of the Unavailability
   */
  public Date getEnd()
  {
    return end.copy();
  }

  /**
   * Sets the end date of the Unavailability
   *
   * @param end sets the end date of the Unavailability
   */
  public void setEnd(Date end)
  {
    this.end = end.copy();
  }

  /**
   * Outputs the number of days the Unavailability lasted
   *
   * @return the number of days from start date to end date
   */
  public int lasted()
  {
    return start.daysUntil(end);
  }

  /**
   * checks if the unavailability end date is not before today's date
   *
   * @return true if the unavailability end is not before doday's date. False otherwise
   */
  public boolean isActive()
  {
    if (Date.today().isBefore(end))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

}


