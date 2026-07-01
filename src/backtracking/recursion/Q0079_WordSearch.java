package backtracking.recursion;

public class Q0079_WordSearch {
    // 79. Word Search - Medium
    // https://leetcode.com/problems/word-search/description/

    // 🔥 Pattern: 👉 grid + DFS + backtracking + visited

    /* ⏱️ Complexity
            Time
            Worst-case:
                O(m * n * 4^L)
                m*n → başlangıç noktaları
                4^L → her adımda 4 direction
            Space
                O(L)

            recursion depth (kelime uzunluğu)
    */

    /*
        board = [["A","B","C","E"],
                 ["S","F","C","S"],
                 ["A","D","E","E"]],
        word = "ABCCED"
    */
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board,
                               String word,
                               int i,
                               int j,
                               int index) { // word içinde kaçıncı karakterdesin ?
        if (index == word.length()) { // base case
            return true;
        }

        if (i < 0 || j < 0 ||
                i >= board.length || j >= board[0].length ||
                board[i][j] != word.charAt(index)) { // boundary + mismatch
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // visited

        boolean found =
                dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // undo

        return found;
    }
}
