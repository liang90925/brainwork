366. Find Leaves of Binary Tree  
https://leetcode.com/problems/find-leaves-of-binary-tree/

Difficulty: Medium
Contributors: Admin
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         /
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].

Hide Company Tags LinkedIn
Hide Tags Tree Depth-first Search

referred to https://segmentfault.com/a/1190000005938045 for solution_recursive.java
利用了深度的概念， 例如最底下的leaf 他们的子数都是null，所以他们应该 是 -1 + 1 = 0；
然后递归到上层，的话应该是左右字数最大值 + 1， ex： 对于1而言，左边是2的level 是1， 右边3的level是0
所以1得level应该是max（1， 0） + 1 = 2， 也是result中1 存放的数组的index
