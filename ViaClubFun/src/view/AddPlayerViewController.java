package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Player;
import model.PlayerList;
import model.ViaClubModelManager;

import java.awt.*;
import java.util.ArrayList;

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
  @FXML private MenuItem aboutMenuItem;
  @FXML private MenuItem helpMenuItem;

  @FXML private TextField nameField;
  @FXML private ComboBox<Integer> numberBox;

  @FXML private ListView<String> positionsList;

  @FXML private ComboBox<String> positionsBox;

  private Player editPlayer;

  public void init(ViewHandler viewHandler, ViaClubModelManager modelManager,
      Region root)
  {
    this.modelManager = modelManager;
    this.root = root;
    this.viewHandler = viewHandler;
    positionsList.getSelectionModel().selectedItemProperty()
        .addListener((new MyListListener()));
    positionsBox.getSelectionModel().selectedItemProperty()
        .addListener((new MyListener2()));
    reset();
  }

  public void reset()
  {
    setNumberBox();
    editPlayer = null;
    nameField.clear();
    numberBox.setValue(null);
    positionsList.getItems().clear();
    updatePositionsBox();
  }

  public Region getRoot()
  {
    return root;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == addButton)
    {
      positionsList.getItems()
          .add(positionsBox.getSelectionModel().getSelectedItem());
      positionsBox.getItems().clear();
      updatePositionsBox();
      addButton.setDisable(true);
    }

    else if (e.getSource() == removeButton)
    {
      positionsList.getItems()
          .remove(positionsList.getSelectionModel().getSelectedItem());
      updatePositionsBox();
    }

    else if (e.getSource() == saveButton)
    {
      Player temp = new Player(nameField.getText());
      if (numberBox.getSelectionModel().getSelectedItem() != null)
      {
        temp.setNumber(numberBox.getSelectionModel().getSelectedItem());
      }

      for (int i = 0; i < positionsList.getItems().size(); i++)
      {
        temp.addPosition(positionsList.getItems().get(i));
      }

      PlayerList tempList = modelManager.getAllPlayers();

      if (editPlayer != null)
      {
        tempList.set(modelManager.getAllPlayers()
            .getIndex(editPlayer.getName(), editPlayer.getNumber()), temp);
      }

      else
      {
        tempList.add(temp);
      }
      modelManager.savePlayers(tempList);
      viewHandler.openView("MainView");
    }

    else if (e.getSource() == cancelButton)
    {
      viewHandler.openView("MainView");
    }

    else if (e.getSource() == positionsBox)
    {

    }

    else if (e.getSource() == exitMenuItem)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
          "Do you really want to exit the program?", ButtonType.YES,
          ButtonType.NO);
      alert.setTitle("Exit");
      alert.setHeaderText(null);

      alert.showAndWait();

      if (alert.getResult() == ButtonType.YES)
      {
        System.exit(0);
      }
    }

    else if (e.getSource() == aboutMenuItem)
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION,
          "Here you can add or edit a player.", ButtonType.OK);
      alert.setTitle("About");
      alert.setHeaderText(null);
      alert.showAndWait();
    }

    else if (e.getSource() == helpMenuItem)
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION,
          "For client support, please refer to JavaGods.", ButtonType.OK);
      alert.setTitle("About");
      alert.setHeaderText(null);
      alert.showAndWait();
    }
  }

  public void setNumberBox()
  {
    ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
    for (int i = 0; i < modelManager.getAllPlayers().size(); i++)
    {
      usedNumbers.add(modelManager.getAllPlayers().get(i).getNumber());
    }
    for (int i = 0; i < 99; i++)
    {
      if (!(usedNumbers.contains(i + 1)))
      {
        numberBox.getItems().add(i + 1);
      }
    }
  }

  private void updatePositionsList(Player player)
  {
    if (modelManager != null)
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
    numberBox.setValue(player.getNumber());

    if (player.getPositions().size() > 0)
    {
      positionsList.getItems().clear();
      for (int i = 0; i < player.getPositions().size(); i++)
      {
        positionsList.getItems().add(player.getPositions().get(i));
      }
    }

    editPlayer = player;
    updatePositionsBox();
  }

  public void updatePositionsBox()
  {

    ArrayList<String> positions = new ArrayList<String>();
    positions.add("Goalkeeper");
    positions.add("Sweeper");
    positions.add("Centre-Back");
    positions.add("Full-Back");
    positions.add("Defensive Midfielder");
    positions.add("Central Midfielder");
    positions.add("Attacking Midfielder");
    positions.add("Forward");
    positions.add("Winger");
    positions.add("Striker");
    positionsBox.getItems().clear();
    ArrayList<String> usedPositions = new ArrayList<String>();

    for (int i = 0; i < positionsList.getItems().size(); i++)
    {
      usedPositions.add(positionsList.getItems().get(i));
    }

    for (int j = 0; j < positions.size(); j++)
    {
      if (!(usedPositions.contains(positions.get(j))))
      {
        positionsBox.getItems().add(positions.get(j));
      }
    }
  }

  private class MyListListener implements ChangeListener<String>
  {
    public void changed(ObservableValue<? extends String> position,
        String oldPosition, String newPosition)
    {
      removeButton.setDisable(false);
    }
  }

  private class MyListener2 implements ChangeListener<String>
  {
    public void changed(ObservableValue<? extends String> position,
        String oldPosition, String newPosition)
    {
      addButton.setDisable(false);
    }
  }
}
