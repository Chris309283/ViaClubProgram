package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.MatchList;
import model.Player;
import model.PlayerList;
import model.ViaClubModelManager;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class MainViewController
{
  private Region root;
  private ViaClubModelManager modelManager;
  private ViewHandler viewHandler;

  @FXML private Button playerSearchButton;
  @FXML private Button matchSearchButton;
  @FXML private Button addPlayerButton;
  @FXML private Button addMatchButton;
  @FXML private Button removePlayerButton;
  @FXML private Button removeMatchButton;
  @FXML private Button editPlayerButton;
  @FXML private Button editMatchButton;
  @FXML private Button playerAvailability;

  @FXML private MenuItem exitMenuItem;

  @FXML private Tab playerListTab;
  @FXML private Tab matchListTab;

  @FXML private ListView<Player> allPlayersList;
  @FXML private TextArea allMatchesArea;

  @FXML private TextField searchPlayersField;
  @FXML private TextField searchMatchesField;

  @FXML private ComboBox<String> playerSearchComboBox;
  @FXML private ComboBox<String> matchSearchComboBox;
  @FXML private ComboBox<String> matchDateComboBox;

  public void init(ViewHandler viewHandler,ViaClubModelManager modelManager, Region root)
  {
    this.modelManager=modelManager;
    this.root = root;
    this.viewHandler=viewHandler;
    allPlayersList.getSelectionModel().selectedItemProperty().addListener((new MyListListener()));
    reset();
  }

  public void reset()
  {
    updatePlayerList();
    updateMatchArea();
  }

  public Region getRoot()
  {
    return root;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == addPlayerButton)
    {
      viewHandler.openView("AddPlayerView");
    }
    else if (e.getSource() == addMatchButton)
    {
      viewHandler.openView("AddMatchView");
    }
    else if (e.getSource()== editPlayerButton)
    {
      viewHandler.openView("AddPlayerView");
      viewHandler.getAddPlayerViewController().setFields(allPlayersList.getSelectionModel().getSelectedItem());
    }
    else if (e.getSource() == playerAvailability)
    {
      viewHandler.openView("UnavailabilityView");
    }
    else if (e.getSource()==searchPlayersField)
    {

    }



    else if( e.getSource()==exitMenuItem){

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


  private void updatePlayerList()
  {
   if(modelManager!=null)
   {
     allPlayersList.getItems().clear();
     PlayerList players = modelManager.getAllPlayers();
     for (int i = 0; i < players.size(); i++)
     {
       allPlayersList.getItems().add(players.get(i));
     }
   }
  }

  private void updateMatchArea()
  {
    MatchList matches = modelManager.getAllMatches();
    allMatchesArea.setText(matches.toString());
  }

  public void tabChanged(Event e)
  {
    if (playerListTab.isSelected())
    {
      updatePlayerList();
    }
    else if (matchListTab.isSelected())
    {
      updateMatchArea();
    }
  }

  private class MyListListener implements ChangeListener<Player>
  {
    public void changed(ObservableValue<? extends Player> player, Player oldPlayer, Player newPlayer)
    {
      editPlayerButton.setDisable(false);
      removePlayerButton.setDisable(false);
      playerAvailability.setDisable(false);
    }
  }

}
