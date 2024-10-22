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
        int[][] board = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        System.out.println(SudokuValidator.isSolvableBoard(board));
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

                //ignore 0 to not get nullPointerException below.
                if(board[i][j] == 0 || board[j][i] == 0 || board[j%3 + 3*(i%3)][j/3 + 3*(i/3)] == 0) {continue;}

                //checking if the number of the cell that corresponds to the appropriate inv-array index is true.
                //if it's true it means it has already been "seen" before so there is a duplicate in the row or column.
                if (invRow[board[i][j] - 1] || invCol[board[j][i] - 1]) return false;
                else{
                    invRow[board[i][j] - 1] = true;
                    invCol[board[j][i] - 1] = true;
                }

                //if(invBox[board[i%3 + 3*(j%3)][i/3 + 3*(j/3)] - 1])return false;
                if(invBox[board[j%3 + 3*(i%3)][j/3 + 3*(i/3)] - 1])return false;
                else{
                    invBox[board[j%3 + 3*(i%3)][j/3 + 3*(i/3)] - 1] = true;
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
