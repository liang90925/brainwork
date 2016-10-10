314. Binary Tree Vertical Order Traversal  QuestionEditorial Solution  My

Difficulty: Medium
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
Google Snapchat Facebook


solution referred to : http://blog.csdn.net/jmspan/article/details/51216866
The val in root and root->left->right and root->right->left is in the same List
so use an indexMap to store the index as key and list of integers in that index as value;
start with root, index = 0; things at root left is index - 1, and at root right is index + 1;
also introduced a queue with new class: Position that includes the node and the index(column)

other blogs can be checked:
http://blog.csdn.net/u012175043/article/details/50201133
http://massivealgorithms.blogspot.com/2015/12/leetcode-314-binary-tree-vertical-order.html
