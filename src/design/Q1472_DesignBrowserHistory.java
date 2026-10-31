package design;

import java.util.*;

public class Q1472_DesignBrowserHistory {
    // 1472. Design Browser History - Medium
    // https://leetcode.com/problems/design-browser-history/description/

    /* ------------------------------------------------------------
       | PATTERN: Design - Two Stacks (geri / ileri)
       ------------------------------------------------------------
       Geri yığını ziyaret edilen sayfaları tutar, tepesi mevcut sayfadır; ileri yığını geri gidilen sayfaları tutar.
       visit: geri yığınına it, ileri yığınını temizle. back/forward: sayfaları iki yığın arasında
       adım sayısı kadar (sınırlar içinde) taşı.
    */
    /*  Complexity
        Time  : O(steps)
        Space : O(n)
    */

    public class BrowserHistory {
        private Deque<String> stk1 = new ArrayDeque<>();
        private Deque<String> stk2 = new ArrayDeque<>();

        public BrowserHistory(String homepage) {
            visit(homepage);
        }

        public void visit(String url) {
            stk1.push(url);
            stk2.clear();
        }

        public String back(int steps) {
            for (; steps > 0 && stk1.size() > 1; --steps) {
                stk2.push(stk1.pop());
            }
            return stk1.peek();
        }

        public String forward(int steps) {
            for (; steps > 0 && !stk2.isEmpty(); --steps) {
                stk1.push(stk2.pop());
            }
            return stk1.peek();
        }
    }
}
