/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj;

/**
 * @author BEN
 */

import java.util.Scanner;

public class Login {
    Scanner sc;
    String username;
    String pass;
    
    
    public Login(Scanner sc){
        this.sc=sc;
    }
    
    public void insertData(){
        System.out.print("Username : ");
        username = sc.nextLine();
        
        System.out.print("Password :  ");
        pass = sc.nextLine();
        checking();   
    }
    
    public void checking(){
        if(username.equals("admin")){
            if(pass.equals("admin")){
                System.out.println("Successfully!");
                System.out.println("Welcome Back Admin");
            
            }else{
                System.out.println("Wrong password, Please try again.");
            }
        }else{
            System.out.println("Wrong Username, Please try again.");
        }
    
    }
   
    
    
}
