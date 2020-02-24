package testproject;

import javax.swing.JOptionPane;


public class TestFile1 {
    public static void main(String[] args) {
        
        
        //Create User
        String user1N  = JOptionPane.showInputDialog("Create Username: ");
        String user1P = JOptionPane.showInputDialog("Set Password:");
        
        JOptionPane.showMessageDialog(null, "Account created!");
          
        //Sign in
        String userN  = JOptionPane.showInputDialog("User Name:");
        String userP = JOptionPane.showInputDialog("Password:");
        
       
        //Test strings
        if(userN.equals(user1N)){
            if (userP.equals(user1P)){
                JOptionPane.showMessageDialog(null, "Hello, " + userN + 
                ". You are logged in!");
            }
            else{
            JOptionPane.showMessageDialog(null, "Password is incorrect!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "User not found!");
        }
           
       System.exit(0); //End program
    }
    
}