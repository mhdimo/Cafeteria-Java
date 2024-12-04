package decorators;

import items.Item;
import models.Cup;

public class Syrup extends ItemDecorator {
    private static final int SYRUP_VOLUME = 30;

    public Syrup(Item item, Cup cup) {
        super(item);
        if (cup != null) {
            cup.addSyrup(SYRUP_VOLUME);
        }
    }

    @Override
    public String getName() {
        return item.getName() + " + Syrup";
    }

    @Override
    public double getPrice() {
        return item.getPrice() + 0.7;
    }

    @Override
    public int getAmount() {
        return SYRUP_VOLUME;
    }
}
