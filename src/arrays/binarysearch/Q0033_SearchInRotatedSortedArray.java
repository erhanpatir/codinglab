package arrays.binarysearch;

public class Q0033_SearchInRotatedSortedArray {
    // 33. Search in Rotated Sorted Array - Medium
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    /* ------------------------------------------------------------
       | PATTERN:              Binary Search                    ✅|
       ------------------------------------------------------------
    /* ⭐ Ana Fikir
            Rotated array’de her adımda en az bir taraf sorted olur.
            Örnek:

                [4,5,6,7,0,1,2]
                 L     M     R

            left..mid tarafı sorted : [4,5,6,7]

            Diğer örnek:

                [6,7,0,1,2,4,5]
                 L     M     R

            mid..right tarafı sorted : [1,2,4,5]
          -----------------------------------------------------
          |  Her adımda:                                      |
          |  - Sol taraf sorted mı?                           |
          |  - Target bu sorted tarafın içinde mi?            |
          |  - İçindeyse oraya git, değilse diğer tarafa git. |
          -----------------------------------------------------
            Karar Mantığı
            Sol taraf sorted mı?
                if (nums[left] <= nums[mid])

            Evetse target sol tarafta mı?
                if (nums[left] <= target && target < nums[mid])
                    Evet: right = mid - 1;
                    Hayır: left = mid + 1;

            Sağ taraf sorted ise:

            else
            Target sağ tarafta mı?
                if (nums[mid] < target && target <= nums[right])
                    Evet: left = mid + 1;
                    Hayır: right = mid - 1;
     */
    /*  Complexity
        Time : O(log nn)
        Space : O(1)
    */
    public static int search(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    /* Dry Run
        nums = [4,5,6,7,0,1,2]
        target = 0

        Başlangıç:

            index:  0 1 2 3 4 5 6
            nums:   4 5 6 7 0 1 2
                    L     M     R
            nums[left] = 4
        nums[mid] = 7

        Sol taraf sorted:

            [4,5,6,7]

        Target sol tarafta mı?

            4 <= 0 < 7  → false

        O zaman sağa git:
            left = mid + 1;

        Yeni alan:

        index:  4 5 6
        nums:   0 1 2
                L M R

        Mid:
            nums[mid] = 1

        Sol taraf sorted:

        [0,1]

        Target sol tarafta mı?

        0 <= 0 < 1 → true

        Sola git:

        right = mid - 1;

        Yeni alan:

        index:  4
        nums:   0
                L/R

        Mid: nums[mid] = 0

        Bulduk: return 4;
    */
}
