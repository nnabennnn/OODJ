package oodj;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author htank
 */

import java.io.IOException;
import java.util.Scanner;

public final class Sales {

    private boolean running;
    private final Scanner scanner;
    private boolean displayMenu;

    public Sales() throws IOException {
        this.running = true;
        this.scanner = new Scanner(System.in);
        this.displayMenu = true;
        start();
    }

    private void displayMenu() {
        System.out.println("Welcome, Sale Manager!\n1. Item Entry Manage.\n2. Supplier Entry Manage.\n3. Daily Item-Wise Sales Entry.\n4. Create Requisition.\n5. List of Purchase Orders.\n0. Logout.\n");
        System.out.print("Enter your choice: ");
    }

    public void start() throws IOException {
        try (scanner) {
            while (running) {
                int choice;
                if (displayMenu) {
                    displayMenu();
                }
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    displayMenu = true; // Reset the displayMenu flag after successful input
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Enter your choice: ");
                    displayMenu = false; // Don't display the menu again for invalid input
                    continue;
                }

                switch (choice) {
                    case 1 -> itemEntry();
                    case 2 -> supplierEntry();
                    case 3 -> dailyItemsWiseSales();
                    case 4 -> purchaseRequisition();
                    case 5 -> listOfPurchaseOrders();
                    case 0 -> logout();
                    default -> {
                        System.out.println("Invalid number. Please enter a valid option.");
                        displayMenu = false; // Don't display the menu again for invalid input
                    }
                }
            }
        }
        System.out.println("Logged out Successfully. Goodbye!");
    }

    private void itemEntry() throws IOException {
    boolean itemDisplayMenu = true;
    while (itemDisplayMenu) {
        System.out.println("Item Entry Submenu...\n1. Add New Items.\n2. Delete Items.\n3. Edit Item Informations.\n0. Go back to Main Menu\n");
        System.out.print("Enter your choice: ");
        int submenuChoice = Integer.parseInt(scanner.nextLine());
        switch (submenuChoice) {
            
            case 1 -> {
                System.out.println("Add New Items.");
                System.out.print("Enter item name: ");
                String name = scanner.nextLine();
                System.out.print("Enter item category: ");
                String category = scanner.nextLine();
                System.out.print("Enter item price in RM: ");
                String price = scanner.nextLine();
                System.out.print("Enter item Availability (Available or NoStock): ");
                String availability = scanner.nextLine();
                System.out.print("Enter item Description: ");
                String descriptions = scanner.nextLine();
                System.out.print("Enter Product Code: ");
                String code = scanner.nextLine();
                System.out.print("\nDo you want to save this item? Please checks before you proceed. (Y/N): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    Items item = new Items(name, category, price, availability, code, descriptions);
                    item.saveItemToFile(name, category, price, availability, code, descriptions);
                } else {
                    System.out.println("Item not saved.");
                }
                break;
            }

            case 2 -> {
                System.out.println("Delete item logic...");
                System.out.print("Enter the name of the item to delete: ");
                String itemNameToDelete = scanner.nextLine();
                Items item = new Items();
                item.deleteItemsFromFile(itemNameToDelete);
                break;
            }

            case 3 -> {
                System.out.println("Edit item logic...");
                System.out.print("Enter the name of the item to edit: ");
                String itemNameToEdit = scanner.nextLine();
                System.out.print("Enter item name: ");
                String name = scanner.nextLine();
                System.out.print("Enter item category: ");
                String category = scanner.nextLine();
                System.out.print("Enter item price in RM: ");
                String price = scanner.nextLine();
                System.out.print("Enter item Availability (Available or NoStock): ");
                String availability = scanner.nextLine();
                System.out.print("Enter item Description: ");
                String descriptions = scanner.nextLine();
                System.out.print("Enter Product Code: ");
                String code = scanner.nextLine();
                System.out.print("\nDo you want to save the changes? Please check before you proceed. (Y/N): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    Items item = new Items();
                    item.editItemsFromFile(itemNameToEdit, name, category, price, availability, code, descriptions);
                } else {
                    System.out.println("Changes not saved.");
                }
                break;
                }
            
            case 0 -> {
                itemDisplayMenu = false; // Exit the loop to go back to the main menu
                break;
                }
            
            default -> {
                System.out.println("Invalid number. Please enter a valid option.");
                break;
                }
            }
        }
    }

    private void supplierEntry() throws IOException {
        boolean supplierDisplayMenu = true;
        while (supplierDisplayMenu) {
        System.out.println("Supplier Entry Submenu...\n1. Add\n2. Delete\n3. Edit\n0. Go back to Main Menu\n");
        System.out.print("Enter your choice: ");
        int submenuChoice = Integer.parseInt(scanner.nextLine());
        switch (submenuChoice) {
            
            case 1 -> {
                System.out.println("Add New Supplier.");
                System.out.print("Enter Supplier Company Name: ");
                String supname = scanner.nextLine();
                System.out.print("Enter Contact Person: ");
                String conname = scanner.nextLine();
                System.out.print("Enter Email: ");
                String supemail = scanner.nextLine();
                System.out.print("Enter Phone: ");
                String supphone = scanner.nextLine();
                System.out.print("Enter Address: ");
                String supaddr = scanner.nextLine();
                System.out.print("Enter Website: ");
                String supweb = scanner.nextLine();
                System.out.print("\nDo you want to save this Supplier Information? Please checks before you proceed. (Y/N): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    Suppliers supp = new Suppliers(supname, conname, supemail, supphone, supaddr, supweb);
                    supp.saveSupplierToFile(supname, conname, supemail, supphone, supaddr, supweb);
                } else {
                    System.out.println("Item not saved.");
                    }
                break;
            }
            
            case 2 -> {
                System.out.println("Delete Supplier Information ...");
                System.out.print("Enter the name of the Supplier to delete: ");
                String supNameToDelete = scanner.nextLine();
                Suppliers supp = new Suppliers();
                supp.deleteSuppliersFromFile(supNameToDelete);
                break;
                }
            
            case 3 -> {
                System.out.println("Edit Supplier Information...");
                System.out.print("Enter the name of the Supplier to edit: ");
                String supNameToEdit = scanner.nextLine();

                // Check if the supplier exists before proceeding
                Suppliers supp = new Suppliers(); // Create an instance of Suppliers
                boolean supplierExists = supp.checkSupplierExists(supNameToEdit);

                if (supplierExists) {
                    System.out.print("Enter new Supplier name: ");
                    String supname = scanner.nextLine();
                    System.out.print("Enter new Supplier Contact: ");
                    String conname = scanner.nextLine();
                    System.out.print("Enter new Supplier Email: ");
                    String supemail = scanner.nextLine();
                    System.out.print("Enter new Supplier Phone: ");
                    String supphone = scanner.nextLine();
                    System.out.print("Enter new Supplier Address: ");
                    String supaddr = scanner.nextLine();
                    System.out.print("Enter new Supplier Website: ");
                    String supweb = scanner.nextLine();
                    System.out.print("\nDo you want to save the changes? Please check before you proceed. (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                    supp.editSupplierFromFile(supNameToEdit, supname, conname, supemail, supphone, supaddr, supweb);
                } else {
                    System.out.println("\nChanges not saved.\n");
                }
            } else {
                System.out.println("\nSupplier not found. Please enter a valid supplier name.\n");
            }
            break;
            }
            
            case 0 -> {
                supplierDisplayMenu = false; // Exit the loop to go back to the main menu
                break;
            }
            
            default -> {
                System.out.println("\nInvalid number. Please enter a valid option.\n");
                break;
            }
        }
        }
    }

    private void dailyItemsWiseSales() throws IOException {
        boolean dailyItemsDisplayMenu = true;
        while (dailyItemsDisplayMenu) {
        System.out.println("Daily Item-Wise Sales Submenu...\n1. Add\n2. Delete\n3. Edit\n0. Go back to Main Menu\n");
        System.out.print("Enter your choice: ");
        int submenuChoice = Integer.parseInt(scanner.nextLine());
        switch (submenuChoice) {
            case 1 -> {
                System.out.println("Add Daily Items-wise Sales.");
                System.out.print("Enter Order ID: ");
                String orderID = scanner.nextLine();
                System.out.print("Enter Product Name: ");
                String productName = scanner.nextLine();
                System.out.print("Enter Quantity Sold: ");
                String quantitySold = scanner.nextLine();
                System.out.print("Enter Revenue in RM: ");
                String revenue = scanner.nextLine();
                System.out.print("\nDo you want to save this Supplier Information? Please checks before you proceed. (Y/N): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    DailyItemsSale dailySales = new DailyItemsSale(orderID, productName, quantitySold, revenue);
                    dailySales.saveDailyToFile(orderID, productName, quantitySold, revenue);
                } else {
                    System.out.println("Item not saved.");
                    }
                break;
            }
            case 2 -> {
                System.out.println("Delete Daily Items-wise Sales ...");
                System.out.print("Enter the name of the Supplier to delete: ");
                String dailyItemToDelete = scanner.nextLine();
                DailyItemsSale dailySales = new DailyItemsSale();
                dailySales.deleteDailyFromFile(dailyItemToDelete);
                break;
                }
            
            case 3 -> {
                System.out.println("Edit Daily Items-wise Information...");
                System.out.print("Enter the name of the Item to edit: ");
                String dailyNameToEdit = scanner.nextLine();

                // Check if the supplier exists before proceeding
                DailyItemsSale dailyItem = new DailyItemsSale(); // Create an instance of Suppliers
                boolean itemExists = dailyItem.checkDailyExists(dailyNameToEdit);

                if (itemExists) {
                    System.out.print("Enter new Order ID: ");
                    String orderID = scanner.nextLine();
                    System.out.print("Enter new Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter new Quanitity Sold: ");
                    String quantitySold = scanner.nextLine();
                    System.out.print("Enter new Revenue: ");
                    String revenue = scanner.nextLine();
                    System.out.print("\nDo you want to save the changes? Please check before you proceed. (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                    dailyItem.editDailyFromFile(dailyNameToEdit, orderID, productName, quantitySold, revenue);
                } else {
                    System.out.println("\nChanges not saved.\n");
                }
            } else {
                System.out.println("\nItem not found. Please enter a valid Daily Items Sale name.\n");
            }
            break;
            }
            
            case 0 -> displayMenu = true; // Go back to the main menu
            default -> System.out.println("\nInvalid number. Please enter a valid option.\n");
        }
    }
    }
        
    private void purchaseRequisition() {
        System.out.println("List of Purchase Orders Submenu...");
        // Add submenu options and logic here
        System.out.println("Click Enter to Go Back Main Menu.");
        String submenuChoice = scanner.nextLine();
        if (submenuChoice.isEmpty()) {
            System.out.print("Go back to Main Menu? (Yes/No): ");
            String yesNo = scanner.nextLine().toLowerCase();
            if (yesNo.equals("yes")) {
                displayMenu = true; // Go back to the main menu
            }
        } else {
            System.out.println("Invalid number. Please enter a valid option.");
        }
    }
    
    private void listOfPurchaseOrders() {
        System.out.println("List of Purchase Orders Submenu...");
        // Add submenu options and logic here
        System.out.println("Click Enter to Go Back Main Menu.");
        String submenuChoice = scanner.nextLine();
        if (submenuChoice.isEmpty()) {
            System.out.print("Go back to Main Menu? (Yes/No): ");
            String yesNo = scanner.nextLine().toLowerCase();
            if (yesNo.equals("yes")) {
                displayMenu = true; // Go back to the main menu
            }
        } else {
            System.out.println("Invalid number. Please enter a valid option.");
        }
    }
    
    private void logout() {
        running = false;
    }
}
