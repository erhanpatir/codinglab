package design;

import java.util.*;

public class Q0359_LoggerRateLimiter {
    // 359. Logger Rate Limiter - Easy
    // https://leetcode.com/problems/logger-rate-limiter/

    /* ------------------------------------------------------------
       | PATTERN: Design - Hash Map (son yazdırılma zamanı)
       ------------------------------------------------------------
       Mesaj -> bir sonraki izin verilen zaman. timestamp bu değerden küçükse false;
       değilse map'i timestamp + 10 ile güncelle ve true döndür.
    */
    /*  Complexity
        Time  : O(1) her çağrı
        Space : O(m) (farklı mesaj sayısı)
    */

    public class Logger {
        private Map<String, Integer> ts = new HashMap<>();

        public Logger() {
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            int t = ts.getOrDefault(message, 0);
            if (timestamp < t) {
                return false;
            }
            ts.put(message, timestamp + 10);
            return true;
        }
    }
}
