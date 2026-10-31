package simulation;

import java.util.*;

public class Q0058_LengthOfLastWord {
    // 58. Length of Last Word - Easy
    // https://leetcode.com/problems/length-of-last-word/

    /* ------------------------------------------------------------
       | PATTERN: String - sondan gezme
       ------------------------------------------------------------
       Sondaki boşlukları atla, sonra boşluk görene kadar geriye doğru say.
       Split kullanmadan tek geçişte çözülür.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            --i;
        }
        int j = i;
        while (j >= 0 && s.charAt(j) != ' ') {
            --j;
        }
        return i - j;
    }
}
