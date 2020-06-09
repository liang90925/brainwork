/* Definition of PushNotification
 * class PushNotification {
 *     public static void notify(int user_id, String the_message)
 *  };
 */

import java.util.*;

public class PubSubPattern {
    Map<String, Set<Integer>> channelService;
    public PubSubPattern(){
        // Write your code here
        channelService  = new HashMap<>();
    }

    /**
     * @param channel: the channel's name
     * @param user_id: the user who subscribes the channel
     * @return: nothing
     */
    public void subscribe(String channel, int user_id) {
        // Write your code here
        if (channelService.containsKey(channel)) {
            channelService.get(channel).add(user_id);
        } else {
            Set<Integer> users = new HashSet<>();
            users.add(user_id);
            channelService.put(channel, users);
        }
    }

    /**
     * @param channel: the channel's name
     * @param user_id: the user who unsubscribes the channel
     * @return: nothing
     */
    public void unsubscribe(String channel, int user_id) {
        // Write your code here
        if (channelService.containsKey(channel)){
            Set<Integer> users = channelService.get(channel);
            users.remove(user_id);
        }
    }

    /**
     * @param channel: the channel's name
     * @param message: the message need to be delivered to the channel's subscribers
     * @return: nothing
     */
    public void publish(String channel, String message) {
        // Write your code here
        if (channelService.containsKey(channel)) {
            for (Integer user: channelService.get(channel)) {
                // PushNotification.notify(user, message);
            }
        }
    }
}
