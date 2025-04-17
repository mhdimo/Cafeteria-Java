# Coffee Shop Management System

## Overview
A comprehensive Java-based coffee shop management system that simulates drink preparation with cup size selection, syrup addition, and overflow prevention. The system implements design patterns including Factory, Decorator, and Observer for extensible and maintainable architecture.

## Features
- **Cup Selection**: Choose from Normal (200ml), Grande (250ml), or Venti (400ml) cups
- **Drink Preparation**: Create various coffee drinks (Americano, Cappuccino, Latte, etc.)
- **Syrup Customization**: Add syrup with overflow protection
- **Loyalty Program**: Earn and redeem points for free drinks
- **Seasonal Specials**: Holiday-themed drinks during special seasons
- **GUI Mode**: Toggle between console and graphical interface
- **Cup Monitoring**: Real-time cup status tracking (fullness, overflow, remaining capacity)

## Installation
1. **Prerequisites**:
   - Java 17 or later
   - Maven (for building)

2. **Build & Run**:
   ```bash
   mvn clean package
   java -cp target/classes main.Main
   ```

   For development in IDE:
   - Import as Maven project
   - Run `main.Main` class

## Usage Examples
### Console Mode
```
=== Cafeteria Menu ===
1. Select a cup
2. Make an Americano
3. Make a Cappuccino
...

Choose cup size:
1. Normal (200 ml)
2. Grande (250 ml)
3. Venti (400 ml)
Enter your choice: 1
Selected Normal cup (200 ml).
```

## System Architecture
- **Design Patterns**:
  - Factory: Cup creation
  - Decorator: Drink customization
  - Observer: Cup status monitoring
- **Package Structure**:
  - `main`: Entry point
  - `items`: Drink implementations
  - `models`: Cup model
  - `factories`: Cup factory
  - `observers`: Status observers

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

## Testing
Run unit tests with:
```bash
mvn test
```

## License
MIT License

Copyright (c) [year] [fullname]

Permission is hereby granted... (full license text)
