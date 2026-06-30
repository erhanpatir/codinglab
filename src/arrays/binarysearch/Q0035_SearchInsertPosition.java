package arrays.binarysearch;

public class Q0035_SearchInsertPosition {
    // 35. Search Insert Position - Easy
    // https://leetcode.com/problems/search-insert-position/
    /* ------------------------------------------------------------
       | PATTERN:        Binary Search.                         ✅|
       ------------------------------------------------------------
    /* ⭐ Bu soru aslında:
        İlk kez target'a eşit veya büyük olan elemanı bul.
        Yani:
            nums[i] >= target
        şartını sağlayan ilk index.

        Bu çok önemli.

        Çünkü ileride göreceğimiz:
            Lower Bound
            Upper Bound
            First Occurrence
            Last Occurrence
            First Bad Version sorularının hepsi bunun türevi.

        ⭐ Kritik Nokta
            Loop sonunda: left
            target'ın olması gereken pozisyonu gösterir.
            Bu yüzden: return left; yapıyoruz.
     */
    /*  Complexity
        Time : O(n log n)
        Space : O(1)
    */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
        /* Neden?
           Çünkü: left, ilk TRUE üzerinde kalır.
        */
    }
}
