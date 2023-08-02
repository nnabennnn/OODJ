/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oodj;


/**
 *
 * @author ben
 */
public class OODJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       Login login = new Login();
       String username = login.user;
       
       if ("admin".equals(username)){
           System.out.println("Welcome!");
           Admin admin = new Admin();
       }
       
       if ("sales".equals(username)){
           System.out.println("Welcome!");
           Sales sales = new Sales(); 
        
           
       }else{
           System.out.println("bye");
       }
             
       
    }


}
