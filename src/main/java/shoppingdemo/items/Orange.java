package shoppingdemo.items;

public class Orange implements Item {
    @Override
    public long getPrice() {
        // For every item I'm making the initial starting assumption
        // that the price is fixed. If we wish to have variable prices
        // later,  we can introduce this.
        return 190;
    }
}
