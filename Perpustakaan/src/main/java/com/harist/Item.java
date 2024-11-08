package main.java.com.harist;

/**
 * Represents an item in the inventory.
 * Each item has a name and a quantity.
 */
public class Item {
    private String name;
    private int quantity;

    /**
     * Constructs a new item with the specified name and quantity.
     *
     * @param name     The name of the item.
     * @param quantity The quantity of the item.
     */
    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The item's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the quantity of the item.
     *
     * @return The item's quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns a string representation of the item, including its name and quantity.
     *
     * @return A string representation of the item.
     */
    @Override
    public String toString() {
        return "Item: " + name + ", Quantity: " + quantity;
    }
}
