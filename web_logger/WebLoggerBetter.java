import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WebLoggerBetter {
    private static final int FIVE_MINS = 300;
    private int[] time = new int[FIVE_MINS];
    private int[] cnt = new int[FIVE_MINS];

    public WebLoggerBetter() {
        // do intialization if necessary
    }

    /*
     * @param timestamp: An integer
     * @return: nothing
     */
    public void hit(int timestamp) {
        int t = timestamp % FIVE_MINS;
        if (time[t] != timestamp) {
            time[t] = timestamp;
            cnt[t] = 1;
        } else {
            cnt[t]++;
        }
    }

    /*
     * @param timestamp: An integer
     * @return: An integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        int total = 0;
        for (int i = 0; i < FIVE_MINS; i++) {
            if (timestamp - time[i] < FIVE_MINS) {
                total += cnt[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        WebLoggerBetter webLogger = new WebLoggerBetter();

        webLogger.hit(1);
        webLogger.hit(2);
        System.out.println(webLogger.get_hit_count_in_last_5_minutes(3));
        webLogger.hit(300);
        System.out.println(webLogger.get_hit_count_in_last_5_minutes(300));
        System.out.println(webLogger.get_hit_count_in_last_5_minutes(301));

        System.out.println("=========================");
        WebLoggerBetter webLogger1 = new WebLoggerBetter();

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