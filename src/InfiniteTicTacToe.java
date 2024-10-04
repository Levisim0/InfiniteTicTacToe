import java.util.ArrayList;
import java.util.Scanner;

public class InfiniteTicTacToe {

    private static final int BOARD_SIZE = 3;
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static ArrayList<int[]> moveHistory = new ArrayList<>(); // Store the history of moves
    private static char currentPlayer = 'X';  // Start with player 'X'

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        int moveCount = 0;
        boolean gameWon = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameWon) {
            // Get player input
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Enter row and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Validate move
            if (row < 0 || col < 0 || row >= BOARD_SIZE || col >= BOARD_SIZE) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            // Place mark or replace the oldest move if 3 moves already made
            if (moveCount < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                moveHistory.add(new int[]{row, col});
            } else if (moveCount >= 3) {
                // Replace oldest move
                int[] oldMove = moveHistory.get(0); // Get the first move
                if (board[oldMove[0]][oldMove[1]] == currentPlayer) {
                    board[oldMove[0]][oldMove[1]] = '-';  // Clear the old move
                    moveHistory.remove(0);  // Remove the oldest move from history
                    board[row][col] = currentPlayer;
                    moveHistory.add(new int[]{row, col});
                } else {
                    System.out.println("You can only replace your own previous move.");
                    continue;
                }
            } else {
                System.out.println("Position already taken. Try again.");
                continue;
            }

            moveCount++;
            printBoard();

            // Check for win
            gameWon = checkForWin();
            if (!gameWon) {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        System.out.println("Player " + currentPlayer + " wins!");
    }

    // Initialize the board with dashes
    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the current board
    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if the current player has won
    private static boolean checkForWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }
}
