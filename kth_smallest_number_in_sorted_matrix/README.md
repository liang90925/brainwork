378. Kth Smallest Element in a Sorted Matrix https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

Difficulty: Medium
Contributors: Admin
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.

Hide Company Tags Google Twitter
Hide Tags Binary Search Heap
Hide Similar Problems (M) Find K Pairs with Smallest Sums



referred to http://www.jiuzhang.com/solutions/kth-smallest-number-in-sorted-matrix/
很典型的一个二分法的难题
非常值得研究的一个题目，并且有空可以尝试一下另外一个做法

给出一个排序矩阵，行递增，列递增， 求矩阵中第k小的元素
类似于search a 2d matrix (ii)

如何用二分法优化枚举？
http://www.jiuzhang.com/solutions/kth-smallest-number-in-sorted-matrix/
