package model;

import java.util.GregorianCalendar;

/**
 * A class for creating model.Date objects.
 *
 * @author Java Gods
 * @version 1.0
 */
public class Date
{
  private int day, month, year;

  /**
   * A three-argument constructor initializing the model.Date.
   *
   * @param day   sets the day of the month.
   * @param month sets the month of the year.
   * @param year  sets the year.
   */
  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * A method that checks if a this date is before date2.
   *
   * @param date2 sets the second date.
   * @return whether or not this date is before date2
   */
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

  /**
   * A method that checks if this year is a leap year.
   *
   * @return true if this year is a leap year, false otherwise.
   */
  private boolean isLeapYear()
  {
    return ((this.year % 4 == 0) && (this.year % 100 != 0)) || (this.year % 400
        == 0);
  }

  /**
   * A method that returns how many days there are in a given month.
   *
   * @return An integer with days in given month.
   */
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

  /**
   * A method that sets the day to the day after.
   */
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

  /**
   * A method that calculates from this date until date2.
   *
   * @param date2 Sets the second date.
   * @return A time object with the days, months and years between the two dates.
   */
  public int daysUntil(Date date2)
  {
    Date date1 = copy();
    int days = 0;

    if (isBefore(date2))
    {
      while (!(date1.day == date2.day && date1.month == date2.month
          && date1.year == date2.year))
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

  /**
   * A method that calculates from this date since date2.
   *
   * @param date2 Sets the second date.
   * @return A time object with the days, months and years between the two dates.
   */
  public int daysSince(Date date2)
  {
    Date date1 = copy();
    Date date3 = date2.copy();
    int days = 0;

    if (!(isBefore(date2)))
    {
      while (!(date3.day == date1.day && date3.month == date1.month
          && date3.year == date1.year))
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

  /**
   * A method that gets you the current date.
   *
   * @return A model.Date object with the current date.
   */
  public static Date today()
  {
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    return new Date(currentDay, currentMonth, currentYear);
  }

  /**
   * A method for making a copy of the model.Date object.
   *
   * @return A copy model.Date object.
   */
  public Date copy()
  {
    return new Date(day, month, year);
  }

  /**
   * Compares this model.Date to the specified object.
   * The result is true if and only if the argument is not null and
   * is a model.Date object that represents the same parameters as this object.
   *
   * @param obj The object to compare this model.Date against.
   * @return true if the given object represents a model.Date equivalent to this date, false otherwise.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }

    Date other = (Date) obj;

    return day == other.day && month == other.month && year == other.year;
  }

  /**
   * A method that gives a string representation of the object.
   *
   * @return A string representation of the object.
   */
  public String toString()
  {
    return String.format("%02d/%02d/%04d", day, month, year);
  }
}
