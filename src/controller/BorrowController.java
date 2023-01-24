package controller;

import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BorrowController extends Controller<Library> {
    public final Library getLibrary() { 
        return model; 
    }
    
    @FXML private TextField idText;
    @FXML private Button selectPatronBtn;
    @FXML private ListView<Book> booksLv;
    @FXML private Button borrowSelectBookBtn;
    
    private int getID() { 
        return Integer.parseInt(idText.getText()); 
    }
    
    @FXML private void initialize() {
        idText.textProperty().addListener( (observable, oldID, newID) -> selectPatronBtn.setDisable(newID.length() < 1));
        booksLv.getSelectionModel().selectedItemProperty().addListener((observer, oldBook, newBook) -> borrowSelectBookBtn.setDisable(newBook == null));
    }
    
    @FXML private void handleBorrow(ActionEvent event) {
        Library library = getLibrary();
        Book book = booksLv.getSelectionModel().getSelectedItem();
        Patron patron = library.getCatalogue().getPatron(getID());
        library.getCatalogue().loanBookToPatron(book, patron);
        book.removeHold(patron);
        booksLv.setItems(library.getCatalogue().getBorrowableBooks(patron)); //update the list
    }

    @FXML private void handleSelectPatron(ActionEvent event) {
        Library library = getLibrary();
        Patron patron = library.getPatron(getID()); 
        if (library.getPatron(getID()) != null) {
            booksLv.setItems(library.getCatalogue().getBorrowableBooks(patron));   
        } else {
            System.out.println("No patron found.");
        }
    }
    
    @FXML private void handleClose() {
        stage.close();
    } 
}
