25. Reverse Nodes in k-Group  QuestionEditorial Solution  My Submissions

Difficulty: Hard
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Microsoft Facebook


referred answer: http://www.jiuzhang.com/solutions/reverse-nodes-in-k-group/

working in k sets. and return the head to check whether to be in the loop or not/
also need to check if it meets the k set or not.
