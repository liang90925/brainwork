380. Insert Delete GetRandom O(1)
https://leetcode.com/problems/insert-delete-getrandom-o1/

Difficulty: Hard
Contributors: Admin
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 1 is the only number in the set, getRandom always return 1.
randomSet.getRandom();
Hide Company Tags Google Uber Twitter Amazon Yelp Pocket Gems Facebook
Hide Tags Array Hash Table Design
Hide Similar Problems (H) Insert Delete GetRandom O(1) - Duplicates allowed

referred to:
http://blog.csdn.net/newpidian/article/details/52165221
http://www.programcreek.com/2014/08/leetcode-insert-delete-getrandom-o1-java/
http://blog.csdn.net/yeqiuzs/article/details/52141124

how to use Random https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
