package decorators;

import items.Item;

public abstract class ItemDecorator implements Item {
    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public double getPrice() {
        return item.getPrice();
    }

    @Override
    public int getAmount() {
        return item.getAmount();
    }
}
