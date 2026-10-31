package cyclicsort;

import java.util.*;

public class Q0287_FindTheDuplicateNumber {
    // 287. Find the Duplicate Number - Medium
    // https://leetcode.com/problems/find-the-duplicate-number/

    /* ------------------------------------------------------------
       | PATTERN: Fast & Slow Pointers - Floyd cycle detection
       ------------------------------------------------------------
       i -> nums[i] kenarlarıyla bir "linked list" düşün; tekrar eden sayı, iki indeksin aynı yere işaret etmesi demek,
       yani döngünün girişi. Önce slow (1 adım) ve fast (2 adım) buluşana kadar ilerle; sonra slow'u başa al
       ve ikisini birer adım ilerlet, buluştukları yer cevap. Diziyi değiştirmez, O(1) bellek.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int findDuplicate(int[] nums) {
        // i -> nums[i] kenarlarıyla oluşan "linked list"te tekrar eden sayı döngünün girişidir.
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
