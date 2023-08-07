package oodj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author htankhaishan
 */
public class Suppliers {
    private String supname, conname, supemail, supphone, supaddr, supweb;
    private static final String FILENAME = "/Users/htankhaishan/Documents/2nd Year 1st Sem/Java/OODJ/suppliers.txt";

    public Suppliers(String supname, String conname, String supemail, String supphone, String supaddr, String supweb){
        this.supname = supname;
        this.conname = conname;
        this.supemail = supemail;
        this.supphone = supphone;
        this.supaddr = supaddr;
        this.supweb = supweb;
    }

    public Suppliers() {
        
    }
    
    public void saveSupplierToFile(String supname, String conname, String supemail, String supphone, String supaddr, String supweb) throws IOException {
        try (FileWriter writer = new FileWriter(FILENAME, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            String supData = supname + "," + conname + "," + supemail + "," + supphone + "," + supaddr + "," + supweb + "\n";
            bufferedWriter.write(supData);
            System.out.println("\nSupplier information saved Successfully.\n");
        } catch (IOException e) {
            System.out.println("\nAn error occurred while saving the Supplier information.\n");
        }
    }
    
    public void deleteSuppliersFromFile(String supNameToDelete) throws IOException {
    File inputFile = new File(FILENAME);
    File tempFile = new File(FILENAME + ".tmp");
    boolean supFound = false;

    try (Scanner scanner = new Scanner(inputFile);
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] supInfo = line.split(",");
            String supName = supInfo[0].trim(); // Assuming the item name is stored in the first column

            if (!supName.equalsIgnoreCase(supNameToDelete)) {
                writer.write(line);
                writer.newLine();
            } else {
                supFound = true;
            }
        }
    } catch (IOException e) {
        System.out.println("\nAn error occurred while deleting the Supplier Informanion.\n");
        return;
    }

    if (!supFound) {
        System.out.println("\nInput Supplier not available.\n");
        return;
    }

    // Delete the original file and rename the temporary file to the original file name
    if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
        System.out.println("\nFailed to update the Supplier file after deletion.\n");
    } else {
        System.out.println("\nSupplier Information deleted Successfully.\n");
    }
    }
    
    public void editSupplierFromFile(String supNameToEdit, String supname, String conname, String supemail, String supphone, String supaddr, String supweb) throws IOException {
    File tempFile = new File(FILENAME + ".tmp");
    boolean supFound = false;

    try (Scanner scanner = new Scanner(new File(FILENAME));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] supInfo = line.split(",");
            String supName = supInfo[0].trim();

            if (supName.equalsIgnoreCase(supNameToEdit)) {
                String supData = supname + "," + conname + "," + supemail + "," + supphone + "," + supaddr + "," + supweb + "\n";
                writer.write(supData);
                supFound = true;
            } else {
                writer.write(line);
                writer.newLine();
            }
        }
    } catch (IOException e) {
        System.out.println("\nAn error occurred while editing the supplier information.\n");
        return;
    }

    if (!checkSupplierExists(supNameToEdit)) {
        System.out.println("\nThere's no such supplier to edit.\n");
        return;
    }

    if (!supFound) {
        System.out.println("\nThere's no such supplier to edit.\n");
        return;
    }

    if (!tempFile.renameTo(new File(FILENAME))) {
        System.out.println("\nFailed to update the supplier file after editing.\n");
    } else {
        System.out.println("\nSupplier information edited successfully.\n");
    }
}

    public boolean checkSupplierExists(String supName) {
        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] supInfo = line.split(",");
                String supNameFromFile = supInfo[0].trim();
                if (supNameFromFile.equalsIgnoreCase(supName)) {
                    return true; // Supplier found
                }
            }
        } catch (IOException e) {
            System.out.println("\nAn error occurred while checking supplier information.\n");
        }
        return false; // Supplier not found
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getConname() {
        return conname;
    }

    public void setConname(String conname) {
        this.conname = conname;
    }

    public String getSupemail() {
        return supemail;
    }

    public void setSupemail(String supemail) {
        this.supemail = supemail;
    }

    public String getSupphone() {
        return supphone;
    }

    public void setSupphone(String supphone) {
        this.supphone = supphone;
    }

    public String getSupaddr() {
        return supaddr;
    }

    public void setSupaddr(String supaddr) {
        this.supaddr = supaddr;
    }

    public String getSupweb() {
        return supweb;
    }

    public void setSupweb(String supweb) {
        this.supweb = supweb;
    }
    
    
}
