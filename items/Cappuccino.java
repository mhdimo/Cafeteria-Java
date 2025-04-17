package items;

import models.Cup;

public class Cappuccino implements Drink {
    private int amount;
    private static final double BASE_PRICE = 3.00;

    public Cappuccino(Cup cup) {
        this.amount = 180;
    }

    @Override
    public String getName() {
        return "Cappuccino";
    }

    @Override
    public double getPrice() {
        return BASE_PRICE;
    }

    @Override
    public void make() {
        System.out.println("Preparing Cappuccino with " + amount + "ml of milk and espresso");
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
}
