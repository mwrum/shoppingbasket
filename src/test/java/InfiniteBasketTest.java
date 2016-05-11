import org.junit.Before;
import org.junit.Test;
import shoppingdemo.InfiniteBasket;
import shoppingdemo.items.Banana;
import shoppingdemo.items.Item;
import shoppingdemo.items.Orange;

import static org.junit.Assert.assertEquals;

public class InfiniteBasketTest extends BaseBasketTestCases {
    @Before
    public void setUp() {
        basket = new InfiniteBasket();
    }

    @Test
    // Infinite baskets also allow duplicates of same item. This may not be the case
    // for other basket types so this does not belong in base test cases.
    public void addingDuplicatesOfSameObjectShouldContributeToTotalCost() {
        Item banana = new Banana();
        Item orange = new Orange();

        long totalExpectedCost = banana.getPrice() * 2 + orange.getPrice();

        basket.addItem(banana);
        basket.addItem(banana);
        basket.addItem(orange);

        assertEquals(totalExpectedCost, basket.getTotalCost());
    }
}
