 --------------------
| Monotonic Stack ✅ |
 --------------------
Monotonic stack yine stack’tir ama ekstra bir kuralı vardır:

    Stack içindeki elemanlar belirli bir sıralamayı korur.

Ya increasing olur ya decreasing.
 ------------------------------------------
 |3. Increasing Monotonic Stack Ne Demek? |
 ------------------------------------------
Stack içindeki değerler küçükten büyüğe doğru gider.
Örnek: [1, 2, 5, 8]

Yeni gelen değer bu düzeni bozarsa, stack’ten pop yaparsın.
Örnek:

    stack = [1, 4]
    current = 3

3 gelirse:
    [1, 4, 3]

bu increasing değil.
O yüzden 4 pop edilir:
 --------------------------------------------
 | 4. Decreasing Monotonic Stack Ne Demek?  |
 --------------------------------------------
Stack içindeki değerler büyükten küçüğe doğru gider.
Örnek: [9, 6, 3, 1]

Yeni gelen değer büyükse, düzen bozulur.

Örnek:
    stack = [9, 6, 3]
    current = 7

7 gelirse: [9, 6, 3, 7]

bu decreasing değil.
O yüzden 3 pop edilir.
 -----------------------------------------
 | 5. En Basit Fark                      |
 -----------------------------------------
Normal stack:
    Ne gelirse push ederim.
    Sadece gerektiğinde pop ederim.

Monotonic stack:
    Push etmeden önce stack’in sıralama kuralını bozan elemanları pop ederim.

Template:
    while (!stack.isEmpty() && violatesMonotonicOrder(stack.peek(), current)) {
        stack.pop();
    }
    stack.push(current);
 -----------------------------------------
 | 7. Kısa Ezber                         |
 -----------------------------------------
Şöyle hatırla:

    Next greater arıyorsan genelde decreasing stack.
    Next smaller arıyorsan genelde increasing stack.

Ama asıl mantık şu:

    Stack içinde henüz cevabı bulunmamış adayları tutuyorsun.
    Yeni gelen eleman bazı adayların cevabı oluyorsa onları pop ediyorsun.

Monotonic stack’in farkı budur.