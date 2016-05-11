
import org.junit.Test;
import shoppingdemo.Basket;
import shoppingdemo.items.Apple;
import shoppingdemo.items.Banana;
import shoppingdemo.items.Item;
import shoppingdemo.items.Lemon;
import shoppingdemo.items.Orange;
import shoppingdemo.items.Peach;

import static org.junit.Assert.assertEquals;

/**
 * Base class for our basket test cases. Sub class this for a specific
 * basket type and make sure to implement the @Before method to initialise
 * the basket instance variable.
 */
public abstract class BaseBasketTestCases {

    Basket basket;

    @Test
    public void emptyBasketShouldReturnZeroTotalCost() {
        assertEquals(0, basket.getTotalCost());
    }

    @Test
    public void addOneItemToBasketShouldReturnOneItemTotalCost() {
        basket.addItem(new DummyItem());
        assertEquals(17, basket.getTotalCost());
    }

    @Test
    public void addOneItemThenRemoveItShouldReturnZeroTotalCost() {
        Item dummy = new DummyItem();
        basket.addItem(dummy);
        basket.removeItem(dummy);
        assertEquals(0, basket.getTotalCost());
    }

    @Test
    public void addTwoItemsRemoveOneShouldReturnOneItemCost() {
        Item dummy1 = new DummyItem();
        Item dummy2 = new DummyItem();

        long costOfOne = dummy2.getPrice();

        basket.addItem(dummy1);
        basket.addItem(dummy2);
        basket.removeItem(dummy1);

        assertEquals(costOfOne, basket.getTotalCost());
    }

    @Test
    public void addOneBananaShouldReturnBananaCost() {
        Item banana = new Banana();
        long costOfOne = banana.getPrice();
        basket.addItem(banana);
        assertEquals(costOfOne, basket.getTotalCost());
    }

    @Test
    public void addMultipleItemTypesShouldReturnCorrectCost() {
        Item banana = new Banana();
        Item orange = new Orange();
        Item peach = new Peach();
        Item apple = new Apple();
        Item lemon = new Lemon();

        basket.addItem(banana);
        basket.addItem(orange);
        basket.addItem(peach);
        basket.addItem(apple);
        basket.addItem(lemon);

        long itemsCost = banana.getPrice() + orange.getPrice() + peach.getPrice() + apple.getPrice() + lemon.getPrice();
        assertEquals(itemsCost, basket.getTotalCost());
    }

    @Test
    public void removeItemWhichDoesNotExistInBasketHasNoImpact() {
        Item banana1 = new Banana();
        Item banana2 = new Banana();

        basket.addItem(banana1);
        basket.removeItem(banana2);

        assertEquals(banana1.getPrice(), basket.getTotalCost());
    }

    @Test
    public void removeFromEmptyBasketHasNoImpact() {
        basket.removeItem(new DummyItem());
        assertEquals(0, basket.getTotalCost());
    }

    private static final class DummyItem implements Item {
        @Override
        public long getPrice() {
            return 17;
        }
    }
}
