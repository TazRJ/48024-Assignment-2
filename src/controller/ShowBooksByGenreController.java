package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.*;

public class ShowBooksByGenreController extends Controller<Library>{
    public final Library getLibrary() { 
        return model; 
    }
    
    @FXML private ChoiceBox<Genre> genresCb;
    @FXML private ListView<Book> displayLv;
    
    private Genre getSelectedGenre() {
        return genresCb.getSelectionModel().getSelectedItem();
    }

    @FXML private void handleDisplayCb(ActionEvent e) {
        Genre genre = getSelectedGenre();
        displayLv.setItems(getLibrary().getCatalogue().getBooksInGenre(genre)); 
    }

    @FXML private void Close() {
        stage.close();
    } 
}

