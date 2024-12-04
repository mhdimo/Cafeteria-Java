package items;

import models.Cup;

public class Espresso implements Drink {
    private int amount;
    private static final double BASE_PRICE = 1.0;
    private static final int AMOUNT = 30;

    public Espresso(Cup cup) {
        this.amount = AMOUNT;
    }

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public double getPrice() {
        return BASE_PRICE;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
}