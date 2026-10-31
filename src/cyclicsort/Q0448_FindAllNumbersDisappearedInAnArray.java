package cyclicsort;

import java.util.*;

public class Q0448_FindAllNumbersDisappearedInAnArray {
    // 448. Find All Numbers Disappeared in an Array - Easy
    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

    /* ------------------------------------------------------------
       | PATTERN: Cyclic Sort
       ------------------------------------------------------------
       Her değeri, olması gereken (değer - 1) indeksine swap ile taşı; o konumda zaten aynı değer varsa ilerle.
       Sonra nums[i] != i + 1 olan her i için i + 1 eksik sayıdır.
       Alternatif: indeksi negatif yaparak işaretleme; ikisi de O(1) ekstra bellek.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1) (çıktı hariç)
    */

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;          // nums[i] değerinin olması gereken indeks
            if (nums[i] != nums[correct]) {
                int tmp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = tmp;
            } else {
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) result.add(j + 1);
        }
        return result;
    }
}
