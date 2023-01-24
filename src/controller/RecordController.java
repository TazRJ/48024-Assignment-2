package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import model.*;



public class RecordController extends Controller<Library>{
    @FXML private TextField idTf;
    @FXML private Button showBtn;
    @FXML private ListView<Book> currentLv;
    @FXML private ListView<Book> historyLv;
    @FXML private Text msgTxt;
    
    public final Library getLibrary() { 
        return model; 
    }
    
    private int getID() { 
        return Integer.parseInt(idTf.getText()); 
    }
    private void setID(int id) { 
        idTf.setText("" + id); 
    }
    
    @FXML private void initialize() {
        idTf.textProperty().addListener( (observable, oldID, newID) -> showBtn.setDisable(newID.length() < 1));
        msgTxt.setText("No Patron Selected");   
    }

    @FXML private void handleShow (ActionEvent event) {
        Library library = getLibrary();
        if (library.getPatron(getID()) != null) {
            msgTxt.setText(""+ library.getPatron(getID()));
            currentLv.setItems(library.getPatron(getID()).currentlyBorrowed());
            historyLv.setItems(library.getPatron(getID()).borrowingHistory());
        } 
        else {
            msgTxt.setText("Invalid input");
        }
    }
    
    @FXML private void handleClose (ActionEvent e) throws Exception {
        stage.close();
    }
}
