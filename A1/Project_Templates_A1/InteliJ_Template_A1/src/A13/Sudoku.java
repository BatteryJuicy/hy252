package A13;

import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.text.Normalizer;

public class Sudoku {
    public static void main(String[] args) {
        // Main method to manage user input and program execution
    }
}

class SudokuValidator {

    // (α) Method to check if the given board is valid according to Sudoku rules
    public static boolean isValidBoard(int[][] board) {

        boolean[] invRow = new boolean[board.length];
        boolean[] invCol = new boolean[board.length];
        boolean[] invBox = new boolean[board.length];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(invRow, false);
            Arrays.fill(invCol, false);
            Arrays.fill(invBox, false);

            for (int j = 0; j < board[0].length; j++) {

                //valid cell value check.
                if (board[i][j] > 9 || board[i][j] < 0) return false;

                //ignore 0 to not get nullPointerException below.
                if(board[i][j] == 0) {continue;}

                //checking if the number of the cell that corresponds to the appropriate inv-array index is true.
                //if it's true it means it has already been "seen" before so there is a duplicate in the row or column.
                if (invRow[board[i][j] - 1] || invCol[board[j][i] - 1]) return false;
                else{
                    invRow[board[i][j] - 1] = true;
                    invCol[board[j][i] - 1] = true;
                }

                if(invBox[board[i%3 + 3*(j%3)][i/3 + 3*(j/3)] - 1])return false;
                else{
                    invBox[board[i][j] - 1] = true;
                }
            }
        }
        return false;
    }

    // (β) Method to check if the board is solvable using the backtracking algorithm
    public static boolean isSolvableBoard(int[][] board) {
        return false;
    }
}

class SudokuGenerator {

    // (γ) Method to create a Sudoku board with X empty cells and randomly filled remaining cells
    public static int[][] generateBoard(int emptyCells) {
        // Implement the logic to generate a Sudoku board with empty cells

        // Placeholder: return a dummy board until logic is implemented
        return new int[9][9];  // Replace this with the actual logic to generate the board
    }

    // (δ) Method to create N valid Sudoku puzzles and their solutions
    public static void generateValidBoards(int N, int emptyCells) {

    }
}
