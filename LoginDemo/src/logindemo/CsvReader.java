package logindemo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CsvReader {
    public static ArrayList<String> userList(){      
       String fileName = "accounts.csv";
       String userName = "";
       String skipText = "";
       ArrayList<String> userList= new ArrayList<String>();
      try
        {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useDelimiter("[,\n]");
            
            while(scanner.hasNext()){
                userName = scanner.next();
                userList.add(userName);
                skipText = scanner.next();
                
            }
        }      
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error!");
        }
   
        return(userList);
    }
    
    public static ArrayList<String> passList(){
       String fileName = "accounts.csv";
       String userPass = "";
       String skipText = "";
       ArrayList<String> passList = new ArrayList<String>();
      try
        {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useDelimiter("[,\n]");
            
            while(scanner.hasNext()){
                skipText = scanner.next();
                userPass = scanner.next();
                passList.add(userPass);
            }
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error!");
        }
        return(passList);
    }
    
}
