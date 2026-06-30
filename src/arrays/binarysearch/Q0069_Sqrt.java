package arrays.binarysearch;

public class Q0069_Sqrt {
    // 69. Sqrt(x) - Easy
    // https://leetcode.com/problems/sqrtx/
    /* ------------------------------------------------------------
       | PATTERN:       Binary Search (Find Last True)          ✅|
       ------------------------------------------------------------
    /* ⭐  Binary Search on Value Space

            Kritik İnvariant
            278'de:
                return left diyorduk.

            Çünkü: FFFFTTTT  ve left = first true oluyordu.

            Burada: TTTTFFFF ve right = last true oluyor.
     */
    /*  Complexity
        Time  : O(n log n)
        Space : O(1)
    */
    public static int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            /* Overflow Tuzağı
                Burası interview'da önemli.
                Şunu yaparsan: mid * mid
                    overflow olabilir.

                Örneğin: 46341 * 46341 Integer sınırını geçer.
                (long) mid * mid olabilir.
            */
            if (mid <= x / mid) {  // overflow riski yok
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
        /*
            Neden?
                Çünkü: right son TRUE üzerinde kalır.
        */
    }
}
