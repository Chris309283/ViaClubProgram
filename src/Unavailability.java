import java.util.GregorianCalendar;

public class Unavailability
{
  private String type;
  private boolean isAvailable;
  private int numberOfGames;
  private Date start, end;

  public Unavailability(String type,Date start, int numberOfGames){
    this.type=type;
    this.start=start.copy();
    this.numberOfGames=numberOfGames;
  }
  public Unavailability(String type, Date start){
    this.type=type;
    this.start=start.copy();

  }
  public void setAvailable(Date end){
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    end= new Date(currentDay, currentMonth, currentYear);

    this.end=end;
  }

  public Date getStart(){
    return start.copy();
  }
  public void setStart(Date start){
    this.start=start.copy();
  }
  public Date getEnd(){
    return end.copy();
  }
  public void setEnd(Date end){
    this.end=end.copy();
  }
  public int lasted(){
   return start.daysUntil(end);
  }
}
