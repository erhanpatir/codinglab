package arrays.binarysearch;

public class Q0278_FirstBadVersion {
    // 278. First Bad Version - Easy
    // https://leetcode.com/problems/first-bad-version/
    /* ------------------------------------------------------------
       | PATTERN:   Binary Search (Find First True)             ✅|
       ------------------------------------------------------------
    /* ⭐ En Kritik İnvariant
            Loop boyunca:
                left tarafı
                    kesinlikle FALSE
                right tarafı
                    olası FIRST TRUE

            Loop sonunda: right < left olur.

            Ve: left, ilk true'nun olduğu yere oturur.
     */
    /*  Complexity
        Time : O(n log n)
        Space : O(1)
    */
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
        /* Neden?
           Çünkü: left, ilk TRUE üzerinde kalır.
        */
    }

    private static boolean isBadVersion(int version) {
        return true;
    }
}
