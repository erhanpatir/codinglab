package arrays.twopointers;

public class Q0027_RemoveElement {
    // 27. Remove Element - Easy
    // https://leetcode.com/problems/remove-element/
    // -------------------------------------------------------------
    // |PATTERN: Slow / Fast Pointer Overwrite                   ✅|
    // -------------------------------------------------------------
    /*
        fast -> array'i gezer
        slow -> val olmayan elemanın yazılacağı yer

        Eğer:
            nums[fast] != val ise bu elemanı tutmalıyız:
            nums[slow] = nums[fast];
            slow++;

        3. State / Invariant
        Invariant:
            nums[0 ... slow-1] her zaman val olmayan ve korunması gereken elemanları içerir.
            fast ise tüm array’i tarar.
    */
    /*
        Complexity Analysis
            Time: O(n)
            Space: O(1)
    */
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;


    }
}
