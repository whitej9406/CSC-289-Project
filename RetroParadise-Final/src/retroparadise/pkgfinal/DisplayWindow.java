package retroparadise.pkgfinal;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayWindow {
    public static void displayError(String title, String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        
        Label label = new Label();
        label.setText(message);
        
        Button closeButton = new Button("Continue");
        closeButton.setOnAction(e -> window.close());
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
    }
    
    public static void displayWindow(String title, String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        window.setMinHeight(350);
        
        Label label1 = new Label();
        label1.setText(message);
        
        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(label1);
        layout1.setAlignment(Pos.CENTER);
        
        Scene scene1 = new Scene(layout1);
        window.setScene(scene1);
        window.showAndWait();
        
    }
    
}
