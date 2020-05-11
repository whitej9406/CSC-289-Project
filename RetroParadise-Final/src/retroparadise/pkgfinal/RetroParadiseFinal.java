package retroparadise.pkgfinal;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RetroParadiseFinal extends Application {
    
    Stage window;
    Scene start, login, register, hub, browse, orders, favorites, cart, settings, service, account;
    
    int accountLogged = 0; //Boolean that determines whether an account is being used
    int cartNum = 0; //Items in the cart
       
    String tempName="";
    String tempPass="";
    String tempEmail="";
    
    ArrayList<String> users = new ArrayList<String>();
    ArrayList<String> passes = new ArrayList<String>();
    ArrayList<String> emails = new ArrayList<String>();
    
    //TextFields that need to be initialized first
    TextField nameInput = new TextField(); 
    PasswordField passInput = new PasswordField(); 
    TextField searchBar = new TextField();
    TextField nameRegister = new TextField();
    PasswordField passRegister = new PasswordField();
    TextField emailRegister = new TextField();
    
    /////////////////////////////////////////////////////////////////////////
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
       window = primaryStage;
       window.setTitle("Retro Paradise");  

        //Create a starting account to login to  
        users.add("admin");
        passes.add("password");
        emails.add("admin@retroparadise.com");
       
       // Buttons
       
       //Login Button
       Button signinButton = new Button("Login");
       signinButton.setOnAction(e -> window.setScene(login));
       
       //Register Button
       Button registerButton = new Button("Register");
       registerButton.setOnAction(e -> window.setScene(register));
       
       //Skip Sign In Button
       Button skipButton = new Button ("Skip Sign In");
       skipButton.setOnAction(e -> window.setScene(hub));
       
       //Login Confirm Button
       Button loginButton = new Button("Confirm");
       loginButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
               String userN = nameInput.getText().trim();
               String userP = passInput.getText().trim();
               
               if(users.contains(userN)){
                      int indexU = users.indexOf(userN);
                      String indexCheck = passes.get(indexU);
                      indexCheck = indexCheck.trim();
                     
                if(userP.trim().equals(indexCheck)){
                      DisplayWindow.displayError("Login Successful","Hello, "+ nameInput.getText().trim()+".");
                      accountLogged = 1;
                      window.setScene(hub);
                }
                else if(passInput.getText().trim().isEmpty()){
                        DisplayWindow.displayError("Error","Password can't be blank!!");
                }else{
                    DisplayWindow.displayError("Error","Password is incorrect!");
                    passInput.clear();
                }
                
        }else if(nameInput.getText().trim().isEmpty()){
            DisplayWindow.displayError("Error","Username can't be blank!!");      
        }else{
            DisplayWindow.displayError("Error","User not found!");
            nameInput.clear();passInput.clear();
          } 
        }
       });
       
       // Back Buttons /////////////////////////////////////////////////////////
       
       Button backButton = new Button("Back");
       backButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
               nameInput.clear();passInput.clear();
               window.setScene(start);
           }       
       });
       
       
       Button back2Button = new Button("Back");
       back2Button.setOnAction(e -> window.setScene(start));
       
       Button back3Button = new Button("Back");
       
       back3Button.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
               searchBar.clear();
               window.setScene(hub);
            }
       });
       
       Button back4Button = new Button("Back");
       back4Button.setOnAction(e -> window.setScene(hub));
       
       Button back5Button = new Button("Back");
       back5Button.setOnAction(e -> window.setScene(hub));
       
       Button back6Button = new Button("Back");
       back6Button.setOnAction(e -> window.setScene(hub));
       
       Button back7Button = new Button("Back");
       back7Button.setOnAction(e -> window.setScene(hub));
       
       Button back8Button = new Button("Back");
       back8Button.setOnAction(e -> window.setScene(hub));
       
       Button back9Button = new Button("Back");
       back9Button.setOnAction(e -> window.setScene(hub));
       
       
       /////////////////////////////////////////////////////////////////////////
       
       //Register Send Button
       Button confButton = new Button ("Confirm Registration");
       confButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
               nameInput.clear();passInput.clear();
               if(nameRegister.getText().trim().isEmpty()){
                    DisplayWindow.displayError("Error","Username can't be blank!!");
                    window.setScene(start);
                    
               }else if(passRegister.getText().trim().isEmpty()){
                    DisplayWindow.displayError("Error","Password can't be blank!!");
                    window.setScene(start);
               }
               else if(emailRegister.getText().trim().isEmpty()){
                    DisplayWindow.displayError("Error","Email can't be blank!!"); 
                    window.setScene(start);
               }
               else{
                   tempName= nameRegister.getText().trim();
                   tempPass= passRegister.getText().trim();
                   tempEmail= emailRegister.getText().trim(); 
                   
                   users.add(tempName);
                   passes.add(tempPass);
                   emails.add(tempEmail);
                   DisplayWindow.displayError("Registration Successful","Username: " + 
                           nameRegister.getText().trim()+"\nPassword: "+passRegister.getText().trim()+
                           "\nEmail: "+emailRegister.getText().trim());
                   nameRegister.clear();passRegister.clear();emailRegister.clear();
                   window.setScene(start);
               }
           }       
       });
       
       //Browse Button
       Button browseButton = new Button ("Browse");
       browseButton.setOnAction(e -> window.setScene(browse));
       
       //Search Button
       Button searchButton = new Button ("X");
       searchButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
               String searchTerm = searchBar.getText().trim();
               if (searchBar.getText().trim().isEmpty()){
                    DisplayWindow.displayError("Error","Search results can't be blank!");
               }else{
                   DisplayWindow.displayWindow("Search","No results found for "+searchTerm+".");
               }
            }
       });
                              
       //My Orders Button
       Button ordersButton = new Button ("My Orders");
       ordersButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
                if (accountLogged == 0){
                    DisplayWindow.displayError("Error","You need to login!");
                    nameInput.clear();passInput.clear();
                    window.setScene(login);
                }else{
                    window.setScene(orders);
                }
            }
       });
    
       //Recommendations Button
       Button recommendButton = new Button ("Recommendations");
       recommendButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
                if (accountLogged == 0){
                    DisplayWindow.displayError("Error","You need to login!");
                    nameInput.clear();passInput.clear();
                    window.setScene(login);
                }else{
                    window.setScene(favorites);
                }
            }
       });
       
       //Cart Button
       Button cartButton = new Button ("Cart");
       cartButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
               if (cartNum == 0){
                DisplayWindow.displayWindow("Cart","There is nothing in the cart right now!"); 
               }else{
                DisplayWindow.displayWindow("Cart","You have "+cartNum+" thing(s) in the cart.");
               }
            }
       });
       
       
       //Settings Button
       Button settingsButton = new Button("Settings");
       settingsButton.setOnAction(e -> window.setScene(settings));
       
       //Customer Service Button
       Button serviceButton = new Button("Customer Service");
       serviceButton.setOnAction(e -> window.setScene(service));
       
       //Account Button
       Button accountButton = new Button("Account");
       accountButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
                if (accountLogged == 0){
                    DisplayWindow.displayError("Error","You need to login!");
                    nameInput.clear();passInput.clear();
                    window.setScene(login);
                }else{
                    window.setScene(account);
                }
            }
       });
       
       //Log Out Button
       Button logButton = new Button("Log Out");
       logButton.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
               if(accountLogged == 0){
                   DisplayWindow.displayError("Error","You need to login!");
                   nameInput.clear();passInput.clear();
                   window.setScene(login);
                   
               }else{
                   DisplayWindow.displayError("Logout Successful","Goodbye, "
                           + nameInput.getText().trim()+".");
                   accountLogged = 0;
                   nameInput.clear();passInput.clear();
                   window.setScene(start);  
               } 
            }
       });
       
       
       
       /////////////////////////////////////////////////////////////////////  
       // Grid Panes
        
       GridPane grid = new GridPane(); 
       grid.setPadding(new Insets(10, 10, 10, 10));
       grid.setAlignment(Pos.CENTER);
       grid.setVgap(8);
       grid.setHgap(10);
       
       GridPane grid2 = new GridPane(); 
       grid2.setPadding(new Insets(10, 10, 10, 10));
       grid2.setAlignment(Pos.CENTER);
       grid2.setVgap(8);
       grid2.setHgap(10);
       
       GridPane grid3 = new GridPane(); 
       grid3.setPadding(new Insets(20, 20, 10, 10));
       grid3.setAlignment(Pos.CENTER);
       grid3.setVgap(8);
       grid3.setHgap(10);
       
       GridPane grid4 = new GridPane(); 
       grid4.setPadding(new Insets(10, 20, 10, 10));;
       grid4.setVgap(8);
       grid4.setHgap(10);
       
       GridPane grid5 = new GridPane(); 
       grid5.setPadding(new Insets(10, 10, 10, 10));
       grid5.setVgap(8);
       grid5.setHgap(10);
       
       GridPane grid6 = new GridPane(); 
       grid6.setPadding(new Insets(10, 10, 10, 10));
       grid6.setVgap(8);
       grid6.setHgap(10);
       
       GridPane grid7 = new GridPane(); 
       grid7.setPadding(new Insets(10, 10, 10, 10));
       grid7.setVgap(8);
       grid7.setHgap(10);
       
       GridPane grid8 = new GridPane(); 
       grid8.setPadding(new Insets(10, 10, 10, 10));
       grid8.setVgap(8);
       grid8.setHgap(10);
       
       GridPane grid9 = new GridPane(); 
       grid9.setPadding(new Insets(10, 10, 10, 10));
       grid9.setVgap(8);
       grid9.setHgap(10);
       
       GridPane grid10 = new GridPane(); 
       grid10.setPadding(new Insets(10, 10, 10, 10));
       grid10.setVgap(8);
       grid10.setHgap(10);
       
       GridPane grid11 = new GridPane(); 
       grid11.setPadding(new Insets(10, 10, 10, 10));
       grid11.setVgap(8);
       grid11.setHgap(10);
       
       
      ///////////////////////////////////////////////////////////////////// 
      //Screens
       
       // Start up Screen
       GridPane.setConstraints(signinButton, 1, 0);
       GridPane.setConstraints(registerButton, 1, 1);
       GridPane.setConstraints(skipButton, 1, 2);
       
       grid.getChildren().addAll(signinButton,registerButton,skipButton);
       start = new Scene(grid,350,350);
       
       
       // Login Screen
       nameInput.setPromptText("Username");
       GridPane.setConstraints(nameInput, 1, 0);
       passInput.setPromptText("Password");
       GridPane.setConstraints(passInput, 1, 1);

       GridPane.setConstraints(loginButton, 1, 2);
       GridPane.setConstraints(backButton, 1, 3);
       grid2.getChildren().addAll(nameInput, passInput, loginButton, backButton);
       login = new Scene(grid2, 350, 350);
          
       // Registration 
       nameRegister.setPromptText("Username");
       GridPane.setConstraints(nameRegister, 1, 0);
       
       emailRegister.setPromptText("Email");
       GridPane.setConstraints(emailRegister, 1, 1);
       
       passRegister.setPromptText("Create a password");
       GridPane.setConstraints(passRegister, 1, 2);
         
       GridPane.setConstraints(confButton, 1, 3);
       GridPane.setConstraints(back2Button, 1, 4);
       grid3.getChildren().addAll(nameRegister, emailRegister, passRegister, confButton, back2Button);
       register = new Scene(grid3,350,350);
         
       // Hub
       GridPane.setConstraints(browseButton, 1, 0);
       GridPane.setConstraints(ordersButton, 1, 1);
       GridPane.setConstraints(recommendButton, 1, 2);
       GridPane.setConstraints(cartButton, 1, 3);
       GridPane.setConstraints(settingsButton, 1, 4);
       GridPane.setConstraints(serviceButton, 1, 5);
       GridPane.setConstraints(accountButton, 1, 6);
       GridPane.setConstraints(logButton, 1, 7);
       grid4.getChildren().addAll(browseButton, ordersButton, recommendButton, cartButton, settingsButton, serviceButton, accountButton, logButton);
       hub = new Scene(grid4,350,350);
      
       // Browse Page
       searchBar.setPromptText("What are you looking for?");
       GridPane.setConstraints(searchBar, 1, 1);
       
       GridPane.setConstraints(searchButton, 2, 1);
       GridPane.setConstraints(back3Button, 1, 34);
       grid5.getChildren().addAll(searchBar,searchButton,back3Button);
       browse= new Scene(grid5,350,350);      
       
       // Orders
       GridPane.setConstraints(back4Button, 1, 37);
       grid6.getChildren().addAll(back4Button);
       orders= new Scene(grid6,350,350);
            
       // Favorites
       GridPane.setConstraints(back5Button, 1, 37);
       grid7.getChildren().addAll(back5Button);
       favorites= new Scene(grid7,350,350);
       
       // Cart
       GridPane.setConstraints(back6Button, 1, 37);
       grid8.getChildren().addAll(back6Button);
       cart= new Scene(grid8,350,350);
      
       // Settings
       GridPane.setConstraints(back7Button, 1, 37);
       grid9.getChildren().addAll(back7Button);
       settings= new Scene(grid9,350,350);
       
       // Customer Service
       GridPane.setConstraints(back8Button, 1, 37);
       grid10.getChildren().addAll(back8Button);
       service= new Scene(grid10,350,350);
       
       // Account
       GridPane.setConstraints(back9Button, 1, 37);
       grid11.getChildren().addAll(back9Button);
       account = new Scene(grid11,350,350);
      
      
      
       //// Start the program
       window.setScene(start);
       window.show();
       
    }
}
