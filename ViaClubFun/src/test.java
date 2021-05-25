import model.ViaClubModelManager;

public class test
{
  public static void main(String[] args)
  {
    ViaClubModelManager m = new ViaClubModelManager("C:\\Users\\Christopher\\IdeaProjects\\Workspace\\ViaClubPlayGround\\src\\players.bin","C:\\Users\\Christopher\\IdeaProjects\\Workspace\\ViaClubPlayGround\\src\\matches.bin");
    System.out.println(m.getAllPlayers());
  }
}
