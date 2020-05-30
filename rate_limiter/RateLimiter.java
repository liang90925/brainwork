import javax.lang.model.element.ElementVisitor;
import java.security.cert.CertificateNotYetValidException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RateLimiter {
    private Map<String, List<Integer>> map = new HashMap<>();

    /**
     * @param current_timestamp the current timestamp
     * @param event the string to distinct different event
     * @param rate the format is [integer]/[s/m/h/d]
     * @param increment whether we should increase the counter
     * @return true of false to indicate the event is limited or not
     */
    public boolean isRatelimited(int current_timestamp, String event, String rate, boolean increment) {
        int limit = Integer.parseInt(rate.split("/")[0]);
        String unit = rate.split("/")[1];

        int duration = 1;
        if (unit.equals("m")) {
            duration = duration * 60;
        }
        if (unit.equals("h")) {
            duration = duration * 60 * 60;
        }
        if (unit.equals("d")) {
            duration = duration * 60 * 60 * 24;
        }
        int start_timestamp =  current_timestamp - duration + 1;

        if (!map.containsKey(event)) {
            map.put(event, new ArrayList<>());
        }

        int count = countEvent(map.get(event), start_timestamp);
        boolean isRateLimited = count >= limit;
        if (increment && !isRateLimited) {
            map.get(event).add(current_timestamp);
        }

        return isRateLimited;
    }

    private int countEvent(List<Integer> event, int start_timestamp) {
        int l = 0;
        int r = event.size() -1;

        if (r == -1) {
            return 0;
        }
        if (event.get(r) < start_timestamp) {
            return 0;
        }
        int ans = 0;

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (event.get(mid) >= start_timestamp) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return event.size() - 1 - ans + 1;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();
        System.out.println(rateLimiter.isRatelimited(1, "login", "3/m", true));
        System.out.println(rateLimiter.isRatelimited(11, "login", "3/m", true));
        System.out.println(rateLimiter.isRatelimited(21, "login", "3/m", true));
        System.out.println(rateLimiter.isRatelimited(30, "login", "3/m", true));
        System.out.println(rateLimiter.isRatelimited(65, "login", "3/m", true));
        System.out.println(rateLimiter.isRatelimited(300, "login", "3/m", true));

        System.out.println("=================");
        RateLimiter rateLimiter2 = new RateLimiter();

        System.out.println(rateLimiter2.isRatelimited(1, "login", "1/m", true));
        System.out.println(rateLimiter2.isRatelimited(61, "login", "1/m", true));
        System.out.println(rateLimiter2.isRatelimited(122, "login", "1/m", true));
        System.out.println(rateLimiter2.isRatelimited(125, "logout", "1/m", false));
        System.out.println(rateLimiter2.isRatelimited(157, "logout", "1/m", true));
        System.out.println(rateLimiter2.isRatelimited(177, "logout", "1/m", true));
        System.out.println(rateLimiter2.isRatelimited(181, "login", "1/m", true));
    }
}




//    private Map<String, Integer> cacheInSnd = new HashMap<>();
//    private Map<String, Integer> cacheInMin = new HashMap<>();
//    private Map<String, Integer> cacheInHr = new HashMap<>();
//    private Map<String, Integer> eventToCnt = new HashMap<>();
//    private Integer count = 0;
//    /*
//     * @param timestamp: the current timestamp
//     * @param event: the string to distinct different event
//     * @param rate: the format is [integer]/[s/m/h/d]
//     * @param increment: whether we should increase the counter
//     * @return: true or false to indicate the event is limited or not
//     */
//    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
//        // write your code here
//
//        int limit = Integer.parseInt(rate.split("/")[0]);
//        String unit = rate.split("/")[1];
//        int plus = 0;
//        if (increment) {
//            plus = 1;
//        }
//        if (unit.equals("s")) {
//            return caseOfSnd(cacheInSnd, event, timestamp, limit, plus);
//        }
//        if (unit.equals("m")) {
//            return caseOfMin(cacheInSnd, event, timestamp, limit, plus);
//        }
//        if (unit.equals("h")) {
//            return caseOfHr(cacheInMin, event, timestamp, limit, plus);
//        }
//        if (unit.equals("d")) {
//            return caseOfDay(cacheInHr, event, timestamp, limit, plus);
//        }
//
//        return false;
//    }
//    private boolean caseOfSnd(Map<String, Integer> cache,  String event, int timestamp, int limit, int increment) {
//        String key = event + ":" + timestamp;
//
//        int cntBeforeSnd = 0;
//        for (int i = timestamp - 1; i > 0; i--) {
//            if (cache.containsKey(event + ":" + i)) {
//                cntBeforeSnd = cache.get(event + ":" + i);
//                break;
//            }
//        }
//        int count = eventToCnt.getOrDefault(event, 0);
//        if (count - cntBeforeSnd + 1 > limit) {
//            // rate limited case;
//            cache.put(key, count);
//            return true;
//        } else {
//            count += increment;
//            cache.put(key, count);
//            eventToCnt.put(event, count);
//            return false;
//        }
//    }
//    private boolean caseOfMin(Map<String, Integer> cache,  String event, int timestamp, int limit, int increment) {
//        int cntBeforeMin = 0;
//        for (int i = timestamp - 60; i > 0; i--) {
//            if (cache.containsKey(event + ":" + i)) {
//                cntBeforeMin = cache.get(event + ":" + i);
//                break;
//            }
//        }
//        int count = eventToCnt.getOrDefault(event, 0);
//        String key = event + ":" + timestamp;
//        if (count - cntBeforeMin + 1 > limit) {
//            // rate limited case; c
//            cache.put(key, count);
//            return true;
//        } else {
//            count += increment;
//            cache.put(key, count);
//            eventToCnt.put(event, count);
//            return false;
//        }
//    }
//
//    private boolean caseOfHr(Map<String, Integer> cache,  String event, int timestamp,  int limit, int increment) {
//        int timestampInMin = timestamp / 60;
//        cache.put(event + ":" + timestampInMin, count);
//        int cntBeforeHr = 0;
//        for (int i = timestampInMin - 60; i > 0; i--) {
//            if (cache.containsKey(event + ":" + i)) {
//                cntBeforeHr = cache.get(event + ":" + i);
//                break;
//            }
//        }
//        int count = eventToCnt.getOrDefault(event, 0);
//        String key = event + ":" + timestampInMin;
//        if (count - cntBeforeHr + 1 > limit) {
//            // rate limited case; c
//            cache.put(key, count);
//            return true;
//        } else {
//            count += increment;
//            cache.put(key, count);
//            eventToCnt.put(event, count);
//            return false;
//        }
//    }
//
//    private boolean caseOfDay(Map<String, Integer> cache,  String event, int timestamp,  int limit, int increment) {
//        int timestampInHr = timestamp / 60 / 60;
//
//        cache.put(event + ":" + timestampInHr, count);
//        int cntBeforeDay = 0;
//        for (int i = timestampInHr - 24; i > 0; i--) {
//            if (cache.containsKey(event + ":" + i)) {
//                cntBeforeDay = cache.get(event + ":" + i);
//                break;
//            }
//        }
//
//        int count = eventToCnt.getOrDefault(event, 0);
//        String key = event + ":" + timestampInHr;
//        if (count - cntBeforeDay + increment > limit) {
//            // rate limited case; c
//            cache.put(key, count);
//            return true;
//        } else {
//            count += increment;
//            cache.put(key, count);
//            eventToCnt.put(event, count);
//            return false;
//        }
//    }