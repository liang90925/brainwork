96. Unique Binary Search Trees  
https://leetcode.com/problems/unique-binary-search-trees/

Difficulty: Medium
Contributors: Admin
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Hide Company Tags Snapchat
Hide Tags Tree Dynamic Programming
Hide Similar Problems (M) Unique Binary Search Trees II

referred to:
http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html (good explanation)
http://www.jiuzhang.com/solutions/unique-binary-search-trees/

当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。
