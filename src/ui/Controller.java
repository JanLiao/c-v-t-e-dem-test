package ui;
/** 
* @author: jan 
* @date: 2018年5月22日 上午12:01:24 
*/
import java.io.File;
import java.io.PipedInputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
//import utility.TableFileValue;
//import utility.Person;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;

public class Controller implements Initializable{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Help"
    private Menu Help; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpettro"
    private Button btnSpettro; // Value injected by FXMLLoader

    @FXML // fx:id="lblAnalisiCom"
    private Label lblAnalisiCom; // Value injected by FXMLLoader

    @FXML // fx:id="tabRegistra"
    private Tab tabRegistra; // Value injected by FXMLLoader

    @FXML // fx:id="Split1"
    private SplitPane Split1; // Value injected by FXMLLoader

    @FXML // fx:id="MenuBar"
    private MenuBar MenuBar; // Value injected by FXMLLoader

    @FXML // fx:id="lblAnalisiSing"
    private Label lblAnalisiSing; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpettrogram"
    private Button btnSpettrogram; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizza"
    private Button btnAnalizza; // Value injected by FXMLLoader

    @FXML // fx:id="ColData"
    private TableColumn<PopulateTable, String> colDate; // Value injected by FXMLLoader

    @FXML // fx:id="GuidaOnline"
    private MenuItem GuidaOnline; // Value injected by FXMLLoader

    @FXML // fx:id="ColNome"
    private TableColumn<PopulateTable, String> colName; // Value injected by FXMLLoader

    @FXML // fx:id="Table1"
    private TableView<PopulateTable> Table1; // Value injected by FXMLLoader

    @FXML // fx:id="Hbox"
    private HBox Hbox; // Value injected by FXMLLoader

    @FXML // fx:id="btnPulsazioni"
    private Button btnPulsazioni; // Value injected by FXMLLoader

    @FXML // fx:id="btnRimuovi"
    private Button btnRimuovi; // Value injected by FXMLLoader

    @FXML // fx:id="ColNum"
    private TableColumn<PopulateTable,Integer> colCount; // Value injected by FXMLLoader

    @FXML // fx:id="tabElenco"
    private Tab tabElenco; // Value injected by FXMLLoader

    @FXML // fx:id="RightStatus"
    private Label RightStatus; // Value injected by FXMLLoader

    @FXML // fx:id="Scroll2"
    private ScrollPane Scroll2; // Value injected by FXMLLoader

    @FXML // fx:id="Scroll1"
    private ScrollPane Scroll1; // Value injected by FXMLLoader

    @FXML // fx:id="Pane"
    private Pane Pane; // Value injected by FXMLLoader

    @FXML // fx:id="About"
    private MenuItem About; // Value injected by FXMLLoader

    @FXML // fx:id="Anchor1"
    private AnchorPane Anchor1; // Value injected by FXMLLoader

    @FXML // fx:id="Anchor2"
    private AnchorPane Anchor2; // Value injected by FXMLLoader

    @FXML // fx:id="LeftStatus"
    private Label LeftStatus; // Value injected by FXMLLoader

    @FXML // fx:id="btnAggiungi"
    private Button btnAggiungi; // Value injected by FXMLLoader

    @FXML // fx:id="btnPicchi"
    private Button btnPicchi; // Value injected by FXMLLoader

    @FXML // fx:id="Manuale"
    private MenuItem Manuale; // Value injected by FXMLLoader

    @FXML // fx:id="btnFormanti"
    private Button btnFormanti; // Value injected by FXMLLoader

    @FXML // fx:id="btnIntensita"
    private Button btnIntensita; // Value injected by FXMLLoader

    @FXML // fx:id="Tab1"
    private TabPane Tab1; // Value injected by FXMLLoader

    @FXML // fx:id="x3"
    private Font x3; // Value injected by FXMLLoader

    @FXML // fx:id="x4"
    private Color x4; // Value injected by FXMLLoader

    @FXML // fx:id="VBox"
    private VBox VBox; // Value injected by FXMLLoader

    @FXML // fx:id="Riconoscimenti"
    private MenuItem Riconoscimenti; // Value injected by FXMLLoader

    @FXML // fx:id="Separator"
    private SeparatorMenuItem Separator; // Value injected by FXMLLoader



    String fileName;

    @FXML
    /**
     * Apertura della finestra fileChooser per il caricamento dei file audio,
     * sono accettati solo file con estensione .wav e .mp3.
     * Estrazione del nome del file.
     * 
     * @param event 
     */
    public void AddFileAudio(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Seleziona il file da caricare");
         fileChooser.getExtensionFilters().addAll(
                 new ExtensionFilter("Audio Files", "*.wav", "*.mp3"));
         File selectedFile = fileChooser.showOpenDialog(new Stage());        
         if (selectedFile != null) {
             fileName = selectedFile.getName();
             colName.setText(fileName);

             }

   }


    public ObservableList<PopulateTable>    list = FXCollections.observableArrayList(
            new PopulateTable(1, fileName, "date1"),
            new PopulateTable(2, "name2", "date2"),
            new PopulateTable(3, "name3", "date3")); 


    public void initialize(URL location, ResourceBundle resource) {

        colCount.setCellValueFactory(new PropertyValueFactory<PopulateTable,Integer>("count"));
        colName.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("name"));
        colDate.setCellValueFactory(new PropertyValueFactory<PopulateTable,String>("date"));
        Table1.setItems(list);

        assert Help != null : "fx:id=\"Help\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert btnSpettro != null : "fx:id=\"btnSpettro\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert lblAnalisiCom != null : "fx:id=\"lblAnalisiCom\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert tabRegistra != null : "fx:id=\"tabRegistra\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Split1 != null : "fx:id=\"Split1\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert MenuBar != null : "fx:id=\"MenuBar\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert lblAnalisiSing != null : "fx:id=\"lblAnalisiSing\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert btnSpettrogram != null : "fx:id=\"btnSpettrogram\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert colDate != null : "fx:id=\"ColData\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert GuidaOnline != null : "fx:id=\"GuidaOnline\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert colName != null : "fx:id=\"ColNome\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Table1 != null : "fx:id=\"Table1\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Hbox != null : "fx:id=\"Hbox\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert btnPulsazioni != null : "fx:id=\"btnPulsazioni\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert btnRimuovi != null : "fx:id=\"btnRimuovi\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert colCount != null : "fx:id=\"ColNum\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert tabElenco != null : "fx:id=\"tabElenco\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert RightStatus != null : "fx:id=\"RightStatus\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Scroll2 != null : "fx:id=\"Scroll2\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Scroll1 != null : "fx:id=\"Scroll1\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Pane != null : "fx:id=\"Pane\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert About != null : "fx:id=\"About\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Anchor1 != null : "fx:id=\"Anchor1\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Anchor2 != null : "fx:id=\"Anchor2\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert LeftStatus != null : "fx:id=\"LeftStatus\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert btnPicchi != null : "fx:id=\"btnPicchi\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Manuale != null : "fx:id=\"Manuale\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert btnFormanti != null : "fx:id=\"btnFormanti\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert btnIntensita != null : "fx:id=\"btnIntensita\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Tab1 != null : "fx:id=\"Tab1\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert VBox != null : "fx:id=\"VBox\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Riconoscimenti != null : "fx:id=\"Riconoscimenti\" was not injected: check your FXML file 'StartGUI.fxml'.";
        assert Separator != null : "fx:id=\"Separator\" was not injected: check your FXML file 'StartGUI.fxml'.";

    }

}
