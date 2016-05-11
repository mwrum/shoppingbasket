package shoppingdemo.items;

/**
 * Public interface of a purchasable item.
 */
public interface Item {
    /**
     * Returns the price of an item in the fractional currency unit.
     * @return price of the item
     */
    long getPrice();
}
