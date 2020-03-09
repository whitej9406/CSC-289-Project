package logindemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class CsvWriter {
    public static void writeRecord(){ 
       boolean checkingPass = true;
       String fileName = "accounts.csv";
       
       String first  = JOptionPane.showInputDialog("Enter First Name: ");
       String last  = JOptionPane.showInputDialog("Enter Last Name: ");
       
       // TO DO 
       // Needs to check the list of usernames and make sure it is not already
       // inside of the list
       
       String user  = JOptionPane.showInputDialog("Enter Username: ");
       
       
       String pass = "";
       while (checkingPass == true){
           pass  = JOptionPane.showInputDialog("Enter Password: ");
       
           String passCheck  = JOptionPane.showInputDialog("Enter Password again: ");
           
           if (pass.equals(passCheck)){
               checkingPass = false;
               
           }else{
              JOptionPane.showMessageDialog(null,"Passwords don't match!"); 
           }
       }
       

      try
        {
            FileWriter writer = new FileWriter(fileName,true);
            BufferedWriter buffer = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer);
            
            print.println(user+","+pass);
            print.flush();
            print.close();
            
            JOptionPane.showMessageDialog(null,"Registration Complete!");
        }      
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error!");
        }
   
    }

}
