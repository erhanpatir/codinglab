package arrays.binarysearch;

public class Q0162_FindPeakElement {
    // 162. Find Peak Element - Medium
    // https://leetcode.com/problems/find-peak-element/
    /* ------------------------------------------------------------
       | PATTERN:        Binary Search                          ✅|
       ------------------------------------------------------------
    /* ⭐ Binary Search Fikri
            Burada sorted array yok.
            Ama local slope var:
                nums[mid] < nums[mid + 1] ise sağ taraf yukarı gidiyor demektir.

            Bu durumda sağ tarafta kesin bir peak vardır.

                ... mid   mid+1 ...
                     3  <   5

            Çünkü ya artmaya devam eder ve en sonda -∞’ye düşerken peak oluşur,
            ya da bir yerde düşmeye başlar ve orası peak olur.

            --------------- Ana Kural --------------
                if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            ----------------------------------------
            Dikkat: right = mid;
            çünkü mid peak olabilir.
     */
    /*  Complexity
        Time : O(log n)
        Space : O(1)
    */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        /* Neden while (left < right)?
        ----------------------------------
            Çünkü nums[mid + 1] kullanıyoruz.
            Eğer left <= right yapsaydık, mid son index olabilir ve:
                nums[mid + 1]
            out of bounds olurdu.

            left < right sayesinde mid < right, yani mid + 1 güvenli.
        */
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;  // Sağ tarafta peak var.
            } else {
                right = mid;     // Sol/şu anki tarafta peak var.
            }
        }
        return left;
    }
}

