package simulation;

import java.util.*;

public class Q0273_IntegerToEnglishWords {
    // 273. Integer to English Words - Hard
    // https://leetcode.com/problems/integer-to-english-words/

    /* ------------------------------------------------------------
       | PATTERN: Simülasyon (üçerli gruplar)
       ------------------------------------------------------------
       Sayıyı Billion, Million, Thousand ve birler gruplarına böl. Her 3 basamaklı grubu
       "yüzler + 20 altı / onlar + birler" kuralıyla yazıya çevir, grubun adını ekle. 0 için "Zero".
    */
    /*  Complexity
        Time  : O(log10 n)
        Space : O(1)
    */

    private String[] lt20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
        "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens
        = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"Billion", "Million", "Thousand", ""};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1000000000, j = 0; i > 0; i /= 1000, ++j) {
            if (num / i == 0) {
                continue;
            }
            sb.append(transfer(num / i)).append(thousands[j]).append(' ');
            num %= i;
        }
        return sb.toString().trim();
    }

    private String transfer(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 20) {
            return lt20[num] + " ";
        }
        if (num < 100) {
            return tens[num / 10] + " " + transfer(num % 10);
        }
        return lt20[num / 100] + " Hundred " + transfer(num % 100);
    }
}
