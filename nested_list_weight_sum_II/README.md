364. Nested List Weight Sum II  
https://leetcode.com/problems/nested-list-weight-sum-ii/

Difficulty: Medium
Contributors: Admin
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

Hide Company Tags LinkedIn
Hide Tags Depth-first Search
Hide Similar Problems (E) Nested List Weight Sum

this questions is actually not that efficient to use DFS,
思路: 一种更为简单的方法，利用每一层将当前整数加起来，然后往后遍历多一层就将前面已经加过的数再加一遍．非常巧妙!
referred to : http://blog.csdn.net/qq508618087/article/details/51743408
others: https://segmentfault.com/a/1190000005937820
http://blog.csdn.net/jmspan/article/details/51747784
http://www.programcreek.com/2014/08/leetcode-nested-list-weight-sum-ii-java/
http://www.cnblogs.com/grandyang/p/5615583.html
