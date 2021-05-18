import java.time.LocalTime;

/**
 * A class for creating time objects.
 *
 * @author Java Gods
 * @version 1.0
 */
public class Time
{
  private int hour, minute, second;

  /**
   * A three-argument constructor initializing the Time.
   *
   * @param h sets the hour of the day.
   * @param m sets the minute of the hour.
   * @param s sets the second of the minute.
   */
  public Time(int h, int m, int s)
  {
    this.hour = h;
    this.minute = m;
    this.second = s;
  }

  /**
   * A one-argument constructor initializing the Time.
   *
   * @param totalTimeInSeconds sets the time of the day from total seconds.
   */
  public Time(int totalTimeInSeconds)
  {
    hour = totalTimeInSeconds / 3600;
    totalTimeInSeconds = totalTimeInSeconds - hour * 3600;
    minute = totalTimeInSeconds / 60;
    totalTimeInSeconds = totalTimeInSeconds - minute * 60;
    second = totalTimeInSeconds;
  }

  /**
   * A method for converting the time into seconds.
   *
   * @return An integer where hours & minutes have turned into seconds.
   */
  public int convertToSeconds()
  {
    return (hour * 3600) + (minute * 60) + second;
  }

  /**
   * A method that checks if a time is before another time.
   *
   * @param time2 sets the second time.
   * @return whether or not time is before time2
   */
  public boolean isBefore(Time time2)
  {
    return time2.convertToSeconds() > convertToSeconds();
  }

  /**
   * A method that calculates from one time until another.
   *
   * @param time2 Sets the second time.
   * @return A time object with the hours, minutes and seconds between the two times.
   */
  public Time timeUntil(Time time2)
  {
    int totalTimeInSeconds;
    if (isBefore(time2))
    {
      totalTimeInSeconds = time2.convertToSeconds() - convertToSeconds();
    }
    else
    {
      totalTimeInSeconds =
          24 * 3600 - convertToSeconds() + time2.convertToSeconds();
    }

    return new Time(totalTimeInSeconds);
  }

  /**
   * A method that calculates from one time since another.
   *
   * @param time2 Sets the second time.
   * @return A time object with the hours, minutes and seconds between the two times.
   */
  public Time timeSince(Time time2)
  {
    int totalTimeInSeconds;
    if (!(isBefore(time2)))
    {
      totalTimeInSeconds = convertToSeconds() - time2.convertToSeconds();
    }
    else
    {
      totalTimeInSeconds =
          24 * 3600 - time2.convertToSeconds() + convertToSeconds();
    }
    return new Time(totalTimeInSeconds);
  }

  /**
   * A method that gives the current local time.
   *
   * @return A time object with the local time.
   */
  public static Time now()
  {
    return new Time(LocalTime.now().getHour(), LocalTime.now().getMinute(),
        LocalTime.now().getSecond());
  }

  /**
   * A method for making a copy of the Time object.
   *
   * @return A copy Time object.
   */
  public Time copy()
  {
    return new Time(hour, minute, second);
  }

  /**
   * Compares this Time to the specified object.
   * The result is true if and only if the argument is not null and
   * is Time object the represents the same parameters as this object.
   *
   * @param obj The object to compare this Time against.
   * @return true if the given object represents a Time equivalent to this time, false otherwise.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
    {
      return false;
    }

    Time other = (Time) obj;

    return hour == other.hour && minute == other.minute
        && second == other.second;
  }

  /**
   * A method that gives a string representation of the object.
   * @return A string representation of the object.
   */
  public String toString()
  {
    return String.format("%02d:%02d:%02d", hour, minute, second);
  }
}
