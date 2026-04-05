# Gemini Code Understanding

## Project Overview

This project is a Java-based chess game designed to be played in the console. It serves as an educational tool to demonstrate fundamental software design principles, such as object-oriented design, modularity, and scalability. The project is built using Java and Gradle, with JUnit and Mockito for testing.

The architecture follows a Model-View-Controller (MVC) pattern, where:

*   **Model:** Represents the game's data and business logic, including the chessboard, pieces, and game rules. Key classes include `Board`, `Piece`, and `Game`.
*   **View:** Handles the presentation of the game to the user. The current implementation uses a `ConsoleView` to display the game in the terminal.
*   **Controller:** Manages the interaction between the user and the game, processing user input and updating the model and view accordingly.

## Building and Running

The project uses Gradle as its build tool.

### Building the Project

To build the project, run the following command in the root directory:

```bash
./gradlew build
```

### Running the Project

To run the chess game, execute the `Standalone` class:

```bash
./gradlew run
```

Alternatively, you can run the main method in `src/main/java/org/citadel/Standalone.java`.

### Running Tests

To run the tests, use the following command:

```bash
./gradlew test
```

## Development Conventions

### Coding Style

The project follows standard Java coding conventions. Key aspects include:

*   **Naming:** Class names are in `PascalCase`, while method and variable names are in `camelCase`.
*   **Formatting:** The code is well-formatted with consistent indentation and spacing.
*   **Comments:** Javadoc comments are used to document the public API.

### Testing

The project uses JUnit and Mockito for testing. Tests are located in the `src/test/java` directory. The tests cover the core logic of the game, including piece movements and game rules.

### Dependencies

The project has the following dependencies:

*   **JUnit:** A testing framework for Java.
*   **Mockito:** A mocking framework for Java.
*   **Kotlin:** The Kotlin standard library.
