package design;

public class Q0706_DesignHashMap {
    // 706. Design HashMap - Easy
    // https://leetcode.com/problems/design-hashmap/description/
    /* ------------------------------------------------------------
       | PATTERN:              Design                           ✅|
       ------------------------------------------------------------
    /* ⭐Optimal pattern
            HashMap’in temel fikri:
                key -> hash function -> bucket index

            Örneğin bucket sayısı 10 olsun:
                index = key % 10;
                key = 21 -> bucket 1
                key = 31 -> bucket 1
                key = 42 -> bucket 2

            Farklı key’ler aynı bucket’a düşebilir:
                21 % 10 = 1
                31 % 10 = 1

            Buna collision denir.
            Collision çözmek için her bucket içinde linked list tutabiliriz:

            bucket[1]:
                (21, value1) -> (31, value2) -> null

            Bu yöntem:
                Separate Chaining olarak adlandırılır.

            4. State / invariant
            ------------------------------
            | Ana state:                 |
            |     List<Node>[] buckets;  |
            |  Her Node şunları tutar:   |
            |    key                     |
            |    value                   |
            |    next                    |
            ------------------------------
            Invariant:
                Bir key her zaman hash(key) ile hesaplanan bucket içinde bulunur.
                Aynı key’den iki tane bulunmamalıdır.
                put sırasında key zaten varsa yeni node eklemeyiz:
                mevcut node'un value'sunu güncelleriz
     */
    /*  Complexity
        İyi dağılımlı hash durumunda:
            put:    O(1) average
            get:    O(1) average
            remove: O(1) average

        Worst case tüm key’ler aynı bucket’a düşerse:
            put:    O(n)
            get:    O(n)
            remove: O(n)

        Space: O(n + bucketCount)

        Genellikle: O(n) olarak ifade edilir.
    */
    public class MyHashMap {

        private static class Node {
            int key;
            int value;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 1009 asal bir sayıdır.
        // Asal bucket sayıları bazı düzenli key pattern’lerinin aynı bucket’larda aşırı birikme ihtimalini azaltabilir.
        private static final int BUCKET_COUNT = 1009;

        // use an array of buckets and map each key to a bucket using a hash function.
        private final Node[] buckets;

        public MyHashMap() {
            buckets = new Node[BUCKET_COUNT];
        }

        public void put(int key, int value) {
            int index = hash(key);

            if (buckets[index] == null) {
                buckets[index] = new Node(-1, -1);
            }

            Node current = buckets[index];

            while (current.next != null) {
                if (current.next.key == key) {
                    current.next.value = value; // update if exists
                    return;
                }

                current = current.next;
            }

            current.next = new Node(key, value); // insert
        }

        public int get(int key) {
            int index = hash(key);
            Node current = buckets[index]; // bucket'i bul

            if (current == null) {
                return -1;
            }

            current = current.next;

            while (current != null) {
                if (current.key == key) { // next yaparak ilgili key bul
                    return current.value;
                }

                current = current.next;
            }

            return -1;
        }

        public void remove(int key) {
            int index = hash(key);
            Node current = buckets[index];  // bucket'i bul

            if (current == null) {
                return;
            }

            while (current.next != null) {
                if (current.next.key == key) { // next yaparak ilgili key bul
                    current.next = current.next.next; // sil
                    return;
                }

                current = current.next;
            }
        }

        private int hash(int key) {
            return key % BUCKET_COUNT; // hashing function
        }
    }

    /*
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
}

