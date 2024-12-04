package items;

import models.Cup;

public class Americano implements Drink {
    private static final double BASE_PRICE = 2.5;
    private int amount;

    public Americano(Cup cup) {
        this.amount = 150;
    }

    @Override
    public String getName() {
        return "Americano";
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