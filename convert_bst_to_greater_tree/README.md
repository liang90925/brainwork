https://www.lintcode.com/problem/convert-bst-to-greater-tree


中文English
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example
Example 1:

Input : {5,2,13}
              5
            /   \
           2     13
Output : {18,20,13}
             18
            /   \
          20     13
Example 2:

Input : {5,3,15}
              5
            /   \
           3     15
Output : {20,23,15}
             20
            /   \
          23     15

https://www.jiuzhang.com/solution/convert-bst-to-greater-tree/

Note, BST has left < key < right already
Note on how to do recursive on tree