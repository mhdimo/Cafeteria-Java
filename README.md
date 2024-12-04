# SWE Project

## Overview
This project is a simple cafeteria management system that allows users to select cups, make various drinks, add syrup, and check the status of the cup. The system is designed to handle different types of drinks and cup sizes, ensuring that the cup does not overflow.

## Features
- Select different cup sizes (Normal, Grande, Venti)
- Make various drinks (Americano, Cappuccino, Caffè Latte, Espresso)
- Add syrup to the cup
- Check if the cup is full or overflowing
- Display cup information (size, drink amount, syrup amount, remaining capacity)
- Reset the current order

## Design Patterns Used
### Factory Pattern
The Factory Pattern is used to create different sizes of cups. The `CupFactory` class is responsible for creating instances of the `Cup` class based on the size specified by the user.

- [CupFactory.java](factories/CupFactory.java)

### Decorator Pattern
The Decorator Pattern is used to add additional functionality to drinks, such as adding syrup. The `ItemDecorator` class is an abstract class that implements the `Item` interface and is extended by the `Syrup` class to add syrup to a drink.

- [ItemDecorator.java](decorators/ItemDecorator.java)
- [Syrup.java](decorators/Syrup.java)

### Observer Pattern
The Observer Pattern is used to monitor the status of the cup. The `CupObserver` interface defines methods for handling events when the cup is full or overflowing. The `AlarmObserver` class implements this interface to provide warnings when these events occur.

- [CupObserver.java](observers/CupObserver.java)
- [AlarmObserver.java](observers/AlarmObserver.java)

## How to Run
1. Compile the project using your preferred Java IDE or command line.
2. Run the `Main` class to start the cafeteria management system.

## Example Usage
1. Select a cup size.
2. Make a drink (e.g., Americano).
3. Add syrup if desired.
4. Check the cup's fullness or overflow status.
5. Display cup information.
6. Reset the order if needed.

## Project Structure