/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package oodj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author BEN
//filepath
// "/Users/ben/Documents/OOPJAVA/OODJ/username.txt"
//"/Users/htankhaishan/Documents/2nd Year 1st Sem/Java/OODJ/username.txt"
*/

public class Login {
    
    Scanner s = new Scanner(System.in);
    String filename = "/Users/htankhaishan/Documents/2nd Year 1st Sem/Java/OODJ/username.txt";
    String user;
    
    
    public Login() {
        LoginProcess();
    }

    public void LoginProcess() {
        
        
        System.out.println("Login page");
        System.out.print("Username : ");
        String username = s.nextLine();
        System.out.print("Password : ");
        String password = s.nextLine();

        try{
            Path path = Paths.get(filename);
            InputStream input = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String _temp;
            String _user;
            String _pass;
            String _role = "";

            boolean found = false;
            while((_temp=reader.readLine()) != null){
                String[] account = _temp.split(",");
                _user = account[0];
                _pass = account[1];
                _role = account[2];
                if(_user.equals(username) && _pass.equals(password)){
                    found = true;
                    
                    break;
                }
            }
            

            if(found){
                System.out.println("Login Successfully!\n ");           
                this.user = _role;
                
                
                
            } else {
                System.out.println("Invalid username or password or both\n");
                LoginProcess();
                
            }
            reader.close();
            
        } catch(Exception ex){
            System.out.print("Invalid username or password or both2\n");
            new Login();
        }
    

       
    }
    
 
}
