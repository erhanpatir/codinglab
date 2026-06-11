package arrays.twopointers;


public class Q0283_MoveZeroes {
    // LeetCode 283 - Move Zeroes - Easy
    // https://leetcode.com/problems/move-zeroes/
    /*
        Bu soru aslında:
            27 - Remove Element sorusunun neredeyse aynısı.

        Burada:
            val = 0 silmek istiyoruz.
            Sonra kalan kısmı sıfırlarla dolduruyoruz.

        3. State / Invariant
        State:
            slow
            fast

        Invariant:
            nums[0 ... slow-1] her zaman sıfır olmayan elemanları doğru sırayla içerir.
            fast array'i tarar.
    */
    /*
        Complexity Analysis
        Time: O(n),
        Space: O(1), array in-place
    */
    public static void moveZeroes(int[] nums) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
    /* 4. Dry Run

        Input: [0,1,0,3,12]

        Başlangıç:
            slow = 0

        fast = 0
            nums[0] = 0 Skip.
            slow = 0

        fast = 1
            nums[1] = 1

        Kopyala:
            nums[0] = 1
            slow = 1

        Array: [1,1,0,3,12]

        fast = 2
            0 Skip.

        fast = 3
            3
            nums[1] = 3
            slow = 2

        Array: [1,3,0,3,12]

        fast = 4
            12
            nums[2] = 12
            slow = 3

        Array: [1,3,12,3,12]

        Tarama bitti.

        Şimdi:
            slow = 3

        sonrasını sıfırla doldur.
            nums[3] = 0
            nums[4] = 0

        Final: [1,3,12,0,0]
        */
}
