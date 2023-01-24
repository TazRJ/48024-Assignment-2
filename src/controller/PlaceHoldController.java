package controller;

import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class PlaceHoldController extends Controller<Library> {
    public final Library getLibrary() { 
        return model; 
    }
    
    @FXML private TextField idText;
    @FXML private Button selectPatronBtn;
    @FXML private ListView<Book> booksLv;
    @FXML private Button holdSelectBookBtn;
    @FXML private Text msgText;
    
    private int getID() { return Integer.parseInt(idText.getText()); }
    
    @FXML private void initialize() {
        booksLv.setItems(getLibrary().getCatalogue().getAllBooks());
        idText.textProperty().addListener( (observable, oldID, newID) -> 
                selectPatronBtn.setDisable(newID.length() < 1));
        
        booksLv.getSelectionModel().selectedItemProperty().addListener(
            (observer, oldBook, newBook) -> 
                holdSelectBookBtn.setDisable(newBook == null));
    }
    
    @FXML private void handleSelect(ActionEvent evenet) {
        Library library = getLibrary();
        if (library.getPatron(getID()) != null) {
            msgText.setText("");
        } else {
            msgText.setText("No Patron selected");
        }
        
    }
    
    @FXML private void handleHold(ActionEvent event) {
        Library library = getLibrary();
        Book book = booksLv.getSelectionModel().getSelectedItem();
        Patron patron = library.getCatalogue().getPatron(getID());
        if (book.isHeldBy(patron)) {
            msgText.setText(patron.getName() + " has already place a hold on " + book.getTitle());
        } else if (!book.isHeldBy(patron)) {
            book.addHold(patron);
            msgText.setText("Hold placed on " + book.getTitle() +
                    " for " + patron.getName() );
        } else {
            msgText.setText("No Patron selected");
        }
    }
    
    @FXML private void handleClose() {
        stage.close();
    } 

}