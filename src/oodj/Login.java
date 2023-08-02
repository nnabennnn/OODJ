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
 */

public class Login {
    
    Scanner s = new Scanner(System.in);
    String filename = "/Users/ben/Documents/OOPJAVA/OODJ/username.txt";
    
    public Login(){
        LoginProcess();
    }
    
    public void LoginProcess() {
        
        try{
            Path path = Paths.get(filename.toString());
            InputStream input = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            System.out.println("Login page");
            System.out.print("Username : ");
            String username = s.nextLine();
            System.out.print("Password : ");
            String password = s.nextLine();
            String _temp = null;
            String _user;
            String _pass;
            
            boolean found = false;
            while((_temp=reader.readLine()) != null){
                String[] account = _temp.split(",");
                _user = account[0];
                _pass = account[1];
                if(_user.equals(username)&&_pass.equals(password)){
                    found = true;
                }
            }
            
            if(found==true){
                System.out.println("Login Successfully!");
            }else{
                System.out.println("Invalid username or password or both");
                reader.close();
                
            }
             
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
    }

    
}
