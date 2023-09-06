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

public class Items extends manage {
    private String name, category, price, availability, code, descriptions;
    // Declare file name only once. Change this according to local file location.
    private static final String FILENAME = "/Users/htankhaishan/Desktop/Backup/src/oodj/items.txt";
    
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
    public void add() {
        try (FileWriter writer = new FileWriter(FILENAME, true);
           BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
           // Prompt the user for item information
           Scanner scanner = new Scanner(System.in);
           System.out.print("Enter item name: ");
           String Iname = scanner.nextLine();
           System.out.print("Enter item category: ");
           String Icate = scanner.nextLine();
           System.out.print("Enter item price in RM: ");
           String Iprice = scanner.nextLine();
           System.out.print("Enter item Availability (Available or NoStock): ");
           String Iavi = scanner.nextLine();
           System.out.print("Enter item Description: ");
           String Idec = scanner.nextLine();
           System.out.print("Enter Product Code: ");
           String Icode = scanner.nextLine();
           
           // Display the entered data for confirmation
           System.out.println("\nPlease review the entered data:");
           System.out.println("Name: " + Iname);
           System.out.println("Category: " + Icate);
           System.out.println("Price: " + Iprice);
           System.out.println("Availability: " + Iavi);
           System.out.println("Description: " + Idec);
           System.out.println("Product Code: " + Icode);

           System.out.print("Do you want to save this item? (yes/no): ");
           String confirm = scanner.nextLine();

           if (confirm.equals("yes") || confirm.equals("y")) {
               // Create a comma-separated string with the item data
               String itemData = Iname + "," + Icate + "," + Iprice + "," + Iavi + "," + Icode + "," + Idec;
               // Write the item data to the file
               bufferedWriter.write(itemData);
               bufferedWriter.newLine();
               System.out.println("\nItem information saved successfully.\n");
           } else {
               System.out.println("\nItem not saved.\n");
           }
       } catch (IOException e) {
           System.out.println("\nAn error occurred while saving the item information.\n");
       }
    }
    
    @Override
    public void view(){
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

        String separator = "----------------------------------------------------------------------------------------";
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

    @Override
        public void delete(String itemNameToDelete) {
            try (Scanner scanner = new Scanner(new File(FILENAME));
                 FileWriter writer = new FileWriter(FILENAME + ".tmp");
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

                boolean itemDeleted = false;
                
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] itemInfo = line.split(",");
                    String itemNameFromFile = itemInfo[0].trim();

                    if (!itemNameFromFile.equalsIgnoreCase(itemNameToDelete)) {
                        // Write the item data to the temporary file
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    } else {
                        itemDeleted = true;
                    }
                }

                if (itemDeleted) {
                    System.out.println("\nItem deleted successfully.\n");
                } else {
                    System.out.println("\nItem not found.\n");
                }
            } catch (IOException e) {
                System.out.println("\nAn error occurred while deleting the item.\n");
            }

            // After the deletion is done, you should rename the temporary file to replace the original file.
            File originalFile = new File(FILENAME);
            File temporaryFile = new File(FILENAME + ".tmp");

            if (temporaryFile.renameTo(originalFile)) {
                System.out.println("File renamed successfully.\n");
            } else {
                System.out.println("Failed to rename the file.\n");
            }
        }


    @Override
    public void edit(String itemNameToEdit, String newName, String newCategory, String newPrice, String newAvailability, String newCode, String newDescription) {
    boolean itemFound = false;

    // First, check if the item exists
    try (Scanner scanner = new Scanner(new File(FILENAME));
         BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME + ".tmp"))) {

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] itemInfo = line.split(",");
            String itemName = itemInfo[0].trim();

            if (itemName.equalsIgnoreCase(itemNameToEdit)) {
                // Item found, update its information
                String itemData = newName + "," + newCategory + "," + newPrice + "," + newAvailability + "," + newCode + "," + newDescription + "\n";
                writer.write(itemData);
                itemFound = true;
            } else {
                writer.write(line);
                writer.newLine();
            }
        }
    } catch (IOException e) {
        System.out.println("\nAn error occurred while editing the item information.\n");
        return;
    }

    if (!itemFound) {
        System.out.println("\nThere's no such item to edit.\n");
        return;
    }
    // After the deletion is done, you should rename the temporary file to replace the original file.
    File originalFile = new File(FILENAME);
    File temporaryFile = new File(FILENAME + ".tmp");

    if (temporaryFile.renameTo(originalFile)) {
        System.out.println("File renamed successfully.\n");
    } else {
        System.out.println("Failed to rename the file.\n");
    }
}
  
    public boolean check(String itemNameToEdit) {
        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] itemInfo = line.split(",");
                String itemNameFromFile = itemInfo[0].trim();
                if (itemNameFromFile.equalsIgnoreCase(itemNameToEdit)) {
                    return true; // Item found
                }
            }
        } catch (IOException e) {
            System.out.println("\nAn error occurred while checking item information.\n");
        }
        return false; // Item not found
    }
}    