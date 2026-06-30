package arrays.binarysearch;

public class Q0153_FindMinimumInRotatedSortedArray {
    // 153. Find Minimum in Rotated Sorted Array - Medium
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    /* ------------------------------------------------------------
       | PATTERN:              Binary Search                    ✅|
       ------------------------------------------------------------
    /* ⭐ Temel Gözlem
            Rotated sorted array iki parçadan oluşur:
                [4,5,6,7] [0,1,2]

            Minimum eleman ikinci parçanın başıdır.
            Yani kırılma noktası: 7 -> 0

            Binary Search Fikri
            Şunu karşılaştırıyoruz:
                nums[mid] > nums[right]

            Eğer doğruysa:
                mid sol büyük parçadadır.
                minimum sağ taraftadır.

            O yüzden:
                left = mid + 1;

            Eğer:
                nums[mid] <= nums[right] ise:
                   mid sağ sorted parçadadır.
                   minimum mid veya solundadır.

            O yüzden: right = mid;
     */
    /*  Complexity
        Time :  O(log n)
        Space : O(1)
    */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;  // mid minimum olabilir. O yuzden mid - 1 degil
            }
        }

        return nums[left];
    }
    /*  Dry Run
         nums = [4,5,6,7,0,1,2]

         Başlangıç:

         index:  0 1 2 3 4 5 6
         nums:   4 5 6 7 0 1 2
                 L           R

         Mid:

         mid = 3
         nums[mid] = 7
         nums[right] = 2
         7 > 2

         Minimum sağ tarafta.

         left = mid + 1;
         index:  0 1 2 3 4 5 6
         nums:   4 5 6 7 0 1 2
                         L   R

         Mid:

         mid = 5
         nums[mid] = 1
         nums[right] = 2
         1 <= 2

         Minimum mid olabilir veya solda olabilir.

         right = mid;
         index:  0 1 2 3 4 5 6
         nums:   4 5 6 7 0 1 2
                         L R

         Mid:

         mid = 4
         nums[mid] = 0
         nums[right] = 1
         0 <= 1

         Minimum mid olabilir.

         right = mid;
         left = 4
         right = 4

         Cevap: return nums[left];
     */
}
