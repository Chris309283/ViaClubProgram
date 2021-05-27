import model.*;

import java.util.ArrayList;

public class test
{
  public static void main(String[] args)
  {
    ViaClubModelManager m = new ViaClubModelManager("ViaClubFun\\src\\players.bin","ViaClubFun\\src\\matches.bin");
    System.out.println(m.getAllPlayers());

    System.out.println(m.getAllPlayers());


    PlayerList p1= new PlayerList();
    Player pl1 =new Player("bob", 31);
    Player pl2 =new Player("bob2", 32);
    p1.add(pl1);
    p1.add(pl2);
    System.out.println(p1);


    System.out.println(p1);


    PlayerList temp= new PlayerList();
    temp=m.getAllPlayers();

   temp.remove(m.getAllPlayers().get(1));


    System.out.println(temp);

    System.out.println(p1.getIndex("bob2",32));
    System.out.println(p1.size());

    Match m1 = new Match(new Time(12,12,0),new Time(14,12,0),Date.today(),"test","Cup",true);
    Match m2 = new Match(new Time(12,12,0),new Time(14,12,0),Date.today(),"test","Cup",true);
    m1.addBench(p1);
    m1.addLineUp(p1);

    System.out.println(m1);

    m2.addLineUp(p1);
    m2.addBench(p1);

    MatchList ml1 = new MatchList();
    ml1.add(m1);
    ml1.add(m2);

    System.out.println("----------------");



    System.out.println(m.getAllMatches());

    Unavailability u1= new Unavailability(Date.today(),10);
    pl1.addUnavailability(u1);

  pl1.addUnavailability(u1);
    System.out.println(u1);

    System.out.println(pl1.getAllUnavailabilities());

    System.out.println(pl2.getAllUnavailabilities()==null);
  }
}
