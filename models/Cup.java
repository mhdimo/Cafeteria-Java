package models;

import items.Drink;

public class Cup {
    private String size;
    private int syrupAmount;
    private int drinkAmount;
    private int maxSize;

    public Cup(String size) {
        this.size = size;
        this.syrupAmount = 0;
        this.drinkAmount = 0;

        switch (size.toLowerCase()) {
            case "normal":
                this.maxSize = 200;
                break;
            case "grande":
                this.maxSize = 250;
                break;
            case "venti":
                this.maxSize = 400;
                break;
            default:
                this.maxSize = 200;
                break;
        }
    }

    public String getSize() {
        return this.size;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void addSyrup(int amount) {
        if (this.syrupAmount + amount > maxSize) {
            System.out.println("Warning: Syrup overflow! Only " + (maxSize - syrupAmount) + " ml can be added.");
            this.syrupAmount = maxSize;
        } else {
            this.syrupAmount += amount;
        }
    }

    public void addDrink(Drink drink) {
        int drinkAmount = drink.getAmount();  
        if (this.drinkAmount + drinkAmount > maxSize) {
            System.out.println("Warning: Drink overflow! Only " + (maxSize - this.drinkAmount) + " ml can be added.");
            this.drinkAmount = maxSize; 
        } else {
            this.drinkAmount += drinkAmount;
        }
    }

    public int getSyrupAmount() {
        return this.syrupAmount;
    }

    public int getDrinkAmount() {
        return this.drinkAmount;
    }

    public boolean isFull() {
        return (syrupAmount + drinkAmount) >= maxSize;
    }

    public int getRemainingCapacity() {
    return maxSize - (syrupAmount + drinkAmount);
    }
}