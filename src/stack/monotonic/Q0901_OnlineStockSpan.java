package stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0901_OnlineStockSpan {
    // 901. Online Stock Span - Medium
    // https://leetcode.com/problems/online-stock-span/
    /* -------------------------------------------------------------
       | PATTERN:      Monotonic Decreasing Stack                ✅|
       -------------------------------------------------------------
    /*
        Stack içinde pair tutacağız: (price, span)

        Invariant:
            Stack price olarak decreasing kalır.

        Yani stack’te yukarı doğru çıktıkça fiyatlar daha küçük/eşit olamaz;
        küçük/eşit gelenler merge edilip pop edilir.

        Yeni price geldiğinde:
            span = 1
        Sonra:
            while stack top price <= current price:
                span += stack top span
                pop

        Sonra current pair push edilir:
            (current price, calculated span)

        Neden Span’leri Topluyoruz?
        Çünkü stack’teki her pair zaten geçmişte merge edilmiş bir blok temsil eder.
        Örnek:
            price = 75

        Stack top: (60, 1)
        60 küçük/eşit, span’e ekle.
        Sonra: (70, 2)
        Bu 70, aslında şu bloğu temsil ediyor: 70, 60

        Eğer 75 >= 70 ise, o bloğun tamamı da span’e dahil olur.
        O yüzden:
            span += previousSpan yaparız.
    */
    /*  Complexity
            Time  : O(n)
            Space : O(n)
    */
    private final Deque<Entry> stack;
    public Q0901_OnlineStockSpan() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }

        stack.push(new Entry(price, span));

        return span;
    }

    private static class Entry {
        int price;
        int span;

        Entry(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
}
