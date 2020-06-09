import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeartBeat {

    private static final Map<String, Integer> ipToTimestamp = new HashMap<>();
    private int limit = 0;
    public HeartBeat() {
        // do intialization if necessary
    }

    /*
     * @param slaves_ip_list: a list of slaves'ip addresses
     * @param k: An integer
     * @return: nothing
     */
    public void initialize(List<String> slaves_ip_list, int k) {
        // write your code here
        for (String ip: slaves_ip_list) {
            ipToTimestamp.put(ip, 0);
        }
        this.limit = 2* k;
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @param slave_ip: the ip address of the slave server
     * @return: nothing
     */
    public void ping(int timestamp, String slave_ip) {
        // write your code here
        if (ipToTimestamp.containsKey(slave_ip)) {
            ipToTimestamp.put(slave_ip, timestamp);
        }
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @return: a list of slaves'ip addresses that died
     */
    public List<String> getDiedSlaves(int timestamp) {
        List<String> diedSlaves = new ArrayList<>();
        // write your code here
        for (Map.Entry<String, Integer> entry: ipToTimestamp.entrySet()) {
            int prevTimestamp = entry.getValue();

            if (prevTimestamp + limit <= timestamp) {
                diedSlaves.add(entry.getKey());
            }
        }
        return diedSlaves;
    }
}
