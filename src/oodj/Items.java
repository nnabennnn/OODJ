/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author htankhaishan
 */

//filepath
// "/Users/ben/Documents/OOPJAVA/OODJ/items.txt"
//"/Users/htankhaishan/Documents/2nd Year 1st Sem/Java/OODJ/items.txt"

public class Items {
    private String name, category, price, availability, code, descriptions;
    // Declare file name only once. Change this according to local file location.
    private static final String FILENAME = "/Users/ben/Documents/OOPJAVA/OODJ/items.txt";

    
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
            String itemData = name + "," + category + "," + price + "," + availability + "," + code + "," + descriptions + "\n";
            bufferedWriter.write(itemData);
            System.out.println("\nItem information saved Successfully.\n");
        } catch (IOException e) {
            System.out.println("\nAn error occurred while saving the item information.\n");
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
        System.out.println("\nAn error occurred while deleting the item from the file.\n");
        return;
    }

    if (!itemFound) {
        System.out.println("\nThere's no such item in stock.\n");
        return;
    }

    // Delete the original file and rename the temporary file to the original file name
    if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
        System.out.println("\nFailed to update the item file after deletion.\n");
    } else {
        System.out.println("\nItem deleted from file successfully.\n");
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
        System.out.println("\nAn error occurred while editing the item information.\n");
        return;
    }

    if (!itemFound) {
        System.out.println("\nThere's no such item in stock to edit.\n");
        return;
    }

    // Rename the temporary file to the original file name
    if (!tempFile.renameTo(new File(FILENAME))) {
        System.out.println("\nFailed to update the item file after editing.\n");
    } else {
        System.out.println("\nItem information edited Successfully.\n");
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
    
    
    public void ViewItem(){
        List<String> itemList = ReadItemListFromFile(FILENAME);
        
        int numColumns = 6;
        int[] maxColumnWidths = new int[numColumns];
        List<String[]> formattedItemList = new ArrayList<>();

        for (String item : itemList) {
        String[] itemInfo = item.split(",");
        formattedItemList.add(itemInfo);

            for (int i = 0; i < numColumns; i++) {
                maxColumnWidths[i] = Math.max(maxColumnWidths[i], itemInfo[i].length());
            }
        }

        String separator = "+-----------------+---------+----------+---------------+--------+-------------------+";
        String format = "| %-"+(maxColumnWidths[0]+2)+"s | %-"+(maxColumnWidths[1]+2)+"s | %-"+(maxColumnWidths[2]+2)+"s | %-"+(maxColumnWidths[3]+2)+"s | %-"+(maxColumnWidths[4]+2)+"s | %-"+(maxColumnWidths[5]+2)+"s |";

        System.out.println("Item List:");
        System.out.println(separator);
        System.out.printf(format, "Name", "Type", "Price", "Status", "Code", "Description");
        System.out.println();
        System.out.println(separator);

        for (String[] itemInfo : formattedItemList) {
            System.out.printf(format, itemInfo[0], itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
            System.out.println();
        }

        System.out.println(separator);
    
    }
    
    public static List<String> ReadItemListFromFile(String FILENAME){
        List<String> itemList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))){
            String line;
            while ((line = reader.readLine()) != null) {
                itemList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }
    
    public static String formatTableCell(String cellContent){
       int cellWidth = 15;
        if (cellContent.length() <= cellWidth) {
            return cellContent;
        } else {
            return cellContent.substring(0, cellWidth - 3) + "...";
        } 
    
}
    
         
    
    
}
