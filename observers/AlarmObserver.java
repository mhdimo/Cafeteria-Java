package observers;

import models.Cup;

public class AlarmObserver implements CupObserver {
    @Override
    public void onCupFull(Cup cup) {
        System.out.println("Warning: " + cup.getSize() + " cup is full!");
    }

    @Override
    public void onCupOverflow(Cup cup) {
        System.out.println("Warning: " + cup.getSize() + " cup is overflowing!");
    }
}
