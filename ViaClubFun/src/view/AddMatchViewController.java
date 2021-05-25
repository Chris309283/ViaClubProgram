package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Player;
import model.ViaClubModelManager;

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

  @FXML private TextField startTimeField;
  @FXML private TextField endTimeField;
  @FXML private TextField opponentField;
  @FXML private TextField searchField;
  @FXML private MenuItem exitMenuItem;

  @FXML private ListView<Player> allPlayersList;
  @FXML private ListView<Player> lineUpList;
  @FXML private ListView<Player> benchList;

  @FXML private RadioButton fieldRadio;
  @FXML private RadioButton benchRadio;

  public void init(ViewHandler viewHandler, ViaClubModelManager modelManager, Region root)
  {
    this.modelManager=modelManager;
    this.root=root;
    this.viewHandler=viewHandler;
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
}
