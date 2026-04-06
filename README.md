# Todo Java App

A desktop todo application built with Java Swing, following an MVC architecture.

## Requirements

- Java 21
- Maven

## Run

```bash
mvn compile exec:java -Dexec.mainClass="org.astronity.Main"
```

Or open in IntelliJ IDEA and run `Main.java`.

## Project Structure

```
src/main/java/org/astronity/
├── Main.java                        # Entry point
├── config/NavigationRouter.java
├── controller/
│   ├── controllers/LoginController.java
│   └── router/ScreenRouter.java
├── shared/constants/AppConstants.java
└── view/
    ├── components/PrimaryButton.java
    └── screens/
        ├── MainFrame.java
        ├── LoginPanel.java
        └── DashboardPanel.java
```

## Demo Login

Any email and password combination works (no real authentication yet).
