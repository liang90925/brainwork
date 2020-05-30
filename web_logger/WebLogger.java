import com.apple.eawt.AppEvent;

import java.util.HashMap;
import java.util.Map;

public class WebLogger {
    private Map<Integer, Integer> map = new HashMap<>();
    private int count = 0;
    public WebLogger() {
        // do intialization if necessary
    }

    /*
     * @param timestamp: An integer
     * @return: nothing
     */
    public void hit(int timestamp) {
        // write your code here
        if (map.containsKey(timestamp)) {
            map.put(timestamp, map.get(timestamp) + 1);
        } else {
            map.put(timestamp, 1);
        }

    }

    /*
     * @param timestamp: An integer
     * @return: An integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // write your code here
        int total = 0;
        int prevTimestamp = timestamp - 300 + 1;
        prevTimestamp = Math.max(1, prevTimestamp);

        for (int i = prevTimestamp; i <= timestamp; i++) {
            if (map.containsKey(i)) {
                total += map.get(i);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        WebLogger webLogger = new WebLogger();

        webLogger.hit(1);
        webLogger.hit(2);
        System.out.println(webLogger.get_hit_count_in_last_5_minutes(3));
        webLogger.hit(300);
        System.out.println(webLogger.get_hit_count_in_last_5_minutes(300));
        System.out.println(webLogger.get_hit_count_in_last_5_minutes(301));

        System.out.println("=========================");
        WebLogger webLogger1 = new WebLogger();

        webLogger1.hit(1);
        webLogger1.hit(1);
        webLogger1.hit(1);
        webLogger1.hit(2);
        webLogger1.get_hit_count_in_last_5_minutes(3);
        webLogger1.hit(300);
        System.out.println(webLogger1.get_hit_count_in_last_5_minutes(300));
        System.out.println(webLogger1.get_hit_count_in_last_5_minutes(301));
        System.out.println(webLogger1.get_hit_count_in_last_5_minutes(302));
        System.out.println(webLogger1.get_hit_count_in_last_5_minutes(900));
        System.out.println(webLogger1.get_hit_count_in_last_5_minutes(900));
    }
}