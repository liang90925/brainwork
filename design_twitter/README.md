355. Design Twitter   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 11840
Total Submissions: 48830
Difficulty: Medium
Contributors: Admin
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
Hide Company Tags Amazon Twitter
Hide Tags Hash Table Heap Design

references:http://blog.csdn.net/mebiuw/article/details/51781415
another simpler solution: http://blog.csdn.net/zdavb/article/details/51815685 looks like also meet the requirements,
it doesn't use the timestamp to manage the timeline, instead, it addes each tweet to the beginning of the list and just check from the beginning to get the 10 related tweets;


this http://massivealgorithms.blogspot.com/2016/06/leetcode-355-design-twitter.html contains more different kinds of solutions
other solutions:http://www.cnblogs.com/grandyang/p/5577038.html
