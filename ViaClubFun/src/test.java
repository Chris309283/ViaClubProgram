import model.*;


public class test
{
  public static void main(String[] args)
  {
    ViaClubModelManager m = new ViaClubModelManager("ViaClubFun\\src\\players.bin","ViaClubFun\\src\\matches.bin");
    System.out.println(m.getAllPlayers());



    PlayerList p1= new PlayerList();
    Player pl1 =new Player("bob", 31);
    Player pl2 =new Player("bob2", 32);
    p1.add(pl1);
    p1.add(pl2);



  }
}
