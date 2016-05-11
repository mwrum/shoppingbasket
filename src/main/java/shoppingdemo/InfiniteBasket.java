package shoppingdemo;

import shoppingdemo.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * A basket containing an effectively unbounded number of {@link shoppingdemo.items.Item}.
 * This basket allows duplicates.
 */
public class InfiniteBasket implements Basket {

    // We allow duplicates. This is a purposeful decision without knowing more about
    // the problem space. It could be that items might be Enum instances (static, same object)
    // in which case we definitely need to allow duplicates of these.
    private final List<Item> items;

    public InfiniteBasket() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void removeItem(Item item) {
        // Aware that this is of course O(n) worst case speed and not ideal
        // but since we don't know any further speed requirements about the problem
        // we keep it simple and can change container later if required.
        items.remove(item);
    }

    @Override
    public long getTotalCost() {
        return items.stream().mapToLong(Item::getPrice).sum();
    }
}
