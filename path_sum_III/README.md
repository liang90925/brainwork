437. Path Sum III https://leetcode.com/problems/path-sum-iii/

Difficulty: Easy
Contributors: Stomach_ache
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
Hide Tags Tree
Hide Similar Problems (E) Path Sum (M) Path Sum II


referred to http://blog.csdn.net/mebiuw/article/details/52901592 for solution.java (recursive)

others:
http://www.cnblogs.com/grandyang/p/6007336.html
https://discuss.leetcode.com/topic/64526/17-ms-o-n-java-prefix-sum-method (prefix sum method using hashmap)
(https://discuss.leetcode.com/topic/64526/17-ms-o-n-java-prefix-sum-method/15)
