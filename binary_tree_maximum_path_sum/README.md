124. Binary Tree Maximum Path Sum https://leetcode.com/problems/binary-tree-maximum-path-sum/


Difficulty: Hard
Contributors: Admin
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

Hide Company Tags Microsoft Baidu
Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Path Sum (M) Sum Root to Leaf Numbers

referred to : http://www.jiuzhang.com/solutions/binary-tree-maximum-path-sum/
https://www.jiuzhang.com/solution/binary-tree-maximum-path-sum/#tag-highlight-lang-java
最主要的是要搞清楚 在一个root点 什么样的情况下才是最大的
chose between
<maxPathLeft, maxPathRight, maxSinglePathLeft + maxSingelPathRight + root.val>
maxSinglePath = < <leftsinglePath, rightSinglePath> + root.val, 0  > since singlePath does not need to contain  anything
