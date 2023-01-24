package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import model.*;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LibraryController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML public Button ViewCatBtn;
    @FXML public Button patronRecordBtn;
    @FXML public Button patronRegBtn;
    
    @FXML
    public void initialize() {

    }
    
    @FXML public void handleExit() { 
        System.exit(0); 
    }

    @FXML public void RegisterPatron (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/addPatron.fxml", "Add Patron", new Stage());
    }
    
    @FXML public void ViewPatronBtn (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/record.fxml", "Patron Record", new Stage());
    }

    @FXML public void ViewCatalogue(ActionEvent e) throws Exception {
	ViewLoader.showStage(getLibrary(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }

}
