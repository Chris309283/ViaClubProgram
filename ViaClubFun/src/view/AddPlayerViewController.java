package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Player;
import model.PlayerList;
import model.ViaClubModelManager;

public class AddPlayerViewController
{
  private Region root;
  private ViaClubModelManager modelManager;
  private ViewHandler viewHandler;

  @FXML private Button addButton;
  @FXML private Button removeButton;
  @FXML private Button saveButton;
  @FXML private Button cancelButton;
  @FXML private MenuItem exitMenuItem;

  @FXML private TextField nameField;
  @FXML private TextField numberField;

  @FXML private TextArea positionsArea;

  @FXML private ComboBox positionsBox;

  public void init(ViewHandler viewHandler, ViaClubModelManager modelManager, Region root)
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
    if (e.getSource()==addButton)
    {

    }
    else if (e.getSource()==removeButton)
    {

    }
    else if (e.getSource()==saveButton)
    {
      Player temp = new Player(nameField.getText());
      PlayerList tempList = new PlayerList();

      for (int i = 0; i < modelManager.getAllPlayers().size(); i++)
      {
        tempList.add(modelManager.getAllPlayers().get(i));
      }
      tempList.add(temp);
      modelManager.savePlayers(tempList);
      viewHandler.openView("MainView");
    }
    else if (e.getSource()==cancelButton)
    {
      viewHandler.openView("MainView");
    }
    else if (e.getSource()==positionsBox)
    {

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

  public void setFields(Player player)
  {
    nameField.setText(player.getName());
    numberField.setText(player.getNumber()+"");
  }
}
