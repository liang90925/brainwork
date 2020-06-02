import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyUrl {
    private final static int maxLen = 6;
    private final static String items = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static int maxItems = items.length();
    private final static char[] itemChar = items.toCharArray();
    private final static String preFix = "http://tiny.url/";

    private final Map<String, String> lngToSrt = new HashMap<>();
    private final Map<String, String> srtToLng = new HashMap<>();
    private final Random random = new Random();


    /*
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
        // write your code here
        // given a long url,
        // 1. if the longtoshrt maps does not contain a short url;
        // 2. Use the randomAlg code to create one and return
        // 3. Update the Maps
        if (!lngToSrt.containsKey(url)) {
            while (true) {
                String srtUrl = createRandomShortUrl();
                if (!srtToLng.containsKey(srtUrl)) {
                    lngToSrt.put(url, preFix + srtUrl);
                    srtToLng.put(preFix + srtUrl, url);
                    break;
                }
            }
        }
        System.out.println("long:" + url + ", short: " + lngToSrt.get(url));
        return lngToSrt.get(url);

    }

    public String createRandomShortUrl() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            sb.append(itemChar[random.nextInt(maxItems)]);
        }
        return sb.toString();
    }

    /*
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {
        // write your code here
        // Find the corresponding short url in the map
        // if not in map, return empty string
        if (srtToLng.containsKey(url)) {
            return srtToLng.get(url);
        }
        return null;
    }

    public static void main(String[] args) {
        TinyUrl tinyUrl = new TinyUrl();
        System.out.println(tinyUrl.shortToLong(tinyUrl.longToShort("http://www.lintcode.com/faq/?id=10")));
        System.out.println(tinyUrl.shortToLong(tinyUrl.longToShort("http://www.liangisawesome")));
        System.out.println(tinyUrl.shortToLong(tinyUrl.longToShort("http://www.alvinisstupid")));
    }
}
