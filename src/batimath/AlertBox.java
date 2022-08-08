
package batimath;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Karl
 */
public class AlertBox {
    
    public static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(600);
        window.setHeight(250);
        

        Label label = new Label();      label.setLayoutX(49.0);     label.setLayoutY(71.0);
         if(title == "Nombre de murs"){
            label.setText(message);
         }else 
            label.setText(message+" "+ DevisMurController.i);
         
        TextField txt = new TextField();    txt.setLayoutX(356.0);     txt.setLayoutY(71.0);
   

        Button closeButton = new Button("Valider");     closeButton.setLayoutX(240.0); closeButton.setLayoutY(150);
        closeButton.setOnAction(e -> {
            if(title == "Nombre de murs"){
                DevisMurController.nbreM = Integer.parseInt(txt.getText());
            }else 
                DevisMurController.nbreO = Integer.parseInt(txt.getText());
            window.close();}
        );

        AnchorPane layout = new AnchorPane();
        layout.getChildren().addAll(label, txt,closeButton);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    };



     public static void display(int ouv){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Les Ouvertures");
        window.setMinWidth(650);
        window.setHeight(375);
        
       Label lb1, lb2;   lb1 = new Label();   lb2 = new Label();
        lb1.setText("Entrez la longueur de l'ouverture "+ouv+" en cm");   lb1.setLayoutX(69.0);     lb1.setLayoutY(71.0);
        lb2.setText("Entrez la largeur de l'ouverture "+ouv+" en cm");     lb2.setLayoutX(69.0);     lb2.setLayoutY(134.0);
         
        TextField txt1, txt2; txt1 = new TextField();   txt2 = new TextField();
        txt1.setLayoutX(376.0);     txt1.setLayoutY(71.0);
        txt2.setLayoutX(376.0);     txt2.setLayoutY(134.0);

        Button closeButton = new Button("Valider");     closeButton.setLayoutX(280.0);      closeButton.setLayoutY(225.0);

        closeButton.setOnAction(e -> {
            DevisMurController.Louv.add(Integer.valueOf(txt1.getText()));
            DevisMurController.houv.add(Integer.valueOf(txt1.getText()));
            window.close();}
        );
        
        AnchorPane layout = new AnchorPane();
        layout.getChildren().addAll(lb1, txt1, lb2, txt2, closeButton);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    
    };
 


    public static void display(String title){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(700);
        window.setHeight(600);
        
        Label lb1, lb2, lb3, lb4, lb5, lb6;   lb1 = new Label();   lb2 = new Label();     lb3 = new Label();   lb4 = new Label();    lb5 = new Label();     lb6 = new Label();
        lb1.setText("Entrez la longueur du carreau en cm : ");     lb1.setLayoutX(69.0);     lb1.setLayoutY(71.0);
        lb2.setText("Entrez la largueur du carreau en cm : ");     lb2.setLayoutX(69.0);     lb2.setLayoutY(134.0);
        lb3.setText("Entrez la longueur de la surface à carreler : ");      lb3.setLayoutX(69.0);     lb3.setLayoutY(202.0);
        lb4.setText("Entrez la largueur de la surface à carreler : ");    lb4.setLayoutX(73.0);     lb4.setLayoutY(271.0);
        lb5.setText("Entrez le nombre de carreaux par carton : ");    lb5.setLayoutX(75.0);     lb5.setLayoutY(341.0);
        lb6.setText("Entrez le prix du carton en FCFA : ");    lb6.setLayoutX(75.0);     lb6.setLayoutY(413.0);
         
        TextField txt1, txt2, txt3, txt4, txt5, txt6; txt1 = new TextField();   txt2 = new TextField(); txt3 = new TextField(); txt4 = new TextField(); txt5 = new TextField(); txt6 = new TextField();
        
        txt1.setLayoutX(376.0);     txt1.setLayoutY(66.0);
        txt2.setLayoutX(376.0);     txt2.setLayoutY(197.0);
        txt3.setLayoutX(376.0);     txt3.setLayoutY(129.0);
        txt4.setLayoutX(376.0);     txt4.setLayoutY(266.0);
        txt5.setLayoutX(378.0);     txt5.setLayoutY(336.0);
        txt6.setLayoutX(378.0);     txt6.setLayoutY(408.0);
        Button closeButton = new Button("Valider");     closeButton.setLayoutX(308.0);      closeButton.setLayoutY(487.0);
        closeButton.setOnAction(e -> {
            DevisMurController DMC = new DevisMurController();
            DMC.getdisplay(txt1, txt2, txt3, txt4, txt5, txt6);
            window.close();}
        );
        
        AnchorPane layout = new AnchorPane(); layout.setPrefHeight(562);    layout.setPrefWidth(681);
        layout.getChildren().addAll(lb1, txt1, lb2, txt2, lb3, txt3, lb4, txt4, lb5, txt5, lb6, txt6, closeButton);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
