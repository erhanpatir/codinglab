package hashing;

import java.util.stream.*;
import java.util.*;

public class Q0349_IntersectionOfTwoArrays {
    // 349. Intersection of Two Arrays - Easy
    // https://leetcode.com/problems/intersection-of-two-arrays/description/

    /* ------------------------------------------------------------
       | PATTERN: Hash Set
       ------------------------------------------------------------
       İlk diziyi set'e koy. İkinci dizide set'te olan elemanları sonuca ekle ve
       tekrar eklenmesin diye set'ten sil.
    */
    /*  Complexity
        Time  : O(n + m)
        Space : O(n)
    */

    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean[] s = new boolean[1001];
        for (int x : nums1) {
            s[x] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : nums2) {
            if (s[x]) {
                ans.add(x);
                s[x] = false;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
