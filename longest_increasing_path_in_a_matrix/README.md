329. Longest Increasing Path in a Matrix   
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

Difficulty: Hard
Contributors: Admin
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Hide Company Tags Google
Hide Tags Depth-first Search Topological Sort Memoization

referred to :
http://buttercola.blogspot.com/2016/06/leetcode-329-longest-increasing-path-in.html
used DFS + DP(Memorization)

if have time can also check this solution using the concept of graph:
https://discuss.leetcode.com/topic/35021/graph-theory-java-solution-o-v-2-no-dfs/2
http://www.allenlipeng47.com/blog/index.php/2016/01/22/longest-increasing-path-in-a-matrix/
https://github.com/allenlipeng47/algorithm/blob/master/src/main/java/com/pli/project/algorithm/array/LongestIncreasingPath.java

others:
http://www.programcreek.com/2014/05/leetcode-longest-increasing-path-in-a-matrix-java/
https://segmentfault.com/a/1190000007324191
https://www.hrwhisper.me/leetcode-longest-increasing-path-matrix/
