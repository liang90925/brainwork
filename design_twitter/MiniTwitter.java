import java.util.*;

/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id; 
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */

//Is the id in tweet a timeline ??

//public class Tweet {
//    public int id;
//    public int user_id;
//    public String text;
//    public static Tweet create(int user_id, String tweet_text) {
//        // This will create a new tweet object,
//        // and auto fill id
//    }
//}

public class MiniTwitter {


    private Map<Integer, PriorityQueue<Tweet>> userToTweetsMap = new HashMap<>();
    private Map<Integer, Set<Integer>> userToFriendsMap = new HashMap<>();
    private int order = 0;
    public MiniTwitter() {
        // do intialization if necessary
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet newTweet = Tweet.create(user_id, tweet_text, this.order++);
        if (!userToTweetsMap.containsKey(user_id)) {
            userToTweetsMap.put(user_id, new PriorityQueue<>((a, b) -> b.id - a.id));
        }
        userToTweetsMap.get(user_id).add(newTweet);
        return newTweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        List<Tweet> totalTweets = new ArrayList<>();
        PriorityQueue<Tweet> firstTen = new PriorityQueue<>((a, b) -> (b.id - a.id));
        firstTen.addAll(userToTweetsMap.getOrDefault(user_id, new PriorityQueue<>((a, b) -> (b.id - a.id))));

        if (userToFriendsMap.containsKey(user_id)) {
            for (int frd : userToFriendsMap.get(user_id)) {
                // get the pq for each frd
                firstTen.addAll(userToTweetsMap.getOrDefault(frd, new PriorityQueue<>((a, b) -> (b.id - a.id))));
            }
        }

        while (totalTweets.size() < 10 && firstTen.size() != 0) {
            totalTweets.add(firstTen.poll());
        }

        return totalTweets;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Tweet> totalTweets = new ArrayList<>();
        PriorityQueue<Tweet> firstTen = new PriorityQueue<>((a, b) -> (b.id - a.id));
        firstTen.addAll(userToTweetsMap.getOrDefault(user_id, new PriorityQueue<>((a, b) -> (b.id - a.id))));
        while (totalTweets.size() < 10 && firstTen.size() != 0) {
            totalTweets.add(firstTen.poll());
        }
        return totalTweets;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        if (!userToFriendsMap.containsKey(from_user_id)) {
            userToFriendsMap.put(from_user_id, new HashSet<>());
        }
        userToFriendsMap.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        if (userToFriendsMap.containsKey(from_user_id)) {
            userToFriendsMap.get(from_user_id).remove(to_user_id);
        }
    }

    public static void main(String[] args) {
        MiniTwitter miniTwitter = new MiniTwitter();
        Tweet postedTweet = miniTwitter.postTweet(1, "LintCode is Good!!!");
        System.out.println(postedTweet.toString());
        System.out.println("getNewsfeed for 1: " + miniTwitter.getNewsFeed(1));
        System.out.println("getTimeLine for 1: " + miniTwitter.getTimeline(1));
        miniTwitter.follow(2, 1);
        System.out.println("getNewsfeed for 2: " + miniTwitter.getNewsFeed(2));
        miniTwitter.unfollow(2, 1);
        System.out.println("getNewsfeed for 2: " + miniTwitter.getNewsFeed(2));

    }
}