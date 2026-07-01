package arrays.matrix;

import java.util.HashSet;
import java.util.Set;

public class Q0036_ValidSudoku {
    // 36. Valid Sudoku - Medium
    // https://leetcode.com/problems/valid-sudoku/description/

    // ------------------------------------------------------
    // | PATTERN: Constraint tracking with HashSet          |
    // ------------------------------------------------------
    /*
        Her dolu hücre için 3 constraint oluştururuz:
            row constraint
            column constraint
            box constraint

        Mesela 5, row 0, column 1 içindeyse:
            row: 5 in row 0
            column: 5 in column 1
            box: 5 in box 0-0

        Bunlardan biri daha önce görüldüyse Sudoku invalid.

        3. State / Invariant
        State:
            Set<String> seen

        Invariant:
            seen, şu ana kadar gördüğümüz bütün row/column/box constraintlerini tutar.
        Aynı constraint ikinci kez oluşursa:
            duplicate vardır -> false

        Box index hesabı:
            row / 3
            col / 3
        Örnek:
            row = 4, col = 7
            box = 1,2
        Çünkü:
            4 / 3 = 1
            7 / 3 = 2
    */
    /*
        Time: O(n²)
        Space: O(n²)

        Ama Interview’da Neden Genelde O(1) Deniyor?

        Çünkü classic Sudoku:
            9x9 fixed size
        Board büyümüyor.
        Yani:
            81 işlem
            243 constraint
        hep sabit.
        Bu yüzden practical complexity:
            Time: O(1)
            Space: O(1)
    */
    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>(); // tracking constraints

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                if (value == '.') continue;

                String rowKey = value + " in row " + row;
                String colKey = value + " in col " + col;
                String boxKey = value + " in box " + row / 3 + "-" + col / 3;

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false; // duplicate constraint
                }
            }
        }
        return true;
    }
}
