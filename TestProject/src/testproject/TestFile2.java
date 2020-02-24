package testproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestFile2 {
    public static void main(String[] args) {
        System.out.println("Trying to connect to Database...");
        try {
            //Try to get a connection to the specified mariadb path 
            try (Connection connect = DriverManager.getConnection("jdbc:mariadb://localhost/csc-289/userinfo?user=root&password=password")){
                System.out.println("Access Granted"); 
            }
        }catch (Exception SQLException){
            //Show an error it the connection to the database can not be accessed
            System.out.println("Connection Error!");
        }
        
        System.exit(0); //End program
    }
}