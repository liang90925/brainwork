public class Tweet {
    public int id;
    public int user_id;
    public String text;
    public Tweet(int _user_id, String _tweet_text, int _timestamp) {
        this.user_id = _user_id;
        this.text = _tweet_text;
        this.id = _timestamp;
    }
    public static Tweet create(int _user_id, String _tweet_text, int _timestamp) {
        // This will create a new tweet object,
        // and auto fill id
        return new Tweet(_user_id, _tweet_text, _timestamp);
    }

    public String toString() {
        return "id: " + id + ", user_id: " + user_id + ", text: " + text;
    }
}