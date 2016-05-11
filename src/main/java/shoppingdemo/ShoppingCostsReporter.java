package shoppingdemo;

import shoppingdemo.items.Apple;
import shoppingdemo.items.Banana;
import shoppingdemo.items.Lemon;
import shoppingdemo.items.Orange;
import shoppingdemo.items.Peach;

public class ShoppingCostsReporter {
    private final Basket basket;

    public ShoppingCostsReporter(Basket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total cost for your shopping basket: ").append(basket.getTotalCost());
        return sb.toString();
    }

    public static void main(String[] args) {
        Basket basket = new InfiniteBasket();
        basket.addItem(new Banana());
        basket.addItem(new Orange());
        basket.addItem(new Peach());
        basket.addItem(new Lemon());
        basket.addItem(new Apple());
        System.out.println(new ShoppingCostsReporter(basket));
    }
}
