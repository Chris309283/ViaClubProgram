package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Player;
import model.ViaClubModelManager;

public class UnavailabilityViewController
{
  private Region root;
  private ViaClubModelManager modelManager;
  private ViewHandler viewHandler;

  @FXML private Button addSuspensionButton;
  @FXML private Button addInjuryButton;
  @FXML private Button removeButton;
  @FXML private Button saveButton;
  @FXML private Button cancelButton;
  @FXML private MenuItem exitMenuItem;

  @FXML private TextField nameField;

  public void init(ViewHandler viewHandler, ViaClubModelManager modelManager,
      Region root)
  {
    this.modelManager = modelManager;
    this.root = root;
    this.viewHandler = viewHandler;
    reset();
  }

  public void reset()
  {

  }

  public Region getRoot()
  {
    return root;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == saveButton)
    {

    }
    else if (e.getSource() == cancelButton)
    {
      viewHandler.openView("MainView");
    }
    else if(e.getSource()==exitMenuItem){

      Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
          "Do you really want to exit the program?",
          ButtonType.YES, ButtonType.NO);
      alert.setTitle("Exit");
      alert.setHeaderText(null);

      alert.showAndWait();

      if (alert.getResult() == ButtonType.YES)
      {
        System.exit(0);
      }
    }
  }
public void setName(Player player){
    nameField.setText(player.getName());
}

}
