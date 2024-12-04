package main;

import java.util.Scanner;
import java.util.InputMismatchException;
import items.Drink;
import items.Americano;
import items.Cappuccino;
import items.CaffeLatte;
import items.Espresso;
import models.Cup;
import factories.CupFactory;
import observers.AlarmObserver;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Cup currentCup = null;
    private static AlarmObserver alarm = new AlarmObserver();
    private static int drinkCount = 0;
    private static int syrupCount = 0;

    public static void main(String[] args) {
        try {
            while (true) {
                displayMenu();
                int choice = getUserChoice();
                processUserChoice(choice);
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Cafeteria Menu ===");
        String[] menuOptions = {
            "Select a cup",
            "Make an Americano",
            "Make a Cappuccino",
            "Make a Caffè Latte",
            "Make an Espresso",
            "Add Syrup",
            "Check Cup Fullness",
            "Check Cup Overflow",
            "Check Cup Info", 
            "Reset Current Order",
            "Exit"
        };
        
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.printf("%d. %s%n", i + 1, menuOptions[i]);
        }
        System.out.print("Please select an option: ");
    }

    private static int getUserChoice() {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private static void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                selectCup();
                break;
            case 2:
                makeDrink(new Americano(currentCup));
                break;
            case 3:
                makeDrink(new Cappuccino(currentCup));
                break;
            case 4:
                makeDrink(new CaffeLatte(currentCup));
                break;
            case 5:
                makeDrink(new Espresso(currentCup));
                break;
            case 6:
                addSyrup();
                break;
            case 7:
                checkCupFullness();
                break;
            case 8:
                checkCupOverflow();
                break;
            case 9:
                checkCupInfo();  
                break;
            case 10:
                resetCurrentOrder();
                break;
            case 11:
                exitProgram();
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void selectCup() {
        System.out.println("Choose cup size:");
        String[] cupSizes = {"Normal (200 ml)", "Grande (250 ml)", "Venti (400 ml)"};
        for (int i = 0; i < cupSizes.length; i++) {
            System.out.printf("%d. %s%n", i + 1, cupSizes[i]);
        }
        System.out.print("Enter your choice: ");

        int cupChoice = getUserChoice();
        switch (cupChoice) {
            case 1:
                currentCup = CupFactory.createCup("normal");
                System.out.println("Selected Normal cup (200 ml).");
                break;
            case 2:
                currentCup = CupFactory.createCup("grande");
                System.out.println("Selected Grande cup (250 ml).");
                break;
            case 3:
                currentCup = CupFactory.createCup("venti");
                System.out.println("Selected Venti cup (400 ml).");
                break;
            default:
                System.out.println("Invalid cup selection.");
        }
    }

    private static void makeDrink(Drink drink) {
        if (currentCup == null) {
            System.out.println("Please select a cup first!");
            return;
        }
    
        currentCup.addDrink(drink);
        drinkCount++;
        System.out.println("You have selected " + drink.getClass().getSimpleName() + "!");
        System.out.printf("Price: $%.2f%n", drink.getPrice());
        System.out.printf("Amount: %d ml%n", drink.getAmount());
    }

    private static void addSyrup() {
        if (currentCup == null) {
            System.out.println("Please select a cup first!");
            return;
        }

        System.out.print("Enter syrup amount (ml): ");
        try {
            int syrupAmount = scanner.nextInt();
            scanner.nextLine();
            
            if (syrupAmount < 0) {
                System.out.println("Syrup amount cannot be negative.");
                return;
            }

            currentCup.addSyrup(syrupAmount);
            syrupCount++;
            System.out.println("Syrup added: " + syrupAmount + " ml.");

            checkCupOverflow();

        } catch (InputMismatchException e) {
            System.out.println("Invalid syrup amount. Please enter a number.");
            scanner.nextLine();
        }
    }

    private static void checkCupFullness() {
        if (currentCup == null) {
            System.out.println("Please select a cup first!");
            return;
        }

        System.out.println(currentCup.isFull() ? 
            "The cup is full!" : 
            "The cup is not full yet.");
    }

    private static void checkCupOverflow() {
        if (currentCup == null) {
            System.out.println("Please select a cup first!");
            return;
        }

        if ((currentCup.getSyrupAmount() + currentCup.getDrinkAmount()) > currentCup.getMaxSize()) {
            System.out.println("Warning: The cup is overflowing!");
        } else {
            System.out.println("The cup is not overflowing.");
        }
    }

    private static void checkCupInfo() {
        if (currentCup == null) {
            System.out.println("Please select a cup first!");
            return;
        }
    
        System.out.println("\n=== Cup Information ===");
        System.out.printf("Cup Size: %s%n", currentCup.getSize());
        System.out.printf("Drink Amount: %d ml%n", currentCup.getDrinkAmount());
        System.out.printf("Syrup Amount: %d ml%n", currentCup.getSyrupAmount());
        System.out.printf("Remaining Capacity: %d ml%n", currentCup.getRemainingCapacity());
    }

    private static void resetCurrentOrder() {
        currentCup = null;
        drinkCount = 0;
        syrupCount = 0;
        System.out.println("Current order has been reset.");
    }

    private static void exitProgram() {
        System.out.println("Thank you for visiting! Goodbye.");
        System.exit(0);
    }
}
