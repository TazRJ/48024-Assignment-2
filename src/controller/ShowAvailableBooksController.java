package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import model.*;

public class ShowAvailableBooksController extends Controller<Library> {
    public final Library getLibrary() { 
        return model; 
    }
    
    @FXML public void initialize() {

    }
    
    @FXML private void handleClose() {
        stage.close();
    } 

}
