package items;

public class Milk implements Drink {
    @Override
    public String getName() {
        return "Milk";
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
