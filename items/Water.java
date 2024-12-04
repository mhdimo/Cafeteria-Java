package items;

public class Water implements Drink {
    @Override
    public String getName() {
        return "Water";
    }

    @Override
    public double getPrice() {
        return 1.0;
    }

    @Override
    public int getAmount() {
        return 30;
    }
}
