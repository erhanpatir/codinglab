package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q0767_ReorganizeString {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Amazon ✅ (#11)
    //
    // 767. Reorganize String - Medium
    // https://leetcode.com/problems/reorganize-string/
    /* ---------------------------------------------------------------
       | PATTERN:    Frequency Map + Priority Queue (max heap)     ✅|
       ---------------------------------------------------------------
    /* ⭐Optimal pattern
            İlk iş yine HashMap:
                character -> frequency

            Örneğin:
                aaabbc

            HashMap:
                a -> 3
                b -> 2
                c -> 1

            Sonra en fazla kalan frekansa sahip karakteri seçmek isteriz.
            Ama aynı karakteri arka arkaya seçemeyiz.

            Bu yüzden:
                HashMap + Max Heap kullanırız.

            Heap bize her zaman:
                En çok kalan karakter verir.

            Fakat son kullandığımız karakteri hemen geri koymayız.

            Temel fikir
            Elimizde:
                a -> 3
                b -> 2
                c -> 1

            Heap:
                (a,3)
                (b,2)
                (c,1)

            İlk seçim: a
            Şimdi: a -> 2

            Ama hemen tekrar heap'e koymuyoruz.
            Çünkü tekrar seçilebilir.
            Onu geçici olarak elimizde tutuyoruz.

            Sonra: b. seçiyoruz.

            Artık:
                a   yeniden heap'e dönebilir.

            Bu, greedy kısmın en önemli fikridir.
     */
    /*  Complexity
        n = s.length()
        HashMap oluşturma: O(n)

        Heap işlemleri:
        Her karakter en fazla bir kez çıkarılıp geri eklenir.
            O(n log k)

        k = farklı karakter sayısı.

        İngilizce küçük harflerde:
            k <= 26
        olduğu için pratikte:
            O(n)
        olarak düşünülebilir.

        Space:
            O(k)
    */
    public String reorganizeString(String s) {
        Map<Character, Integer> frequency = new HashMap<>();

        // mapping
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> maxHeap =
                new PriorityQueue<>((a, b) -> b.count - a.count);

        // max heap
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            maxHeap.offer(new Node(entry.getKey(), entry.getValue()));
        }

        StringBuilder result = new StringBuilder();

        Node previous = null;

        while (!maxHeap.isEmpty()) {

            Node current = maxHeap.poll(); // en fazla geleni al

            result.append(current.ch);
            current.count--;

            if (previous != null) {
                maxHeap.offer(previous); // oncekini geri ekle
            }

            previous = current.count > 0 ? current : null; // halen kullanilmamis harf var ise, onceki olarak tut
        }

        return result.length() == s.length()
                ? result.toString()
                : "";
    }

    private static class Node {
        char ch;
        int count;

        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
