package arrays.hashing;

public class Q0238_ProductOfArrayExceptSelf {
    // 238. Product of Array Except Self - Medium
    // https://leetcode.com/problems/product-of-array-except-self/

    // ------------------------------------------------------
    // | PATTERN: Prefix Product + Suffix Product           |
    // ------------------------------------------------------
    /*
        Bir index’in sonucu şudur:
            solundaki sayıların çarpımı * sağındaki sayıların çarpımı
        Örnek:
            nums = [1,2,3,4]
        Index 2 için:
            left product  = 1 * 2 = 2
            right product = 4
            answer = 2 * 4 = 8
        Yani:
            answer[i] = product of elements before i * product of elements after i
    */
    /*
        Time: O(n)
        Space: O(1) extra
    */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n]; // prefix storage olarak kullanıyoruz.

        int leftProduct = 1; // current index’in solundaki tüm elemanların çarpımını tutar.

        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;  // current index’in sağındaki tüm elemanların çarpımını tutar.

        for (int i = n - 1; i>= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }
}
