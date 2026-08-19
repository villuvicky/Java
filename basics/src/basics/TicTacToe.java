package basics;

import java.util.Scanner;

/*
 * Q1: Implement a console-based two-player Tic-Tac-Toe game on a 3x3
 * board. Players alternate entering a row and column (0-2) to place
 * their mark ('X' or 'O'); the game detects a win (3 in a row across
 * any row, column, or diagonal), detects a draw (board full with no
 * winner), rejects invalid/occupied moves, and switches turns after
 * every valid move.
 *
 * NOTE ON DESIGN — STATIC SHARED STATE: "board" and "currentPlayer" are
 * both declared as STATIC fields at the class level, rather than as
 * instance fields or local variables passed between methods. This works
 * fine for a single console game with one Scanner loop, but it means
 * there can only ever be ONE game/board in memory at a time — you
 * couldn't easily create two independent TicTacToe games running side
 * by side without restructuring this into an instance-based class (with
 * board/currentPlayer as instance fields, and a constructor). This
 * static-everywhere style is common in small procedural console
 * programs but becomes limiting as soon as you need multiple
 * independent instances.
 *
 * IMPORTANT NOTE ON ORDER OF OPERATIONS: checkWin() is called
 * IMMEDIATELY after placing the mark (board[row][col] = currentPlayer)
 * but BEFORE switchPlayer() runs. This ordering is essential — checkWin()
 * checks for 3-in-a-row belonging to "currentPlayer", so it must run
 * while "currentPlayer" still refers to the player who just moved. If
 * switchPlayer() were called first, checkWin() would incorrectly check
 * for a win using the NEXT player's mark instead of the one that was
 * just placed.
 *
 * NOTE: isBoardFull() is only checked AFTER confirming there's no win,
 * so a full board with a winning line on the very last move is
 * correctly reported as a win, not a draw.
 */
public class TicTacToe {

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;

        printBoard();

        while (!gameOver) {
            System.out.println("Player " + currentPlayer + ", enter row and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                // checkWin() must run BEFORE switchPlayer() (see note above)
                if (checkWin()) {
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    System.out.println("🤝 It's a draw!");
                    gameOver = true;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("❌ Invalid move. Try again.");
            }
        }
        sc.close();
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static boolean isValidMove(int row, int col) {
        // must be within bounds AND the target cell must be empty
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == ' ';
    }

    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    static boolean checkWin() {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer)
                return true;
        }

        // Diagonals
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}