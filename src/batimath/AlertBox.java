
package batimath;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        window.setMinWidth(400);
        window.setHeight(300);
        
        Label label = new Label();
        label.setText(message);
         
        TextField txt = new TextField();
   
        Button closeButton = new Button("Valider");
        closeButton.setOnAction(e -> {
        DevisMurController.nbreM = Integer.parseInt(txt.getText());window.close();});

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, txt,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    };
}
