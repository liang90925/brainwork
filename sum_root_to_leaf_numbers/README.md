129. Sum Root to Leaf Numbers
https://leetcode.com/problems/sum-root-to-leaf-numbers/

Difficulty: Medium
Contributors: Admin
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Path Sum (H) Binary Tree Maximum Path Sum



referred to : http://www.jiuzhang.com/solutions/sum-root-to-leaf-numbers/
other: http://www.cnblogs.com/springfor/p/3884038.html

题解：
分析这道题，由根节点往叶节点方向走，就是从高位往地位加和的方向。也就是说，当遍历的节点往叶节点方向走一层的时候，该节点的值应为父节点的值*10+当前节点的值。
