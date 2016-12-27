460. LFU Cache  https://leetcode.com/problems/lfu-cache/


Difficulty: Hard
Contributors: 1337c0d3r , fishercoder
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2 /* capacity */ );

cache.set(1, 1);
cache.set(2, 2);
cache.get(1);       // returns 1
cache.set(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.set(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
Hide Company Tags Amazon Google
Hide Tags Design
Hide Similar Problems (H) LRU Cache

referred to : http://bookshadow.com/weblog/2016/11/22/leetcode-lfu-cache/

others: (有空可以看一下)
https://aaronice.gitbooks.io/lintcode/content/data_structure/lfu_cache.html

学习和比较 set/hashset/linkedhashset/hashmap/linkedhashmap 的地方：
https://github.com/CarpenterLee/JCFInternals/blob/master/markdown/7-LinkedHashSet%20and%20LinkedHashMap.md
http://www.blogs8.cn/posts/ACNI147
http://www.codingke.com/v/655-lesson-162-course
http://www.blogs8.cn/tags/LinkedHashSet
https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashSet.html

LinkedHashSet:
O(1) for the basic operations (add, contains and remove),
Iteration over a LinkedHashSet requires time proportional to the size of the set, regardless of its capacity.
