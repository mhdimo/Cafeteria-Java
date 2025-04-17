package items;

import models.Cup;

public class PeppermintMocha implements Drink {
    private int amount;
    private static final double BASE_PRICE = 4.75;

    public PeppermintMocha(Cup cup) {
        this.amount = 230;
    }

    @Override
    public String getName() {
        return "Peppermint Mocha";
    }

    @Override
    public double getPrice() {
        return BASE_PRICE;
    }

    @Override
    public void make() {
        System.out.println("Preparing Peppermint Mocha with " + amount + "ml of peppermint-flavored milk and espresso");
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
}