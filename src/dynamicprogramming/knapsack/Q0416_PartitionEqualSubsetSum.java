package dynamicprogramming.knapsack;

public class Q0416_PartitionEqualSubsetSum {
    // 416. Partition Equal Subset Sum - Medium
    // https://leetcode.com/problems/partition-equal-subset-sum/

    /*  ----------------------------------------------------
        | PATTERN: 0/1 Knapsack + Feasibility DP           |
        ----------------------------------------------------
        Knapsack ailesinin özü
            Aslında tüm knapsack soruları şuna dayanır:
            current state
            ←
            previous state + current item

        State:
            dp[s] = toplamı s olan bir subset oluşturulabilir mi?
            dp[11] = true demek; 11 toplamına ulaşan bir subset var.

        Transition
            Her num için: dp[s] = dp[s] || dp[s - num]

        Anlamı:
            s toplamını yapmak için num'u kullanırsam,
            önceden s - num yapılabiliyor olmalı.
    */
    /* Complexity
        Diyelim:
            N = nums.length
            S = total sum / 2

        Time: O(N * S)
            Her num için target’a kadar sum state’lerini geziyoruz.
        Space: O(S)
            Tek boolean DP array tutuyoruz.
    */

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) { // toplam tek bir sayi ise; iki esit subset cikmaz.
            return false;
        }

        int target = total / 2; // bir subset'in toplami toplamin yarisi olur.
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;    // base case

        for (int num : nums) {
            for (int s = target; s >= num; s--) {   // aynı num’u tekrar kullanmamak icin
                dp[s] = dp[s] || dp[s - num];       // transition
                // “Bu sayıyı kullanırsam, kalan toplam daha önce yapılabiliyor muydu?”
            }
        }

        return dp[target];
    }

    /*  Dry run
        nums = [1, 5, 11, 5]
        total = 22
        target = 11

        Başlangıç:
            dp[0] = true

        num = 1 sonrası:
            dp[1] = true

        num = 5 sonrası:
            dp[5] = true
            dp[6] = true   // 1 + 5

        num = 11 sonrası:
            dp[11] = true

        Burada artık cevap true.
    */
}
