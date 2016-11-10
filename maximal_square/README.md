221. Maximal Square

Difficulty: Medium
Contributors: Admin
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
Apple Airbnb Facebook

DP
referred to:
https://segmentfault.com/a/1190000003709497
http://www.jiuzhang.com/solutions/maximal-square/

rolling array的概念把O(N2)的space complexity减少成O(2n)优化了空间复杂度。
solution就是使用滚动数组的方法减少了空间复杂度。（JZQH5-2/3）
因为只需要维持两行的状态。类似题目house robber
