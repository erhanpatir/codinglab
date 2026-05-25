package arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class Q0217_ContainsDuplicate {
    // 217. Contains Duplicate - Easy
    // https://leetcode.com/problems/contains-duplicate/

    // ------------------------------------------------------
    // | PATTERN: Hashing                                    |
    // ------------------------------------------------------
    /* 2. Optimal Pattern

        ***** Seen Set Pattern *****
        Aslında soru şunu soruyor:
            “Bu elemanı daha önce gördün mü?”

        Bu cümleyi duyunca:
            HashSet
        alarmı çalmalı.

        Çünkü set:
            contains() işlemini O(1) yapar.
    */
    /*
        Time: O(n)
        Space: O(n)
    */
    public static boolean containsDuplicate(int[] nums) {
        // I use a HashSet to track previously seen numbers.
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}
