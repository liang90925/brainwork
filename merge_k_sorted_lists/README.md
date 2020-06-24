23. Merge k Sorted Lists  (非常好的一题)
https://www.lintcode.com/problem/merge-k-sorted-lists

Difficulty: Hard
Contributors: Admin
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

LinkedIn Google Uber Airbnb Facebook Twitter Amazon Microsoft

solutions: referred to: http://www.jiuzhang.com/solutions/merge-k-sorted-lists/
1. bisection method and use merge two sorted list to merge.
二分法的base 复杂度 O(log2n) (以2为底) O(logN) referred to: http://blog.csdn.net/frances_han/article/details/6458067

referred: http://blog.csdn.net/linhuanmars/article/details/19899259
time complexity: O(nklogk)
space complexity: O(k)

2. heap solution. use priorityQueue to add and sort.
 PriorityQueue provides O(log(n)) time for the enqueuing and dequeuing methods (offer(), poll(), remove() and add()); linear time for the remove(Object) and contains(Object) methods; and constant time for the retrieval methods (peek, element, and size).

 referred: http://blog.csdn.net/linhuanmars/article/details/19899259
 time complexity: O(nklogk)
 space complexity: O(k)

https://www.jiuzhang.com/solution/merge-k-sorted-lists/#tag-highlight-lang-java

others:
http://www.cnblogs.com/springfor/p/3869217.html
http://www.lifeincode.net/programming/leetcode-merge-k-sorted-lists-java/
https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
https://zh.wikipedia.org/wiki/%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2%E7%AE%97%E6%B3%95
https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F
