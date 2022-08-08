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
import javafx.scene.control.CheckBox;
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
    static int i = 0;
    static int nbreO;
    static ObservableList <Integer> houv = FXCollections.observableArrayList();
    static ObservableList <Integer> Louv = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox choicebox;

    @FXML
    private TextField Hm, Lm, em, lc, Lc, ec, Pc, Pci, Pe, Ps, Pp, LSc, lSc, Nc;    

    @FXML
    private Button valider, btn1, btn2;

    @FXML
    private Label vm, vc, ve, vs, pc, pci, pe, ps, pp, np,nc, yes,yos;

    private CheckBox crepis, carre;

    @FXML
    public void devis(ActionEvent event) throws Exception{
        Mur mur = new Mur(Double.parseDouble(Lm.getText()), Double.parseDouble(Hm.getText()));
        Parpaing p = new Parpaing((int) choicebox.getSelectionModel().getSelectedItem());
        double Vm = mur.Vmortier(Double.parseDouble(em.getText()), p.getEp(), p.getHp(), p) + mur.VmortierCre(epaisseurcre(ec));
       
        vm.setText(String.valueOf((int)(Math.ceil(Vm))));
        vc.setText(String.valueOf((int)(Math.ceil(0.18*Vm))));
        vs.setText(String.valueOf((int)(Math.ceil(0.72*Vm))));
        ve.setText(String.valueOf((int)(Math.ceil(0.1*Vm))));
        np.setText(String.valueOf((int)(Math.ceil(mur.nbrePal(p)*mur.nbrePaL(p)))));
        pp.setText(String.valueOf((int)(Math.ceil(mur.prixParpaing(Integer.parseInt(Pp.getText()), Integer.parseInt(np.getText()))))));
        pci.setText(String.valueOf((int)mur.prixCiment(Integer.parseInt(Pci.getText()), (int)(Math.ceil(0.18*Vm)))));
        ps.setText(String.valueOf((int)mur.prixSable(Integer.parseInt(Ps.getText()),0.72*Vm)));
        pe.setText(String.valueOf((int)mur.prixEau(Integer.parseInt(Pe.getText()), (int)(Math.ceil(0.1*Vm)))));
        
        pc.setText(String.valueOf((int)mur.prixCarre(Integer.parseInt(Pc.getText()), Integer.parseInt(nc.getText()))));
       
        
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
                    Controller.alert(event, "Nombre d'ouvertures", "Entrez le nombre d'ouvertures du mur");
                    Controller.alertOuv(event, nbreO);  
                    stage.show();

                    i++;
                }else{
                    Controller.alert(event, "Nombre d'ouvertures", "Entrez le nombre d'ouvertures du mur");
                    Controller.alertOuv(event, nbreO); 
                    btn1.setDisable(true);
       
                    stage = (Stage) btn1.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("view/devisMur.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                }
                
            }
            else{
                stage = (Stage) btn2.getScene().getWindow();
                stage.close();
            }
        
        

    }

    // Pour gérer le crepissage en cas de besoin
    @FXML
    private void crepissage(ActionEvent event) throws Exception{
        ec.setVisible(true);        
    }

    // Pour gérer le carrelage en cas de besoin
    @FXML
    private void carrelage(ActionEvent event){
        AlertBox.display("Carrelage");
        lc.setVisible(true);
        Lc.setVisible(true);
        pc.setVisible(true);
        nc.setVisible(true);
        Pc.setVisible(true);
    }


    // Au cas où epaisseur crepissage null
    private double epaisseurcre(TextField ec){
        if(ec.getText().isEmpty()){
           return 0;
        }else return Double.parseDouble(ec.getText());
    }

    // Au cas où la largueur du carreau est null
    private double lcarre(TextField lc){
        if(ec.getText().isEmpty()){
           return 0;
        }else return Double.parseDouble(lc.getText());
    }

    // Au cas où la longueur du carreau est null
    private double Lcarre(TextField Lc){
        if(ec.getText().isEmpty()){
           return 0;
        }else return Double.parseDouble(Lc.getText());
    }

    void getdisplay(TextField txt1, TextField txt2, TextField txt3, TextField txt4, TextField txt5, TextField txt6){
        Lc = txt1;
        lc = txt2;
        LSc = txt3;
        lSc = txt4;
        Nc = txt5;
        Pc = txt6;

 
    }
    
    static void display(TextField txt1, TextField txt2){
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList <Integer> list = FXCollections.observableArrayList();
        list.addAll(10,15,20,25);
        // We populate the choicebox
        choicebox.setItems(list);

 // Cacher les elements de carrelage
        ec.setVisible(false);
        lc.setVisible(false);
        Lc.setVisible(false);
        pc.setVisible(false);
        Pc.setVisible(false);
        nc.setVisible(false);

        yes.setText(String.valueOf(nbreM));
        yos.setText(String.valueOf(i));
 
        if(nbreM == i){ btn1.setDisable(true);}  // Au cas où l'on entre un seul mur pour devis.
    }    
    
}
