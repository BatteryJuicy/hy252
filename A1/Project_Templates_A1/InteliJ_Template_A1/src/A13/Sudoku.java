package A13;

import java.util.Random;
import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
        // Main method to manage user input and program execution
        long timeI = System.currentTimeMillis();
        SudokuGenerator.generateValidBoards(1, 65);
        long timeF = System.currentTimeMillis();
        System.out.println("Execution Time: " + (timeF - timeI)/1000.0 + " seconds");
    }
}

class SudokuValidator {

    // (α) Method to check if the given board is valid according to Sudoku rules
    public static boolean isValidBoard(int[][] board) {

        boolean[] invRow = new boolean[9];
        boolean[] invCol = new boolean[9];
        boolean[] invBox = new boolean[9];

        for (int i = 0; i < 9; i++) {
            Arrays.fill(invRow, false);
            Arrays.fill(invCol, false);
            Arrays.fill(invBox, false);

            for (int j = 0; j < 9; j++) {

                //valid cell value check.
                if (board[i][j] > 9 || board[i][j] < 0) return false;

                int boxElement = board[j/3 + 3*(i/3)][j%3 + 3*(i%3)];

                //ignore 0 to not get nullPointerException below. Then:
                //checking if the number of the cell that corresponds to the appropriate inv-array index is true.
                //if it's true it means it has already been "seen" before so there is a duplicate in the row or column.
                if(board[i][j] != 0) {
                    if(invRow[board[i][j] - 1]) return false;
                    invRow[board[i][j] - 1] = true;
                }
                if (board[j][i] != 0) {
                    if (invCol[board[j][i] - 1]) return false;
                    invCol[board[j][i] - 1] = true;
                }

                if (boxElement != 0) {
                    if(invBox[boxElement - 1]) return false;
                    invBox[boxElement - 1] = true;
                }
            }
        }
        return true;
    }

    // (β) Method to check if the board is solvable using the backtracking algorithm
    public static boolean isSolvableBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        board[i][j] = num;
                        if(isValidBoard(board) && isSolvableBoard(board)) {
                            return true;
                        }
                        board[i][j] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}

class SudokuGenerator {

    // (γ) Method to create a Sudoku board with X empty cells and randomly filled remaining cells
    public static int[][] generateBoard(int emptyCells) {
        // Implement the logic to generate a Sudoku board with empty cells
        int remaining = 81 - emptyCells;
        int[][] result = new int[9][9];
        Random rand = new Random();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = 0;
            }
        }

        for (int i = 0; i < remaining; i++) {
            int randRow = rand.nextInt(9);
            int randCol = rand.nextInt(9);
            if (result[randRow][randCol] == 0) {
                result[randRow][randCol] = rand.nextInt(1, 10);
            }
            else remaining++;
        }
        return result;
    }

    // (δ) Method to create N valid Sudoku puzzles and their solutions
    public static void generateValidBoards(int N, int emptyCells) {
        int invalidBoardCount = 0;
        int unsolvableBoardCount = 0;

        boolean isValid;
        boolean isSolvable;

        System.out.println("N: " + N + "\nX: " + emptyCells);

        for (int i = 0; i < N; i++) {

            int[][] board;
            int[][] tempBoard = new int[9][9];

            do {
                board = generateBoard(emptyCells);
                for (int j = 0; j < 9; j++) {
                    tempBoard[j] = Arrays.copyOf(board[j], 9);
                }

                isValid = SudokuValidator.isValidBoard(board);
                isSolvable = SudokuValidator.isSolvableBoard(board);
                if (!isValid) invalidBoardCount++;
                if (!isSolvable) unsolvableBoardCount++;

            } while (!isValid || !isSolvable);

            System.out.println("Board #" + (i+1));
            printBoard(tempBoard);
            System.out.println("Solution of the Board #" + (i+1));
            printBoard(board);
            System.out.println();
        }
        System.out.println("empty cells per board: " + emptyCells);
        System.out.println("valid boards created: " + N);
        System.out.println("invalid board count: " + invalidBoardCount);
        System.out.println("unsolvable board count: " + unsolvableBoardCount);
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
