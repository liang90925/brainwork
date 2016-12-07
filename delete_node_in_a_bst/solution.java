/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
**/

public class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    // create a dummy node and point it's left to root,
    // and return dummy.left as the new root.
    TreeNode dummy = new TreeNode(0);
    dummy.left = root;

    // find the node with the key val and return it's parent node
    TreeNode parent = findNode(dummy, root, key);
    TreeNode node;

    // after finding the parent node, check and find the node with val = key
    if (parent.left != null && parent.left.val == key) {
      node = parent.left;
    } else if (parent.right != null && parent.right.val == key) {
      node = parent.right;
    } else {
      // didn't find the node with the
      return dummy.left;
    }

    // delete the node with the key val
    deleteNode(parent, node);

    return dummy.left;
  }

  private TreeNode findNode(TreeNode parent, TreeNode node, int key) {
    if (node == null) {
      return parent;
    }
    if (node.val == key) {
      return parent;
    }
    if (key < node.val) {
      return findNode(node, node.left, key);
    } else {
      return findNode(node, node.right, key);
    }
  }

  private void deleteNode(TreeNode parent, TreeNode node) {
    if (node.right == null) {
      if (parent.left == node) {
        parent.left = node.left;
      }
      if (parent.right == node) {
        parent.right = node.left;
      }
    } else {
      TreeNode temp = node.right;
      TreeNode father = node;
      while (temp.left != null) {
        father = temp;
        temp = temp.left;
      }
      if (father.left == temp) {
        father.left = temp.right;
      } else {
        father.right = temp.right;
      }

      if (parent.left == node) {
        parent.left = temp;
      } else {
        parent.right = temp;
      }

      temp.left = node.left;
      temp.right = node.right;
    }
  }
}
