package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowAllBooksController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML private TableView allBooks;
        
    @FXML private void Close() {
        stage.close();
    } 
    

}

