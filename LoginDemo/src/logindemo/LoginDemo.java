package logindemo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LoginDemo {
    public static void main(String[] args){
        boolean end = false;
        
        while (end != true)
        {
            String input = JOptionPane.showInputDialog(null, "Welcome to Retro Paradise!"
                +"\n1.Login."
                +"\n2.Register."
                +"\n3.Exit.");
        
        switch(input){
                case "1":
                    ArrayList<String>userList = CsvReader.userList();
                    ArrayList<String>passList = CsvReader.passList();
                    loginDemo(userList,passList);
                    break;
                case "2":
                    CsvWriter.writeRecord();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Good bye!");
                    end = true;
                    break;
                default:
                    //default
                    JOptionPane.showMessageDialog(null, "Invalid response");
                }  
            } 
    }   
    
    
    public static void loginDemo(ArrayList userList, ArrayList passList){

        ArrayList<String>users = new ArrayList<String>();
        users.addAll(userList);       
        ArrayList<String>passes = new ArrayList<String>();
        passes.addAll(passList); 

        String userN  = JOptionPane.showInputDialog("Enter Username: ");
        String userP  = JOptionPane.showInputDialog("Enter Password: ");
        
        if(users.contains(userN)){
            int indexU = users.indexOf(userN);

            
            String indexCheck = passes.get(indexU);
            indexCheck = indexCheck.trim();
                     
            if(userP.trim().equals(indexCheck)){
               JOptionPane.showMessageDialog(null, "You are logged in! Hello, "+userN+".");
               storeConnection();
               //System.exit(0); //End program
               
            }else{
                JOptionPane.showMessageDialog(null, "Password does not match username!"); 
            }

        }else{
            JOptionPane.showMessageDialog(null, "User not found!");
        } 
    }
    
    public static void storeConnection(){
        boolean end = false;
        
        while (end != true)
        {
            String input = JOptionPane.showInputDialog(null, "Signed in:"
                +"\n1.Search Store."
                +"\n2.Cart."
                +"\n3.Log out.");
            
            switch(input){
                case "1":
                    JOptionPane.showMessageDialog(null, "Entering store");
                    System.exit(0); //End program
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "The cart is empty...");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Logging out");
                    end = true;
                    break;
                default:
                    //default
                    JOptionPane.showMessageDialog(null, "Invalid response");
                }  
            } 
        }
    }
