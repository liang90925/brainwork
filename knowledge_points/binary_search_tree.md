A Binary Search Tree (BST) is a tree in which all the nodes follow the bellow mentioned properties -
 -- the left sub-tree of a node has a key less than or equal to it's parent node's key
 -- the right sub-tree of a node has a key greater than or equal to it's parent node's key
BST can be defined as:
left_subtree (keys) <= node (key) <= right_subtree (keys)

complexity
        average    worst_case
space     O(n)        O(n)
search    O(logn)     O(n)
insert    O(logn)     O(n)
delete    O(logn)     O(n)


referred to :
https://www.tutorialspoint.com/data_structures_algorithms/binary_search_tree.htm
https://en.wikipedia.org/wiki/Binary_search_tree
