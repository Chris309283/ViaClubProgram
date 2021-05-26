import model.Player;
import model.PlayerList;
import model.ViaClubModelManager;

import java.util.ArrayList;

public class test
{
  public static void main(String[] args)
  {
    ViaClubModelManager m = new ViaClubModelManager("ViaClubFun\\src\\players.bin","src\\matches.bin");
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

  }
}
