package logindemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class CsvWriter {
    public static void writeRecord(){      
       String fileName = "accounts.csv";
       String user  = JOptionPane.showInputDialog("Enter Username: ");
       String pass  = JOptionPane.showInputDialog("Enter Password: ");
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
