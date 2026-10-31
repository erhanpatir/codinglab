package design;

import java.util.*;

public class Q0284_PeekingIterator {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#55)
    //
    // 284. Peeking Iterator - Medium
    // https://leetcode.com/problems/peeking-iterator/

    /* ------------------------------------------------------------
       | PATTERN: Design - Iterator (bir eleman önden bakma)
       ------------------------------------------------------------
       peek() çağrıldığında sıradaki elemanı iteratordan çekip sakla (hasPeeked = true).
       next(): saklanan varsa onu döndür, yoksa iteratordan al. hasNext(): saklanan varsa ya da iterator devam ediyorsa true.
    */
    /*  Complexity
        Time  : O(1) her işlem
        Space : O(1)
    */

    public class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private boolean hasPeeked;
        private Integer peekedElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (!hasPeeked) {
                peekedElement = iterator.next();
                hasPeeked = true;
            }
            return peekedElement;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (!hasPeeked) {
                return iterator.next();
            }
            Integer result = peekedElement;
            hasPeeked = false;
            peekedElement = null;
            return result;
        }

        @Override
        public boolean hasNext() {
            return hasPeeked || iterator.hasNext();
        }
    }
}
