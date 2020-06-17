
https://www.lintcode.com/problem/closest-binary-search-tree-value-ii/
[LeetCode] 272. Closest Binary Search Tree Value II 最近的二分搜索树的值之二

901. Closest Binary Search Tree Value II
中文English
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Example
Example 1:

Input:
{1}
0.000000
1
Output:
[1]
Explanation：
Binary tree {1},  denote the following structure:
 1
Example 2:

Input:
{3,1,4,#,2}
0.275000
2
Output:
[1,2]
Explanation：
Binary tree {3,1,4,#,2},  denote the following structure:
  3
 /  \
1    4
 \
  2
Challenge
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Notice
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

referred to 解法5 from https://www.cnblogs.com/grandyang/p/5247398.html
refer to https://www.jiuzhang.com/solution/closest-binary-search-tree-value-ii/ only for O(n), 另外一个做法写的很不好理解还是看上面那个