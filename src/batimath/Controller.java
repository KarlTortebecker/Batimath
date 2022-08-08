/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package batimath;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Karl
 */
public class Controller implements Initializable {
    
    static int nbreOuv;  


    @FXML
    private Label lbl1, lbl2;

    @FXML
    private Button btn1, btn2;

   
    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if(event.getSource()==btn1){
             DevisMurController.i++;
             stage = (Stage) btn1.getScene().getWindow();
             root = FXMLLoader.load(getClass().getResource("view/ViewChoice.fxml"));
             
        }
        else{
            stage = (Stage) btn2.getScene().getWindow();
            this.alert(event,"Nombre de murs", "Veuillez entrer le nombre de murs");
            this.alert(event,"Nombre d'ouvertures", "Entrez le nombre d'ouvertures du mur");
            this.alertOuv(event, DevisMurController.nbreO);
            root = FXMLLoader.load(getClass().getResource("view/devisMur.fxml"));
            DevisMurController.i++;
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public static void alert(ActionEvent event, String title, String message) throws Exception {
        AlertBox.display(title, message);
        
    }
    @FXML
    public static void alertOuv(ActionEvent event, int nbreOuv) throws Exception {
        for(int i=1; i<= nbreOuv; i++){
            AlertBox.display(i);
        }
                
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
