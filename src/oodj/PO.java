/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import java.util.Scanner;

/**
 *
 * @author BEN
 */
public class PO {
    Scanner s = new Scanner(System.in);
    String filename = "/Users/ben/Documents/OOPJAVA/OODJ/order.txt";
    
    
    public PO(){
        
    }
    /**
    public void addOrder() throws IOException {
        try{
            Path path = Paths.get(filename.toString());
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(path,APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            System.out.print("what do you want to order : ");
            String item = s.nextLine();
        }
        
    }
    **/

}
