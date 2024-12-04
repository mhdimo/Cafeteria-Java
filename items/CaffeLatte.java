package items;

import models.Cup;

public class CaffeLatte implements Drink {
    private int amount;
    private static final double BASE_PRICE = 3.50;

    public CaffeLatte(Cup cup) {
        this.amount = 200;
    }

    @Override
    public String getName() {
        return "Caffè Latte";
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
