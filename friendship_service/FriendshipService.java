import java.util.*;

public class FriendshipService {
    Map<Integer, Set<Integer>> followersMap = new HashMap<>();
    Map<Integer, Set<Integer>> followingMap = new HashMap<>();


    public FriendshipService() {
        // do intialization if necessary
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        // write your code here
        return new ArrayList<>(followersMap.getOrDefault(user_id, Collections.emptySet()));
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        // write your code here
        return new ArrayList<>(followingMap.getOrDefault(user_id, Collections.emptySet()));
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int to_user_id, int from_user_id) {
        // write your code here
        addToMap(followersMap, to_user_id, from_user_id);
        addToMap(followingMap, from_user_id, to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int to_user_id, int from_user_id) {
        // write your code here
        removeFromMap(followersMap, to_user_id, from_user_id);
        removeFromMap(followingMap, from_user_id, to_user_id);
    }

    private void addToMap(Map<Integer, Set<Integer>> map, int key, int toBeAdded) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeSet<>());
        }
        map.get(key).add(toBeAdded);
    }

    private void removeFromMap(Map<Integer, Set<Integer>> map, int key, int toBeDeleted) {
        if (map.containsKey((key))) {
            map.get(key).remove(toBeDeleted);
        }
    }

}
