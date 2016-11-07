146. LRU Cache

Difficulty: Hard
Contributors: Admin
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Google Uber Facebook Twitter Zenefits Amazon Microsoft Snapchat Yahoo Bloomberg Palantir

referred to:http://www.jiuzhang.com/solutions/lru-cache/
but the answer is not correct.
Made some change in my solution and passed the tests.

note: need to create a node class, that has prev and next node and has key, value;
also need capacity, a map that has key as key and the corresponding node as value;
also need a head and tail node.
