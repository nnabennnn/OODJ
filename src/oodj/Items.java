/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author htankhaishan
 */


public class Items {
    private String name, category, price, availability, code, descriptions;
    // Declare file name only once. Change this according to local file location.
    private static final String FILENAME = "/Users/htankhaishan/Documents/2nd Year 1st Sem/Java/OODJ/items.txt";

    
    public Items(String name, String category, String price, String availability, String code, String descriptions){
        this.name = name;
        this.category = category;
        this.price = price;
        this.availability = availability;
        this.code = code;
        this.descriptions = descriptions;
    }
    
    public Items(){
    }

    @Override
    public String toString() {
        return "Name: "+name+"\nCategory: "+category+"\nPrice: "+price+"\nAvailability: "+availability+"\nProduct Code: "+code+"\nDiscription: "+descriptions;
    }
    
    public void saveItemToFile(String name, String category, String price, String availability, String code, String descriptions) throws IOException {
        try (FileWriter writer = new FileWriter(FILENAME, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            // Check if the file is empty before writing the new item data
            /**
            if (file.length() != 0) {
                bufferedWriter.newLine(); // Add a newline if the file is not empty
            }
            **/
            String itemData = name + "," + category + "," + price + "," + availability + "," + code + "," + descriptions + "\n";
            bufferedWriter.write(itemData);
            System.out.println("Item information saved Successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the item information.");
        }
    }
    
    public void deleteItemsFromFile(String itemNameToDelete) throws IOException {
    File inputFile = new File(FILENAME);
    File tempFile = new File(FILENAME + ".tmp");
    boolean itemFound = false;

    try (Scanner scanner = new Scanner(inputFile);
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] itemInfo = line.split(",");
            String itemName = itemInfo[0].trim(); // Assuming the item name is stored in the first column

            if (!itemName.equalsIgnoreCase(itemNameToDelete)) {
                writer.write(line);
                writer.newLine();
            } else {
                itemFound = true;
            }
        }
    } catch (IOException e) {
        System.out.println("An error occurred while deleting the item from the file.");
        return;
    }

    if (!itemFound) {
        System.out.println("There's no such item in stock.");
        return;
    }

    // Delete the original file and rename the temporary file to the original file name
    if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
        System.out.println("Failed to update the item file after deletion.");
    } else {
        System.out.println("Item deleted from file successfully.");
    }
    }

    public void editItemsFromFile(String itemNameToEdit, String name, String category, String price, String availability, String code, String descriptions) throws IOException {
    File tempFile = new File(FILENAME + ".tmp");
    boolean itemFound = false;

    try (Scanner scanner = new Scanner(new File(FILENAME));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] itemInfo = line.split(",");
            String itemName = itemInfo[0].trim(); // Assuming the item name is stored in the first column

            if (itemName.equalsIgnoreCase(itemNameToEdit)) {
                // Edit the item if found
                String itemData = name + "," + category + "," + price + "," + availability + "," + code + "," + descriptions + "\n";
                writer.write(itemData);
                itemFound = true;
            } else {
                // Write the line as it is to the temporary file
                writer.write(line);
                writer.newLine();
            }
        }
    } catch (IOException e) {
        System.out.println("An error occurred while editing the item information.");
        return;
    }

    if (!itemFound) {
        System.out.println("There's no such item in stock to edit.");
        return;
    }

    // Rename the temporary file to the original file name
    if (!tempFile.renameTo(new File(FILENAME))) {
        System.out.println("Failed to update the item file after editing.");
    } else {
        System.out.println("Item information edited Successfully.");
    }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    
    
}
