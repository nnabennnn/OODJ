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
                    case 3 -> dailyItemWiseSales();
                    case 4 -> displayRequisition();
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

    // Implement submenus for each menu option here...

    private void itemEntry() throws IOException {
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
        case 0 -> displayMenu = true; // Go back to the main menu
        default -> System.out.println("Invalid number. Please enter a valid option.");
    }
}


    private void supplierEntry() {
        System.out.println("Supplier Entry Submenu...\n1. Add\n2. Save\n3. Delete\n4. Edit\n0. Go back to Main Menu\n");
        System.out.print("Enter your choice: ");
        int submenuChoice = Integer.parseInt(scanner.nextLine());
        switch (submenuChoice) {
            case 1 -> System.out.println("Add supplier logic...");
            case 2 -> System.out.println("Save supplier logic...");
            case 3 -> System.out.println("Delete supplier logic...");
            case 4 -> System.out.println("Edit supplier logic...");
            case 0 -> displayMenu = true; // Go back to the main menu
            default -> System.out.println("Invalid number. Please enter a valid option.");
        }
    }

    private void dailyItemWiseSales() {
        System.out.println("Daily Item-Wise Sales Submenu...\n1. Add\n2. Save\n3. Delete\n4. Edit\n0. Go back to Main Menu\n");
        System.out.print("Enter your choice: ");
        int submenuChoice = Integer.parseInt(scanner.nextLine());
        switch (submenuChoice) {
            case 1 -> System.out.println("Add daily sales logic...");
            case 2 -> System.out.println("Save daily sales logic...");
            case 3 -> System.out.println("Delete daily sales logic...");
            case 4 -> System.out.println("Edit daily sales logic...");
            case 0 -> displayMenu = true; // Go back to the main menu
            default -> System.out.println("Invalid number. Please enter a valid option.");
        }
    }

    private void displayRequisition() {
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
