package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q0535_EncodeAndDecodeTinyURL {
    // 535. Encode and Decode TinyURL - Medium
    // https://leetcode.com/problems/encode-and-decode-tinyurl/
    /* -----------------------------------------------------------
       | PATTERN:              Two mapping                     ✅|
       -----------------------------------------------------------
    /* ⭐Optimal pattern
            İki yönlü map kullanabiliriz:
                shortCode -> longUrl
                longUrl   -> shortCode

            Neden iki map?
                shortCode -> longUrl  --> decode işlemi için gerekir.
                longUrl -> shortCode  --> aynı URL tekrar encode edilirse aynı short URL’yi döndürmek için faydalıdır.

            Örnek:
                longToCode: "https://example.com/a" -> "0"
                codeToLong: "0" -> "https://example.com/a"

            Unique code üretmek için basit bir counter kullanılabilir:
                0, 1, 2, 3...

            4. State / invariant
            State:
                codeToLong[code] = original URL
                longToCode[longUrl] = code
                counter = sıradaki unique code

            Invariant:
                Her code yalnızca bir long URL’ye aittir.
                Her kaydedilmiş long URL geçerli bir code ile eşleşir.

            encode sonrasında iki map de birbirini doğrulamalıdır:
                longToCode[url] = code
                codeToLong[code] = url
     */
    /*  Complexity
        HashMap işlemleri ortalama:
            encode: O(1)
            decode: O(1)

        String uzunluğu hesaba katılırsa key oluşturma ve substring işlemleri URL uzunluğuna bağlı olabilir.

        Space:
            O(n), burada n, kaydedilen URL sayısıdır
    */
    public class Codec_Integer {
        private static final String BASE_URL = "http://tinyurl.com/";

        private final Map<String, String> codeToLong = new HashMap<>();
        private final Map<String, String> longToCode = new HashMap<>();

        /* Collision oluşmaz.  0, 1, 2, 3...
           Ama bu yalnızca tek process ve in-memory çözüm için yeterlidir.
           Gerçek dağıtık sistemde birden fazla server aynı counter değerini üretebilir. Orada:

                database sequence
                distributed ID generator
                random code + collision check
                Base62

            gibi yöntemler gerekir.
        */
        private int counter = 0;

        public String encode(String longUrl) {
            if (longToCode.containsKey(longUrl)) {
                return BASE_URL + longToCode.get(longUrl);
            }

            String code = String.valueOf(counter++);

            longToCode.put(longUrl, code);
            codeToLong.put(code, longUrl);

            return BASE_URL + code;
        }

        public String decode(String shortUrl) {
            String code = shortUrl.substring(BASE_URL.length());
            return codeToLong.get(code);
        }
    }

    public class Codec_Random {
        private static final String BASE_URL = "http://tinyurl.com/";

        private static final String CHARS =
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        private final Map<String, String> codeToLong = new HashMap<>();
        private final Map<String, String> longToCode = new HashMap<>();

        private final Random random = new Random();

        public String encode(String longUrl) {
            // Daha önce encode edildiyse aynı short URL'yi döndür.
            if (longToCode.containsKey(longUrl)) {
                return BASE_URL + longToCode.get(longUrl);
            }

            String code;

            do {
                code = generateCode();
            } while (codeToLong.containsKey(code));

            codeToLong.put(code, longUrl);
            longToCode.put(longUrl, code);

            return BASE_URL + code;
        }

        public String decode(String shortUrl) {
            String code = shortUrl.substring(BASE_URL.length());
            return codeToLong.get(code);
        }

        private String generateCode() {
            StringBuilder code = new StringBuilder();

            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(CHARS.length());
                code.append(CHARS.charAt(index));
            }

            return code.toString();
        }
    }
}
