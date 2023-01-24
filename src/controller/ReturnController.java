package controller;

import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReturnController extends Controller<Library> {
    public final Library getLibrary() { 
        return model; 
    }
    
    @FXML private TextField idText;
    @FXML private Button selectPatronBtn;
    @FXML private ListView<Book> booksLv;
    @FXML private Button returnSelectBookBtn;
    
    private int getID() { 
        return Integer.parseInt(idText.getText()); 
    }
    
    @FXML private void initialize() {
        idText.textProperty().addListener( (observable, oldID, newID) -> selectPatronBtn.setDisable(newID.length() < 1));
        booksLv.getSelectionModel().selectedItemProperty().addListener((observer, oldBook, newBook) -> returnSelectBookBtn.setDisable(newBook == null));
    }

    @FXML private void handleReturn (ActionEvent event) {
        Library library = getLibrary();
        Book book = booksLv.getSelectionModel().getSelectedItem();
        Patron patron = library.getCatalogue().getPatron(getID());;
        library.getCatalogue().returnBookFromPatron(book, patron);
    }
    
    @FXML private void handleSelectPatron (ActionEvent event) {
        Library library = getLibrary();
        if (library.getPatron(getID()) != null) {
            booksLv.setItems(library.getPatron(getID()).currentlyBorrowed());
        } else {
            System.out.println("No patron found.");
        }
    }
    
    @FXML private void handleClose() {
        stage.close();
    } 

}
