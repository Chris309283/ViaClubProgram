package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;

import java.util.ArrayList;

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
  @FXML private Button forceAvailableButton;

  @FXML private MenuItem exitMenuItem;
  @FXML private ListView<Unavailability> unavailabilityListView;
  @FXML private DatePicker fromDatePicker;
  @FXML private DatePicker toDatePicker;
  @FXML private ComboBox<Integer> numberOfGamesBox;
  @FXML private TextField nameField;

  private Player player;

  public void init(ViewHandler viewHandler, ViaClubModelManager modelManager,
      Region root)
  {
    this.modelManager = modelManager;
    this.root = root;
    this.viewHandler = viewHandler;
    unavailabilityListView.getSelectionModel().selectedItemProperty()
        .addListener((new MyListListener()));

    reset();
  }

  public void reset()
  {
    setNumberOfGamesBox();
    player = null;
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

    else if (e.getSource() == addSuspensionButton)
    {
      unavailabilityListView.getItems().add(new Unavailability(Date.today(),
          numberOfGamesBox.getSelectionModel().getSelectedItem()));
    }

    else if (e.getSource() == addInjuryButton)
    {
      unavailabilityListView.getItems().add(new Unavailability("Injured",
          new Date(fromDatePicker.getValue().getDayOfMonth(),
              fromDatePicker.getValue().getMonthValue(),
              fromDatePicker.getValue().getYear())));
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
    else if (e.getSource() == removeButton)
    {
      unavailabilityListView.getItems()
          .remove(unavailabilityListView.getSelectionModel().getSelectedItem());
    }
  }

  public void setFields(Player player)
  {
    nameField.setText(player.getName());
    if (player.getAllUnavailabilities().size() > 0)
    {
      unavailabilityListView.getItems().clear();
      for (int i = 0; i < player.getAllUnavailabilities().size(); i++)
      {
        unavailabilityListView.getItems()
            .add(player.getAllUnavailabilities().get(i));
      }
    }
    this.player = player;
  }

  public void setNumberOfGamesBox()
  {
    for (int i = 0; i < 10; i++)
    {
      numberOfGamesBox.getItems().add(i + 1);
    }
  }

  public void updateUnavailabilityList()
  {
    if (modelManager != null && player != null)
    {
      unavailabilityListView.getItems().clear();
      ArrayList<Unavailability> unavailabilities = player
          .getAllUnavailabilities();
      for (int i = 0; i < unavailabilities.size(); i++)
      {
        unavailabilityListView.getItems().add(unavailabilities.get(i));
      }
    }

  }

  private class MyListListener implements ChangeListener<Unavailability>
  {
    public void changed(
        ObservableValue<? extends Unavailability> unavailability,
        Unavailability oldUnavailability, Unavailability newUnavailability)
    {
      removeButton.setDisable(false);

    }
  }
}
