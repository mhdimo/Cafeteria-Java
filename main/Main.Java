package main;

import java.util.Scanner;
import java.util.InputMismatchException;
// Removed: import java.sql.*;
import javax.swing.*;
import items.Drink;
import items.Americano;
import items.Cappuccino;
import items.CaffeLatte;
import items.Espresso;
import items.PumpkinSpiceLatte;
import items.PeppermintMocha;
import models.Cup;
import factories.CupFactory;
import observers.AlarmObserver;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Cup currentCup = null;
    private static AlarmObserver alarm = new AlarmObserver();
    private static int drinkCount = 0;
    private static int syrupCount = 0;
    private static int loyaltyPoints = 0;
    private static boolean isHolidaySeason = false;
    private static boolean useGUI = false;
    // Removed: private static Connection dbConnection = null;
    // Removed: private static final String DB_URL = "jdbc:sqlite:coffee_shop.db";

    public static void main(String[] args) {
        // Removed database connection and initialization try-catch block
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
            // Removed: Close dbConnection if it was open
        }
    }

    // Removed: private static void initializeDatabase() { ... }

    private static void displayMenu() {
        if (useGUI) {
            // Adjusted options array
            String[] options = {"Order", "Settings", "Exit"}; // Removed "View History"
            int choice = JOptionPane.showOptionDialog(null, 
                "Welcome to our Coffee Shop!", 
                "Main Menu", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                options, 
                options[0]);
            // Adjusted choice mapping
            if (choice == 0) processUserChoice(1); // Order maps to case 1-8, 14-17
            else if (choice == 1) processUserChoice(9); // Settings maps to case 9-12
            else if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) processUserChoice(13); // Exit maps to case 13 (new exit index)
            return;
        }
        System.out.println("\n=== Cafeteria Menu ===");
        // Adjusted menu options array
        String[] menuOptions = {
            "Select a cup",
            "Make an Americano",
            "Make a Cappuccino",
            "Make a Caffè Latte",
            "Make an Espresso",
            "Make a Pumpkin Spice Latte",
            "Make a Peppermint Mocha",
            "Add Syrup",
            "Check Loyalty Points",
            "Toggle Holiday Season",
            "Redeem Free Drink",
            "Toggle GUI Mode",
            // Removed: "View Order History",
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
        // Adjusted switch cases due to removal of "View Order History"
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
                makeDrink(new PumpkinSpiceLatte(currentCup));
                break;
            case 7:
                makeDrink(new PeppermintMocha(currentCup));
                break;
            case 8:
                addSyrup();
                break;
            case 9:
                checkLoyaltyPoints();
                break;
            case 10:
                toggleHolidaySeason();
                break;
            case 11:
                redeemFreeDrink();
                break;
            case 12:
                toggleGUIMode();
                break;
            // Case 13 is now Check Cup Fullness
            case 13:
                checkCupFullness();
                break;
            // Case 14 is now Check Cup Overflow
            case 14:
                checkCupOverflow();
                break;
            // Case 15 is now Check Cup Info
            case 15:
                checkCupInfo();  
                break;
            // Case 16 is now Reset Current Order
            case 16:
                resetCurrentOrder();
                break;
            // Case 17 is now Exit
            case 17:
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
        if (isHolidaySeason && (drink instanceof PumpkinSpiceLatte || drink instanceof PeppermintMocha)) {
            System.out.println("Enjoy your festive drink!");
        }
        drink.make();
        drinkCount++;
        loyaltyPoints++;
        // Removed: saveOrderToDatabase(drink.getDescription(), drink.getCost());
        System.out.println("Current loyalty points: " + loyaltyPoints);
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
    
    private static void checkLoyaltyPoints() {
        System.out.println("Current loyalty points: " + loyaltyPoints);
    }
    
    private static void toggleHolidaySeason() {
        isHolidaySeason = !isHolidaySeason;
        System.out.println("Holiday season mode: " + (isHolidaySeason ? "ON" : "OFF"));
    }
    
    private static void redeemFreeDrink() {
        if (loyaltyPoints >= 1000) {
            loyaltyPoints -= 1000;
            System.out.println("Free drink redeemed! Enjoy your beverage.");
        } else {
            System.out.println("You need at least 1000 points to redeem a free drink.");
        }
    }
    
    private static void toggleGUIMode() {
        useGUI = !useGUI;
        System.out.println("GUI mode: " + (useGUI ? "ON" : "OFF"));
    }
    
    // Removed: private static void viewOrderHistory() { ... }

    private static void resetCurrentOrder() {
        currentCup = null;
        drinkCount = 0;
        syrupCount = 0;
        System.out.println("Current order has been reset.");
    }

    private static void exitProgram() {
        System.out.println("Thank you for visiting! Exiting...");
        // Removed: Close dbConnection if it was open
        System.exit(0);
    }
}
