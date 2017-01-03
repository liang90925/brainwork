417. Pacific Atlantic Water Flow  
https://leetcode.com/problems/pacific-atlantic-water-flow/

Difficulty: Medium
Contributors: Admin
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
Hide Company Tags Google
Hide Tags Depth-first Search Breadth-first Search

refer to : http://www.itdadao.com/articles/c15a556374p0.html and https://discuss.leetcode.com/topic/62280/simple-commented-java-solution-with-thinking-progress-o-n/2
for solution_dfs.java
some of them doesn't need to use the visited 2d array, check following blogs for reference; https://discuss.leetcode.com/topic/62585/java-17ms-solution-simple-and-clear-similar-to-number-of-islands-s-idea/2
http://blog.csdn.net/mebiuw/article/details/52766269

refer to : https://discuss.leetcode.com/topic/62379/java-bfs-dfs-from-ocean
for solution_bfs.java
