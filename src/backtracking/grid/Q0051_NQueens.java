package backtracking.grid;

import java.util.*;

public class Q0051_NQueens {
    // 51. N-Queens - Hard
    // https://leetcode.com/problems/n-queens/description/
    // PATTERN: Backtracking - constraint-based placement

    /* Time:  O(n!)
        Neden?
            ilk row’da n
            sonra yaklaşık n-1
            sonra n-2
            ...

            Diagonal kısıtları pratikte daha da azaltır.
            Output kopyalama maliyeti de var ama mülakatta genelde O(n!) demek yeterli.

       Space: O(n^2)
           Auxiliary:
             recursion depth: O(n)
             sets: O(n)
             board: O(n^2)
       */

    /* 🧠 Amaç
        Şunu hızlı kontrol etmek istiyoruz:
        “(row, col) hücresine queen koyarsam, başka bir queen ile çapraz çakışır mı?”
        Bunu O(n) taramak yerine O(1) yapmak istiyoruz.

        📌 Ana diagonal (↘)
            Tüm bu hücreler aynı diagonalde:
            (0,0)
            (1,1)
            (2,2)
            (3,3)

            Bunların ortak özelliği:
            row - col = 0

        📌 Başka bir diagonal
            (0,1)
            (1,2)
            (2,3)
            row - col = -1

        🔥 KURAL 1
        👉 Aynı ana diagonalde olan hücreler için:
            row - col sabittir

        🧠 Anti-diagonal (↙)
            Şimdi diğer yön:
            (0,3)
            (1,2)
            (2,1)
            (3,0)

            Bunların ortak özelliği:
            row + col = 3

        🔥 KURAL 2
        👉 Aynı anti-diagonalde olan hücreler için:
            row + col sabittir

        🎯 Özet
              Tip	                 Formül
            diagonal ↘	            row - col
            anti-diagonal ↙	        row + col
    */

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        /* 🔥 Neden set kullanıyoruz?

            Çünkü:
                👉 “bu diagonal daha önce dolu mu?”
                👉 O(1) kontrol etmek istiyoruz
        */
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();      // row - col
        Set<Integer> antiDiagonals = new HashSet<>();  // row + col

        backtrack(0, n, board, cols, diagonals, antiDiagonals, result);
        return result;
    }

    private static void backtrack(int row,
                                  int n,
                                  char[][] board,
                                  Set<Integer> cols,
                                  Set<Integer> diagonals,
                                  Set<Integer> antiDiagonals,
                                  List<List<String>> result) {
        if (row == n) { // 0..n-1 tüm satırlara queen koydum
            result.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) { // bu satırda hangi sütuna queen koyabilirim ?
            int diagonal = row - col;
            int antiDiagonal = row + col;

            if (cols.contains(col) ||
                diagonals.contains(diagonal) ||
                antiDiagonals.contains(antiDiagonal)) { // Şu sütun ya da diagonal doluysa koyamayız.
                continue;
            }

            // place queen
            board[row][col] = 'Q';
            cols.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);

            // recurse
            backtrack(row + 1, n, board, cols, diagonals, antiDiagonals, result);

            // remove queen
            board[row][col] = '.';
            cols.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
        }
    }

    private static List<String> buildBoard(char[][] board) {
        List<String> state = new ArrayList<>();
        for (char[] row : board) {
            state.add(new String(row));
        }
        return state;
    }
}
