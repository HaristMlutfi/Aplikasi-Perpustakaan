package main.java.com.harist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Simple Inventory Management System.
 * Provides functionality to add, remove, and display items in the inventory.
 */
public class InventoryApp {
    private List<Item> items = new ArrayList<>();

    /**
     * Main method to run the inventory application.
     * Provides a text-based menu to interact with the inventory system.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        InventoryApp inventory = new InventoryApp();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Inventory Menu ===");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Items");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    inventory.addItem(new Item(name, quantity));
                    System.out.println("Item added!");
                    break;
                case 2:
                    System.out.print("Enter name of item to remove: ");
                    String removeName = scanner.nextLine();
                    inventory.removeItem(removeName);
                    break;
                case 3:
                    inventory.displayItems();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    /**
     * Adds a new item to the inventory.
     *
     * @param item The item object to be added to the inventory.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the inventory by its name.
     * If the item with the specified name is not found, no action is taken.
     *
     * @param name The name of the item to be removed.
     */
    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(name));
        System.out.println("Item removed if it existed.");
    }

    /**
     * Displays all items currently in the inventory.
     * If no items are present, an empty list is shown.
     */
    public void displayItems() {
        System.out.println("\nItems in Inventory:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
