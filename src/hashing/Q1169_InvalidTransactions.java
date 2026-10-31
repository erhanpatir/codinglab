package hashing;

import java.util.*;

public class Q1169_InvalidTransactions {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Bloomberg ✅ (#14)
    // Seviye    : Senior
    // Raporlar  : 1 (1 📍London)
    //             https://leetcode.com/discuss/interview-experience/6614891/
    //
    // 1169. Invalid Transactions - Medium
    // https://leetcode.com/problems/invalid-transactions/

    /* ------------------------------------------------------------
       | PATTERN: Hash Map + Simülasyon
       ------------------------------------------------------------
       İşlemleri isme göre grupla. Bir işlem geçersizdir eğer tutar > 1000 ise ya da aynı isimle
       60 dakika içinde farklı şehirde başka bir işlem varsa. Her işlemi aynı isimdeki diğerleriyle karşılaştır.
    */
    /*  Complexity
        Time  : O(n^2)
        Space : O(n)
    */

    public static List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Item>> d = new HashMap<>();
        Set<Integer> idx = new HashSet<>();
        for (int i = 0; i < transactions.length; ++i) {
            var e = transactions[i].split(",");
            String name = e[0];
            int time = Integer.parseInt(e[1]);
            int amount = Integer.parseInt(e[2]);
            String city = e[3];
            d.computeIfAbsent(name, k -> new ArrayList<>()).add(new Item(time, city, i));
            if (amount > 1000) {
                idx.add(i);
            }
            for (Item item : d.get(name)) {
                if (!city.equals(item.city) && Math.abs(time - item.t) <= 60) {
                    idx.add(i);
                    idx.add(item.i);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i : idx) {
            ans.add(transactions[i]);
        }
        return ans;
    }

    static class Item {
        int t;
        String city;
        int i;

        Item(int t, String city, int i) {
            this.t = t;
            this.city = city;
            this.i = i;
        }
    }
}
