package view;

import model.ViaClubModelManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class StartGUI extends Application
{
  public void start(Stage window) throws Exception
  {
    ViaClubModelManager modelManager = new ViaClubModelManager("src\\players.bin","src\\matches.bin");
    ViewHandler viewHandler = new ViewHandler(modelManager);
    viewHandler.start(window);
  }
}
