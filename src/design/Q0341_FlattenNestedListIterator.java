package design;

import common.model.NestedInteger;
import java.util.*;

public class Q0341_FlattenNestedListIterator {
    // 341. Flatten Nested List Iterator - Medium
    // https://leetcode.com/problems/flatten-nested-list-iterator/

    /* ------------------------------------------------------------
       | PATTERN: Design - Iterator (önceden düzleştirme)
       ------------------------------------------------------------
       Constructor'da DFS ile iç içe listeyi düz bir tam sayı listesine çevir.
       next() ve hasNext() bu liste üzerinde indeks ile çalışır.
       Takip: tembel (lazy) çözüm için stack ile iteratorları tutmak.
    */
    /*  Complexity
        Time  : Constructor O(N), next/hasNext O(1)
        Space : O(N)
    */

    public class NestedIterator implements Iterator<Integer> {
        private List<Integer> nums = new ArrayList<>();
        private int i = -1;

        public NestedIterator(List<NestedInteger> nestedList) {
            dfs(nestedList);
        }

        @Override
        public Integer next() {
            return nums.get(++i);
        }

        @Override
        public boolean hasNext() {
            return i + 1 < nums.size();
        }

        private void dfs(List<NestedInteger> ls) {
            for (var x : ls) {
                if (x.isInteger()) {
                    nums.add(x.getInteger());
                } else {
                    dfs(x.getList());
                }
            }
        }
    }
}
