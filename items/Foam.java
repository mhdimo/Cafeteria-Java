package items;

public class Foam implements Drink {
    @Override
    public String getName() {
        return "Foam";
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
