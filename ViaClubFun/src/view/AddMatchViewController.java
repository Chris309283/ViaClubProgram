package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;

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
  @FXML private ComboBox<String> matchTypeBox;

  @FXML private TextField opponentField;
  @FXML private TextField searchField;

  @FXML private Spinner<Integer> homeScoreSpinner;
  @FXML private Spinner<Integer> opponentScoreSpinner;

  @FXML private MenuItem exitMenuItem;
  @FXML private MenuItem aboutMenuItem;
  @FXML private MenuItem helpMenuItem;

  @FXML private ListView<Player> allPlayersList;
  @FXML private ListView<Player> lineUpAndBenchList;

  @FXML private ToggleGroup fieldAndBenchGroup;
  @FXML private RadioButton fieldRadio;
  @FXML private RadioButton benchRadio;

  @FXML private ToggleGroup gamePlaceGroup;
  @FXML private RadioButton homeRadio;
  @FXML private RadioButton awayRadio;

  private Match editMatch;
  private boolean gamePlaceBoolean;
  private boolean lineUpListBoolean;
  private PlayerList tempField;
  private PlayerList tempBench;

  public void init(ViewHandler viewHandler, ViaClubModelManager modelManager,
      Region root)
  {
    this.modelManager = modelManager;
    this.root = root;
    this.viewHandler = viewHandler;
    datePicker.setValue(LocalDate.now());
    tempField = new PlayerList();
    tempBench = new PlayerList();
    reset();
  }

  public void reset()
  {
    tempBench.clear();
    tempField.clear();
    setSpinners();
    updatePlayerList();
    updateTimeBoxes();
    setToggle();
    setMatchTypeBox();
    updateFieldList();
    lineUpListBoolean=true;
  }

  public Region getRoot()
  {
    return root;
  }

  public void handleActions(ActionEvent e)
  {

    if (e.getSource() == searchButton)
    {

    }
    else if (e.getSource() == addButton)
    {
      if (lineUpListBoolean)
      {
        tempField.add(allPlayersList.getSelectionModel().getSelectedItem());
        updateFieldList();
      }
      else
      {
        tempBench.add(allPlayersList.getSelectionModel().getSelectedItem());
        updateBenchList();
      }
    }

    else if (e.getSource() == removeButton)
    {
      if (lineUpListBoolean)
      {
        tempField
            .remove(lineUpAndBenchList.getSelectionModel().getSelectedItem());
        updateFieldList();
      }
      else
      {
        tempBench
            .remove(lineUpAndBenchList.getSelectionModel().getSelectedItem());
        updateBenchList();
      }
    }

    else if (e.getSource() == saveButton)
    {
      if (matchTypeBox.getSelectionModel().getSelectedIndex()!=1&&matchTypeBox.getSelectionModel().getSelectedIndex()!=2&&matchTypeBox.getSelectionModel().getSelectedIndex()!=3)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR,
            "Please Input a Match Type", ButtonType.CLOSE);
        alert.setTitle("Error");
        alert.setHeaderText(null);

        alert.showAndWait();
      }
      else {
        Time stTemp = new Time(
            startTimeHourBox.getSelectionModel().getSelectedItem(),
            startTimeMinuteBox.getSelectionModel().getSelectedItem(), 0);

        Time etTemp = new Time(
            endTimeHourBox.getSelectionModel().getSelectedItem(),
            endTimeMinuteBox.getSelectionModel().getSelectedItem(), 0);

        Date dTemp = new Date(datePicker.getValue().getDayOfMonth(),
            datePicker.getValue().getMonthValue(),
            datePicker.getValue().getYear());

        Match temp = new Match(stTemp, etTemp, dTemp, opponentField.getText(),
            matchTypeBox.getSelectionModel().getSelectedItem(), gamePlaceBoolean);

        temp.addBench(tempBench);
        temp.addLineUp(tempField);

        temp.setScoreHomeTeam(homeScoreSpinner.getValue());
        temp.setScoreOpponent(opponentScoreSpinner.getValue());

        MatchList tempList = modelManager.getAllMatches();

        if (editMatch != null)
        {
          tempList.set(modelManager.getAllMatches()
              .getIndex(editMatch.getStartTime(), editMatch.getEndTime(),
                  editMatch.getDate(), editMatch.getOpponent(),
                  editMatch.getMatchType(), editMatch.getIsAwayGame()), temp);
        }
        else
        {
          tempList.add(temp);
        }
        modelManager.saveMatches(tempList);
        viewHandler.openView("MainView");
      }
    }

    else if (e.getSource() == cancelButton)
    {
      viewHandler.openView("MainView");
    }

    else if (e.getSource() == awayRadio)
    {
      gamePlaceBoolean = true;
    }

    else if (e.getSource() == homeRadio)
    {
      gamePlaceBoolean = false;
    }

    else if (e.getSource() == fieldRadio)
    {
      lineUpListBoolean = true;
      updateFieldList();
    }

    else if (e.getSource() == benchRadio)
    {
      lineUpListBoolean = false;
      updateBenchList();
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
    else if(e.getSource()==aboutMenuItem){
      Alert alert = new Alert(Alert.AlertType.INFORMATION,
          "Here you can create or edit a match", ButtonType.OK);
      alert.setTitle("About");
      alert.setHeaderText(null);
      alert.showAndWait();
    }
    else if(e.getSource()==helpMenuItem){
      Alert alert = new Alert(Alert.AlertType.INFORMATION,
          "For client support, please refer to JavaGods.", ButtonType.OK);
      alert.setTitle("About");
      alert.setHeaderText(null);
      alert.showAndWait();
    }

  }

  public void updateTimeBoxes()
  {
    startTimeHourBox.getItems().clear();
    startTimeMinuteBox.getItems().clear();
    endTimeHourBox.getItems().clear();
    endTimeMinuteBox.getItems().clear();

    for (int i = 0; i < 24; i++)
    {
      startTimeHourBox.getItems().add(i);
      endTimeHourBox.getItems().add(i);
    }
    startTimeHourBox.getSelectionModel().select(12);
    endTimeHourBox.getSelectionModel().select(12);

    for (int i = 0; i < 60; i++)
    {
      startTimeMinuteBox.getItems().add(i);
      endTimeMinuteBox.getItems().add(i);
    }
    startTimeMinuteBox.getSelectionModel().select(30);
    endTimeMinuteBox.getSelectionModel().select(30);
  }

  public void setToggle()
  {
    fieldRadio.setSelected(true);

    homeRadio.setSelected(true);
  }

  public void setMatchTypeBox()
  {
    matchTypeBox.getItems().clear();
    matchTypeBox.getItems().add("League");
    matchTypeBox.getItems().add("Cup");
    matchTypeBox.getItems().add("Friendly");
  }

  private void updatePlayerList()
  {
    if (modelManager != null)
    {
      allPlayersList.getItems().clear();

      PlayerList players = modelManager.getAllPlayers();
      for (int i = 0; i < players.size(); i++)
      {
        allPlayersList.getItems().add(players.get(i));
      }
    }
  }

  private void updateFieldList()
  {
    lineUpAndBenchList.getItems().clear();

    for (int i = 0; i < tempField.size(); i++)
    {
      lineUpAndBenchList.getItems().add(tempField.get(i));
    }
  }

  private void updateBenchList()
  {
    lineUpAndBenchList.getItems().clear();

    for (int i = 0; i < tempBench.size(); i++)
    {
      lineUpAndBenchList.getItems().add(tempBench.get(i));
    }
  }

  private void setSpinners()
  {
    SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,40,0);
    SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,40,0);
    homeScoreSpinner.setValueFactory(valueFactory);
    opponentScoreSpinner.setValueFactory(valueFactory2);
  }

  public void setFields(Match match)
  {
    datePicker.setValue(LocalDate
        .of((match.getDate().getYear()), (match.getDate().getMonth()),
            (match.getDate().getDay())));

    matchTypeBox.getSelectionModel().select(match.getMatchType());

    startTimeHourBox.getSelectionModel().select(match.getStartTime().getHour());

    endTimeHourBox.getSelectionModel().select(match.getEndTime().getHour());

    startTimeMinuteBox.getSelectionModel()
        .select(match.getStartTime().getMinute());

    endTimeMinuteBox.getSelectionModel().select(match.getEndTime().getMinute());

    opponentField.setText(match.getOpponent());

    tempField = match.getLineUp();

    tempBench = match.getBench();

    updateFieldList();

    if (match.getIsAwayGame())
    {
      awayRadio.setSelected(true);
    }

    editMatch = match;
  }
}
