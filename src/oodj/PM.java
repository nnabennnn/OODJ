/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj;
import java.util.Scanner;

/**
 *
 * @author BEN
 */
public class PM {
    
    Scanner sc = new Scanner(System.in);
    
    
    public PM() {
        System.out.println("Welcome back Purchase Manager!");
        System.out.print("What do you want to do : ");
        System.out.println(" 1. View Item ");
            System.out.print(" please enter the number only :  ");
            String choice = sc.nextLine();
            if(choice.equals("1")){
                ViewItem();
            }
        
    }
    
    private void ViewItem() {
        Items item = new Items();
        item.ViewItem();;
    
    }
    
    
    
    
    
    
}
