/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 *
 * @author Jacob
 */
public class JavaFXApplication3 extends Application {
    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, sc;
    
        public static void main(String[] args) {
        launch(args);
    }
        
            @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Button 1
        Label label1 = new Label("Welcome to Retro Paradise");
        Button button1 = new Button("Browse");
        Button button3 = new Button("Shopping Cart");
        Button button4 = new Button("Account");
        Button button5 = new Button("Logout");
        button1.setOnAction(e -> window.setScene(scene2));
        button3.setOnAction(e -> window.setScene(scene3));
        button4.setOnAction(e -> window.setScene(scene4));
        button5.setOnAction(e -> window.setScene(scene5));
        

        //Layout 1 - children laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button3, button4, button5);
        scene1 = new Scene(layout1, 400, 400);


        
        //Button 2
        Button button2 = new Button("Return to menu");
        button2.setOnAction(e -> window.setScene(scene1));
        
        TextField b = new TextField();
        StackPane r = new StackPane();
        r.getChildren().add(b);
        sc = new Scene(r, 400, 400);
        

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);

        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Retro Paradise");
        window.show();
    }

}
