import java.time.LocalTime;

public class Time
{
  private int hour, minute, second;

  public Time(int h, int m, int s)
  {
    this.hour = h;
    this.minute = m;
    this.second = s;
  }

  public Time(int totalTimeInSeconds)
  {
    hour = totalTimeInSeconds / 3600;
    totalTimeInSeconds = totalTimeInSeconds - hour * 3600;
    minute = totalTimeInSeconds / 60;
    totalTimeInSeconds = totalTimeInSeconds - minute * 60;
    second = totalTimeInSeconds;
  }

  public int convertToSeconds()
  {
    return (hour * 3600) + (minute * 60) + second;
  }

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
