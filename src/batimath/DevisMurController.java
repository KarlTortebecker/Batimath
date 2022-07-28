/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package batimath;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Karl
 */
public class DevisMurController implements Initializable {
    
    static int nbreM;
    static int i = 1;

    @FXML
    private ChoiceBox choicebox;

    @FXML
    private TextField Hm,Lm,eb;    

    @FXML
    private Button valider, btn1, btn2;

    @FXML
    private Label vb, vc, ve, vs, vg, np, yes,yos;

    @FXML
    public void devis(ActionEvent event) throws Exception{
        Mur mur = new Mur(Double.parseDouble(Lm.getText()), Double.parseDouble(Hm.getText()));
        Parpaing p = new Parpaing((int) choicebox.getSelectionModel().getSelectedItem());
        double Vb = mur.Vbeton(Double.parseDouble(eb.getText()), p.getEp(), p.getHp(), p);
       
        vb.setText(String.valueOf(Vb));
        vc.setText(String.valueOf(0.15*Vb));
        vg.setText(String.valueOf(0.42*Vb));
        vs.setText(String.valueOf(0.36*Vb));
        ve.setText(String.valueOf(0.07*Vb));
        np.setText(String.valueOf((int)mur.nbrePal(p)*mur.nbrePaL(p)));
        
    }   


    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
        
            if(event.getSource()==btn1){
                if(nbreM > i){
                    stage = (Stage) btn1.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("view/devisMur.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    i++;
                }else{
                    btn1.setDisable(true);
                }
                
            }
            else{
                stage = (Stage) btn2.getScene().getWindow();
                stage.close();
            }
        
        

    }

   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList <Integer> list = FXCollections.observableArrayList();
        list.addAll(10,15,20,25);
        // We populate the choicebox
        choicebox.setItems(list);

        
        yes.setText(String.valueOf(nbreM));
        yos.setText(String.valueOf(i));
    }    
    
}
