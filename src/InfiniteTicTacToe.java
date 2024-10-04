import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InfiniteTicTacToe extends JFrame {

    private static final int BOARD_SIZE = 3;
    private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
    private ArrayList<int[]> moveHistoryX = new ArrayList<>();
    private ArrayList<int[]> moveHistoryO = new ArrayList<>();
    private char currentPlayer = 'X';
    private int moveCountX = 0;
    private int moveCountO = 0;

    public InfiniteTicTacToe() {
        setTitle("Infinite Tic-Tac-Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        gamePanel.setBackground(Color.BLACK);

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                buttons[i][j] = new JButton("-");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setBackground(Color.BLACK);
                buttons[i][j].setForeground(Color.WHITE);
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(row, col);
                    }
                });
                gamePanel.add(buttons[i][j]);
            }
        }

        add(gamePanel);
    }

    private void handleButtonClick(int row, int col) {
        if (buttons[row][col].getText().equals("-")) {
            buttons[row][col].setText(String.valueOf(currentPlayer));
            if (currentPlayer == 'X') {
                buttons[row][col].setForeground(Color.CYAN);
                handleMove(row, col, moveHistoryX, ++moveCountX);
            } else {
                buttons[row][col].setForeground(Color.MAGENTA);
                handleMove(row, col, moveHistoryO, ++moveCountO);
            }

            buttons[row][col].setBackground(Color.DARK_GRAY);

            if (checkForWin()) {
                JOptionPane.showMessageDialog(this, "Congrats! " + currentPlayer + " wins!");
                resetBoard();
            } else {
                switchPlayer();
            }
        }
    }

    private void handleMove(int row, int col, ArrayList<int[]> moveHistory, int moveCount) {
        if (moveCount > 3 && moveHistory.size() > 0) {
            int[] oldestMove = moveHistory.remove(0);
            buttons[oldestMove[0]][oldestMove[1]].setText("-");
            buttons[oldestMove[0]][oldestMove[1]].setBackground(null);
            buttons[oldestMove[0]][oldestMove[1]].setForeground(Color.WHITE);
        }

        if (moveHistory.size() > 0) {
            int[] lastMove = moveHistory.get(moveHistory.size() - 1);
            buttons[lastMove[0]][lastMove[1]].setBackground(Color.BLACK);
            buttons[lastMove[0]][lastMove[1]].setForeground(currentPlayer == 'X' ? Color.CYAN : Color.MAGENTA);
        }

        moveHistory.add(new int[]{row, col});
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkForWin() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }
        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        return false;
    }

    private void resetBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                buttons[i][j].setText("-");
                buttons[i][j].setBackground(Color.BLACK);
                buttons[i][j].setForeground(Color.WHITE);
            }
        }
        moveHistoryX.clear();
        moveHistoryO.clear();
        moveCountX = 0;
        moveCountO = 0;
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InfiniteTicTacToe().setVisible(true);
            }
        });
    }
}
