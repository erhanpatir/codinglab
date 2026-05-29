package arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class Q0202_HappyNumber {
    // 202. Happy Number - Easy
    // https://leetcode.com/problems/happy-number/

    // -------------------------------------------------------------------------------
    // |PATTERN: Floyd’s cycle detection - Fast & Slow Pointer (Tortoise and Hare) ✅|
    // -------------------------------------------------------------------------------
    /* More space-optimized solution

       Steps:
        Initialize slow and fast pointers both to the original number.
        Compute the next number for the slow pointer (one step) and for the fast pointer (two steps).
        If fast pointer reaches 1, return true.
        If slow equals fast and they are not 1, a cycle is detected, return false.
        Repeat these steps until a conclusion is reached.
    */
    /*
        Time: O(log n)
        Space: O(1)
    */
    public static boolean isHappy_2(int n) {
        int slow = n;
        int fast = getNext(n);

        // Eger slow ve fast birbirine esit olursa, cycle var demektir.
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    /* Solution: HashSet cycle detection ✅
      Eğer bir sayı tekrar görülürse, aynı hesaplar tekrar eder. Buna cycle denir.

      Complexity Analysis
        Time:  O(log n)
        Space: O(log n)
            Çünkü digit processing her step için digit sayısına bağlıdır.
    */
    public static boolean isHappy(int n) {
        // seen, daha önce üretilmiş sayıları tutar.
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);
            n = getNext(n);
        }
        return true;
    }

    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
