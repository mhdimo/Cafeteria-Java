package items;

import models.Cup;

public class PumpkinSpiceLatte implements Drink {
    private int amount;
    private static final double BASE_PRICE = 4.50;

    public PumpkinSpiceLatte(Cup cup) {
        this.amount = 220;
    }

    @Override
    public String getName() {
        return "Pumpkin Spice Latte";
    }

    @Override
    public double getPrice() {
        return BASE_PRICE;
    }

    @Override
    public void make() {
        System.out.println("Preparing Pumpkin Spice Latte with " + amount + "ml of spiced milk and espresso");
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
}