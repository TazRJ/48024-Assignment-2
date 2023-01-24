package controller;

import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;

//done

public class CatalogueController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    @FXML
    public void initialize() {

    }
    
    @FXML public void Exit (ActionEvent e) throws Exception {
        stage.close();
    }
    
    @FXML public void PlaceHold (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/placeHold.fxml", "Place a Hold", new Stage());
    }
    @FXML public void Returns (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/return.fxml", "Return a Book", new Stage());
    }  
    
    @FXML public void Borrow (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/borrow.fxml", "Borrow a Book", new Stage());
    }
        
    @FXML public void ByGenre (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showBooksByGenre.fxml", "Browse by Genre", new Stage());
    }
    
    @FXML public void AvailBooks (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showAvailableBooks.fxml", "Available Books", new Stage());
    }
    
    @FXML public void ShowAllBooks (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
    }
}
