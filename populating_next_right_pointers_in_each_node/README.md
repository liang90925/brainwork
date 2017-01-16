116. Populating Next Right Pointers in Each Node   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 114382
Total Submissions: 310421
Difficulty: Medium
Contributors: Admin
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
Hide Company Tags Microsoft
Hide Tags Tree Depth-first Search
Hide Similar Problems

refer to http://www.jiuzhang.com/solutions/populating-next-right-pointers-in-each-node/
https://siddontang.gitbooks.io/leetcode-solution/content/tree/populating_next_right_pointers_in_each_node.html
