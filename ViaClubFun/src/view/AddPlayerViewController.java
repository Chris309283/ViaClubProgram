package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

  @FXML private ListView<String> positionsList;

  @FXML private ComboBox<String> positionsBox;

  public void init(ViewHandler viewHandler, ViaClubModelManager modelManager, Region root)
  {
    this.modelManager = modelManager;
    this.root = root;
    this.viewHandler = viewHandler;
    positionsList.getSelectionModel().selectedItemProperty().addListener((new MyListListener()));
    reset();
  }

  public void reset()
  {
   updatePositionsBox();
  }

  public Region getRoot()
  {
    return root;
  }

  public void handleActions(ActionEvent e)
  {

    if (e.getSource()==addButton)
    {
      positionsList.getItems().add(positionsBox.getSelectionModel().getSelectedItem());
    }
    else if (e.getSource()==removeButton)
    {
      positionsList.getItems().remove(positionsList.getSelectionModel().getSelectedItem());
    }
    else if (e.getSource()==saveButton)
    {
      Player temp = new Player(nameField.getText());
      if (!(numberField.getText().equals("")))
      {
        temp.setNumber(Integer.parseInt(numberField.getText()));
      }
      for (int i = 0; i < positionsList.getItems().size(); i++)
      {
        temp.addPosition(positionsList.getItems().get(i));
      }
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

  private void updatePositionsList(Player player)
  {
    if (modelManager!=null)
    {
      positionsList.getItems().clear();
      for (int i = 0; i < player.getPositions().size(); i++)
      {
        positionsList.getItems().add(player.getPositions().get(i));
      }
    }
  }

  public void setFields(Player player)
  {
    nameField.setText(player.getName());
    numberField.setText(player.getNumber()+"");
    if (player.getPositions().size()>0)
    {
      positionsList.getItems().clear();
      for (int i = 0; i < player.getPositions().size(); i++)
      {
        positionsList.getItems().add(player.getPositions().get(i));
      }
    }
  }

  private void updatePositionsBox()
  {
    positionsBox.getItems().add("Goalkeeper");
    positionsBox.getItems().add("Sweeper");
    positionsBox.getItems().add("Centre-Back");
    positionsBox.getItems().add("Full-Back");
    positionsBox.getItems().add("Defensive Midfielder");
    positionsBox.getItems().add("Central Midfielder");
    positionsBox.getItems().add("Attacking Midfielder");
    positionsBox.getItems().add("Forward");
    positionsBox.getItems().add("Winger");
    positionsBox.getItems().add("Striker");
  }

  private class MyListListener implements ChangeListener<String>
  {
    public void changed(ObservableValue<? extends String> position, String oldPosition, String newPosition)
    {
      removeButton.setDisable(false);
    }
  }
}
