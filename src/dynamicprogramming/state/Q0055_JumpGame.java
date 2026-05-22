package dynamicprogramming.state;

public class Q0055_JumpGame {
    // 55. Jump Game - Medium
    // https://leetcode.com/problems/jump-game/

    /*  -----------------------------------------------
        | PATTERN: Greedy - DP ile de cozulur.        |
        -----------------------------------------------
         Reachability + farthest reachable
    */

    /* Complexity
        Time: O(n)
        Space: O(1)
    */
    public static boolean jumpGame(int[] nums) {
        int farthest = 0;  //  şu ana kadar ulaşabileceğim en uzak index

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) { // bu index’e ulaşamıyoruz demektir.
                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);

            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
