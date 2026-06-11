package arrays.twopointers;

public class Q0121_BestTimeToBuyAndSellStock {
    // 121 - Best Time to Buy and Sell Stock - Easy
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    // -------------------------------------------------------------
    // |PATTERN: One Pass + Minimum So Far                       ✅|
    // -------------------------------------------------------------
    /*
        Her gün şunu sorarız:
            Bugün satsam, elimdeki en düşük alış fiyatına göre profit kaç olur?

        State:
            minPriceSoFar
            maxProfit

        Her price için:
            maxProfit = max(maxProfit, price - minPriceSoFar)
            minPriceSoFar = min(minPriceSoFar, price)
        3. State / Invariant
        Invariant:
            minPriceSoFar, current güne kadar gördüğümüz en düşük fiyatı tutar.
            maxProfit, şu ana kadar yapılabilecek en iyi profit’i tutar.

        Önemli nokta:
        Satış günü alış gününden sonra olmalı.
        Bu yüzden array’i soldan sağa geziyoruz.
        minPriceSoFar sadece geçmişteki fiyatlardan gelir.
    */
    /*

    /*
        Complexity Analysis
            Time: O(n)
            Space: O(1)
    */
    public static int maxProfit(int[] prices) {
        /*
            “I scan the prices once while keeping the minimum price seen so far.
             For each day, I calculate the profit if I sell today using that minimum buy price.
             Then I update the maximum profit.
             Because the minimum price only comes from previous days, the buy-before-sell constraint is preserved.”
        */
        int minPriceSoFar = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            int profit = price - minPriceSoFar;
            maxProfit = Math.max(maxProfit, profit);
            minPriceSoFar = Math.min(minPriceSoFar, price);
        }
        return maxProfit;
    }

    /* Dry Run
        prices = [7,1,5,3,6,4]

        Başlangıç:
            minPriceSoFar = 7
            maxProfit = 0

        price = 7
            profit = 7 - 7 = 0
            maxProfit = 0
            minPriceSoFar = 7

        price = 1
            profit = 1 - 7 = -6
            maxProfit = 0
            minPriceSoFar = 1

        price = 5
            profit = 5 - 1 = 4
            maxProfit = 4
            minPriceSoFar = 1

        price = 3
            profit = 3 - 1 = 2
            maxProfit = 4
            minPriceSoFar = 1

        price = 6
            profit = 6 - 1 = 5
            maxProfit = 5
            minPriceSoFar = 1

        price = 4
            profit = 4 - 1 = 3
            maxProfit = 5

        Return: 5  ✅
*/
}
