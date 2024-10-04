# Infinite Tic-Tac-Toe

Welcome to **Infinite Tic-Tac-Toe**, a unique twist on the classic game! In this version, players can alternate placing their marks on the board and revisit earlier moves, creating a dynamic and strategic gameplay experience.

## Table of Contents

- [Game Rules](#game-rules)
- [Gameplay Instructions](#gameplay-instructions)
- [How to Run](#how-to-run)

## Game Rules

1. **Players**: The game is played by two players, X and O, who take turns placing their marks on a 3x3 grid.
  
2. **Initial Moves**: Players take turns placing their respective marks (X or O) on the empty cells of the grid.

3. **Revisiting Moves**: After the first three moves, players can place their mark in the position of the oldest move they made. This adds a layer of strategy, as players must keep track of their previous placements.

4. **Winning Condition**: A player wins by placing three of their marks in a row, either horizontally, vertically, or diagonally.

5. **Resetting the Game**: Once a player wins, a message is displayed, and the game resets to allow for a new round of play.

## Gameplay Instructions

- Click on an empty cell in the grid to place your mark (X or O).
- After the third move, you can choose to place your mark where your oldest move was made.
- The background of the oldest move will be removed when you revisit it.
- The game will announce the winner and reset when a player achieves three in a row.

## How to Run

To run the game locally, follow these steps:

1. **Prerequisites**: Ensure you have Java installed on your machine. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Clone the Repository**:
    ```bash
    git clone https://github.com/Levisim0/infinite-tic-tac-toe.git
    cd infinite-tic-tac-toe
    ```

3. **Compile the Code**:
    ```bash
    javac InfiniteTicTacToe.java
    ```

4. **Run the Game**:
    ```bash
    java InfiniteTicTacToe
    ```



---

Enjoy your game of Infinite Tic-Tac-Toe!
