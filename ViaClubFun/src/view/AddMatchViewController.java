package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Player;
import model.ViaClubModelManager;

import java.time.LocalDate;

public class AddMatchViewController
{
  private Region root;
  private ViaClubModelManager modelManager;
  private ViewHandler viewHandler;

  @FXML private Button searchButton;
  @FXML private Button addButton;
  @FXML private Button removeButton;
  @FXML private Button saveButton;
  @FXML private Button cancelButton;

  @FXML private DatePicker datePicker;

  @FXML private ComboBox<Integer> startTimeHourBox;
  @FXML private ComboBox<Integer> endTimeHourBox;
  @FXML private ComboBox<Integer> startTimeMinuteBox;
  @FXML private ComboBox<Integer> endTimeMinuteBox;
  @FXML private ComboBox<String> searchBox;

  @FXML private TextField opponentField;
  @FXML private TextField searchField;

  @FXML private MenuItem exitMenuItem;

  @FXML private ListView<Player> allPlayersList;
  @FXML private ListView<Player> lineUpAndBenchList;

  @FXML private ToggleGroup fieldAndBenchGroup;
  @FXML private RadioButton fieldRadio;
  @FXML private RadioButton benchRadio;

  @FXML private ToggleGroup gamePlaceGroup;
  @FXML private RadioButton homeRadio;
  @FXML private RadioButton awayRadio;

  public void init(ViewHandler viewHandler, ViaClubModelManager modelManager, Region root)
  {
    this.modelManager=modelManager;
    this.root=root;
    this.viewHandler=viewHandler;
    datePicker.setValue(LocalDate.now());
    reset();
  }

  public void reset()
  {
    updateTimeBoxes();
    setToggle();
  }

  public Region getRoot()
  {
    return root;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource()==searchButton)
    {

    }
    else if (e.getSource()==addButton)
    {

    }
    else if (e.getSource()==removeButton)
    {

    }
    else if (e.getSource()==saveButton)
    {

    }
    else if (e.getSource()==cancelButton)
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

  public void updateTimeBoxes()
  {
    for (int i = 0; i < 24; i++)
    {
      startTimeHourBox.getItems().add(i);
      endTimeHourBox.getItems().add(i);
    }
    for (int i = 0; i < 60; i++)
    {
      startTimeMinuteBox.getItems().add(i);
      endTimeMinuteBox.getItems().add(i);
    }
  }

  public void setToggle()
  {
    fieldRadio.setSelected(true);

    homeRadio.setSelected(true);
  }


}
