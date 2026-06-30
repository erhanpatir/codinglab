package hashing;

import java.util.HashSet;
import java.util.Set;

public class Q0128_LongestConsecutiveSequence {
    // 128. Longest Consecutive Sequence - Medium
    // https://leetcode.com/problems/longest-consecutive-sequence/

    // ------------------------------------------------------
    // | PATTERN: HashSet + Sequence Start Detection        |
    // ------------------------------------------------------
    /*
        Önce tüm sayıları HashSet’e koyarız.
        Sonra her sayı için şunu kontrol ederiz:
            num - 1 var mı?
        Eğer varsa, bu sayı sequence başlangıcı değildir.
        Eğer yoksa, bu sayı yeni bir sequence başlangıcıdır.
        -----------------------------------------------------------------
        Örnek:
            nums = [100,4,200,1,3,2]
        Set:
            {100,4,200,1,3,2}

        1 için:
            1 - 1 = 0 yok
        Demek ki 1 başlangıç.
        Sonra say:
            1,2,3,4
        uzunluk 4.
        2, 3, 4 için sequence başlatmayız çünkü sol taraflarında önceki sayı var.
    */
    /*
        Time : O(n)   Çünkü her sayı HashSet’e bir kere eklenir.
        Space: O(n)
    */
    public static int longestConsecutive(int[] nums) {
        // I put all numbers into a HashSet for O(1) lookup.
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            numbers.add(num);
        }

        int longest = 0;

        for (int num : numbers) {

            if (!numbers.contains(num - 1)) { // sequence start detection
                // starts a sequence
                int current = num;
                int length = 1;

                while (numbers.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
