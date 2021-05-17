import java.util.GregorianCalendar;

public class Date
{
private int day, month, year;

  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public boolean isBefore(Date date2)
  {

    if (year < date2.year)
    {
      return true;
    }
    else if (year == date2.year)
    {
      if (month < date2.month)
      {
        return true;
      }
      else if (month == date2.month)
      {
        if (day < date2.day)
        {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isLeapYear()
  {
    return ((this.year % 4 == 0) && (this.year % 100 != 0)) || (this.year % 400
        == 0);
  }

  private int daysInMonth()
  {
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
        || month == 10 || month == 12)
    {
      return 31;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    else if (month == 2 && isLeapYear())
    {
      return 29;
    }
    else if (month == 2)
    {
      return 28;
    }
    else
    {
      return -1;
    }
  }

  private void nextDay()
  {
    if (this.day < daysInMonth())
    {
      this.day += 1;
    }
    else
    {
      this.day = 1;
      if (this.month < 12)
      {
        this.month += 1;
      }
      else
      {
        this.month = 1;
        this.year += 1;
      }
    }
  }

  public int daysUntil(Date date2)
  {
    Date date1 = copy();
    int days = 0;

    if (isBefore(date2))
    {
      while (!(date1.day == date2.day && date1.month == date2.month &&
          date1.year == date2.year))
      {
        date1.nextDay();
        days++;
      }
      return days;
    }
    else
    {
      return -1;
    }
  }

  public int daysSince(Date date2)
  {
    Date date1 = copy();
    Date date3 = date2.copy();
    int days = 0;

    if (!(isBefore(date2)))
    {
      while (!(date3.day == date1.day && date3.month == date1.month &&
          date3.year == date1.year))
      {
        date3.nextDay();
        days++;
      }
      return days;
    }
    else
    {
      return -1;
    }
  }

  public static Date today()
  {
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    return new Date(currentDay, currentMonth, currentYear);
  }

  public Date copy()
  {
    return new Date(day, month, year);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }

    Date other = (Date) obj;

    return day == other.day && month == other.month && year == other.year;
  }

  public String toString()
  {
    return String.format("%02d/%02d/%04d", day, month, year);
  }
}
