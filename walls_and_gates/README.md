286. Walls and Gates
https://leetcode.com/problems/walls-and-gates/

Difficulty: Medium
Contributors: Admin
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
Hide Company Tags Google Facebook
Hide Tags Breadth-first Search
Hide Similar Problems (M) Surrounded Regions (M) Number of Islands (H) Shortest Distance from All Buildings


BFS referred to : http://www.jiuzhang.com/solutions/walls-and-gates/
DFS referred to : http://www.cnblogs.com/grandyang/p/5285868.html 解法二


others：
http://www.cnblogs.com/yrbbest/p/5038632.html
http://blog.csdn.net/xudli/article/details/48748547