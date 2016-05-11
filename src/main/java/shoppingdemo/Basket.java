package shoppingdemo;

import shoppingdemo.items.Item;

/**
 * A container for shopping items.
 */
public interface Basket {
    /**
     * Add an item to the container. We allow duplicates of the same item (object).
     * @param item the specific object to be added.
     */
    void addItem(Item item);

    /**
     * Remove an item from the container.
     * @param item the specific object to be removed.
     */
    void removeItem(Item item);

    /**
     * Calculates the total cost of the items in our basket.
     * @return total cost
     */
    long getTotalCost();
}
