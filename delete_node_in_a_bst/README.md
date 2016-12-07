450. Delete Node in a BST
https://leetcode.com/problems/delete-node-in-a-bst/
Difficulty: Medium
Contributors: tsipporah5945
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
Hide Company Tags Uber
Hide Tags Tree

referred to: http://www.jiuzhang.com/solutions/remove-node-in-binary-search-tree/

if have time try other solutions:
https://lefttree.gitbooks.io/leetcode/content/binaryTree/removeNodeInBST.html
http://www.cnblogs.com/easonliu/p/4634419.html
http://hehejun.blogspot.com/2015/01/lintcoderemove-node-in-binary-search.html
