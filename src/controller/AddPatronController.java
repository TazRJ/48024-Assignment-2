package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class AddPatronController extends Controller<Library> {
    
    public final Library getLibrary() { 
        return model; 
    }
    
    @FXML private TextField patronIDText;
    @FXML private TextField patronNameText;
    @FXML private Button addPatronBtn;
    @FXML private Text feedbackText;
    
    private int getPatronID() { 
        return Integer.parseInt(patronIDText.getText()); 
    }
    // private void setID(int id) { patronIDText.setText("" + id); }
    
    private String getPatronName() { 
        return patronNameText.getText(); 
    }
    // private void setName(String name) { patronNameText.setText(name); }
    
    @FXML private void initialize() {
    
    }
    
    @FXML private void handleAddPatron(ActionEvent event) throws Exception {
        Library library = getLibrary();
        try {
            if(library.getPatron(getPatronID()) == null && !patronIDText.getText().trim().isEmpty() && !patronNameText.getText().trim().isEmpty()) {
                library.addPatron(getPatronID(), getPatronName());
                feedbackText.setText("Patron added.");
            } 
            else if (library.getPatron(getPatronID()) != null && !patronNameText.getText().trim().isEmpty()) {
                feedbackText.setText("Patron already exists!");
            } 
            else {
                feedbackText.setText("Invalid input.");
            }
        } 
        catch (Exception e) {
            feedbackText.setText("Invalid input.");
        } 
    }
    
    @FXML private void handleClose(ActionEvent e) throws Exception {
        stage.close();
    }
}
