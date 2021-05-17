import java.time.LocalTime;

/**
 * A class for creating time objects.
 * @author Christopher Gadgaard
 * @version 1.0
 */

public class Time
{
  private int hour, minute, second;

  /**
   * A three-argument constructor initializing the Time.
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
   * @return An integer where hours & minutes have turned into seconds.
   */

  public int convertToSeconds()
  {
    return (hour * 3600) + (minute * 60) + second;
  }

  /**
   * A boolean that checks if a time is before another time.
   * @param time2 sets second time.
   * @return
   */
  public boolean isBefore(Time time2)
  {
    return time2.convertToSeconds() > convertToSeconds();
  }

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

  public Time timeSince(Time time2)
  {
    int totalTimeInSeconds;
    if (!(isBefore(time2)))
    {
      totalTimeInSeconds = convertToSeconds() - time2.convertToSeconds();
    }
    else
    {
      totalTimeInSeconds = 24 * 3600 - time2.convertToSeconds() + convertToSeconds();
    }
    return new Time(totalTimeInSeconds);
  }

  public static Time now()
  {
    return new Time(LocalTime.now().getHour(),LocalTime.now().getMinute(),LocalTime.now().getSecond());
  }

  public Time copy()
  {
    return new Time(hour,minute,second);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
    {
      return false;
    }

    Time other = (Time) obj;

    return hour == other.hour && minute == other.minute && second == other.second;
  }

  public String toString()
  {
    return String.format("%02d:%02d:%02d", hour, minute, second);
  }
}
