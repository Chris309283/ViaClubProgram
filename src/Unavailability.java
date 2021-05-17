import java.util.GregorianCalendar;

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
   * Three-argument constructor initializing the Unavailability
   * @param type sets the type of Unavailability either Suspended or Injured
   * @param start sets the start date of the Unavailability
   * @param numberOfGames sets the number of games the Unavailability is for
   */
  public Unavailability(String type,Date start, int numberOfGames){
    this.type=type;
    this.start=start.copy();
    this.numberOfGames=numberOfGames;
  }

  /**
   *Two-argument constructor initializing the Unavailability
   * @param type sets the type of Unavailability either Suspended or Injured
   * @param start sets the start date of the Unavailability
   */
  public Unavailability(String type, Date start){
    this.type=type;
    this.start=start.copy();

  }

  /**
   * ends the Unavailability and sets the end to the current date
   * @param end sets the end of the Unavailability as the current date
   */
  public void setAvailable(Date end){
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    end= new Date(currentDay, currentMonth, currentYear);

    this.end=end;
  }

  /**
   *Gets the start date of the Unavailability
   * @return the start date of the Unavailability
   */

  public Date getStart(){
    return start.copy();
  }

  /**
   * Sets the start date of the Unavailability
   * @param start sets the start date of the Unavailability
   */
  public void setStart(Date start){
    this.start=start.copy();
  }

  /**
   * Gets the end date of the Unavailability
   * @return the end date of the Unavailability
   */
  public Date getEnd(){
    return end.copy();
  }

  /**
   *Sets the end date of the Unavailability
   * @param end sets the end date of the Unavailability
   */
  public void setEnd(Date end){
    this.end=end.copy();
  }

  /**
   * Outputs the number of days the Unavailability lasted
   * @return the number of days from start date to end date
   */
  public int lasted(){
   return start.daysUntil(end);
  }
}
