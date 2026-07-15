package hashing;

import java.util.HashMap;
import java.util.Map;

public class Q1512_NumberOfGoodPairs {
    // 1512. Number of Good Pairs - Easy
    // https://leetcode.com/problems/number-of-good-pairs/
    /* -----------------------------------------------------------
      | PATTERN:          Frequency counting                   ✅|
      ------------------------------------------------------------
   /* ⭐Optimal pattern
        Array’i soldan sağa gezerken şu bilgiyi tutarız:
            freq[x] = x değeri daha önce kaç kez görüldü?
        Yeni bir x gördüğümüzde, daha önce x değerinden k tane gördüysek yeni eleman tam olarak k yeni good pair oluşturur.

        Örneğin daha önce üç tane 5 gördüysek:
            önceki indexler: 1, 4, 7
            yeni 5'in indexi: 10

        Yeni pair’ler:
        (1, 10)
        (4, 10)
        (7, 10)

        Yani:
            newPairs = previousFrequencyOf5
            Sonra 5’in frekansını bir artırırız.
    */
    /*  Complexity
        HashMap çözümü
            Time: O(n)
            Space: O(k)

        Burada k, farklı sayıların sayısıdır.
        En kötü durumda bütün elemanlar farklı olabilir:

            k = n

        Bu yüzden en kötü space: O(n)

        HashMap’in get ve put işlemleri ortalama olarak:  O(1)
        olduğu için toplam zaman: O(n)
    */
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int pairs = 0;

        for (int num : nums) {
            Integer freq = freqMap.getOrDefault(num, 0);
            pairs += freq;
            freqMap.put(num, freq + 1);
        }

        return pairs;
    }
    /* Tüm dry run tablosu
        Index	num	Önceki freq[num]	Yeni pair sayısı	Toplam pair	İşlem sonrası map
         0	     1	 0	      0	              0	                    {1=1}
         1	     2	 0	      0	              0	                    {1=1, 2=1}
         2	     3	 0	      0	              0	                    {1=1, 2=1, 3=1}
         3	     1	 1	      1	              1	                    {1=2, 2=1, 3=1}
         4	     1	 2	      2	              3	                    {1=3, 2=1, 3=1}
         5	     3	 1	      1	              4	                    {1=3, 2=1, 3=2}
    */
}
