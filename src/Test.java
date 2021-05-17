public class Test
{
  public static void main(String[] args)
  {
    Time t1 = new Time(12,0,0);
    Time t2 = new Time(12,30,0);
    Time t3 = new Time(11,0,0);
    Time t4 = new Time(12,0,0);

    System.out.println(t1.convertToSeconds());
    System.out.println(t1.isBefore(t2));
    System.out.println(t1.isBefore(t3));

    System.out.println(t1.timeUntil(t2));
    System.out.println(t1.timeUntil(t3));
    System.out.println(t1.timeSince(t2));
    System.out.println(t1.timeSince(t3));

    System.out.println(Time.now());

    System.out.println(t1.equals(t2));
    System.out.println(t1.equals(t4));
  }
}
