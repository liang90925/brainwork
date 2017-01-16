317. Shortest Distance from All Buildings https://leetcode.com/problems/shortest-distance-from-all-buildings/

Difficulty: Hard
Contributors: Admin
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

Hide Company Tags Google Zenefits
Hide Tags Breadth-first Search
Hide Similar Problems (M) Walls and Gates (H) Best Meeting Point

referred to https://segmentfault.com/a/1190000004187914
这道理类似于Walls ang Gates, 解决方法也应该是从building出发进行BFS，不过这里不同的是这里需要返回最小距离和，所以我们应该一个一个的对building的点BFS，用一个二维矩阵存每个点到所有building的距离和，每次BFS，都更新相应的距离和。最后遍历那个距离和矩阵，找出最小值即可。

需要注意的是，这道题还有个条件就是empty room 必须 reach all buildings，所以我们可以用另外一个矩阵存对应empty room到building的个数，如果最终个数不等于总的building数，对应点存的距离和无效。

other: https://evanyang.gitbooks.io/leetcode/content/LeetCode/shortest_distance_from_all_buildings.html
https://discuss.leetcode.com/topic/32391/share-a-java-implement/2
