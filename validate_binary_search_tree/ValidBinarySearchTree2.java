/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class ValidBinarySearchTree2 {
   public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
      }
   }

  public boolean isValidBST(TreeNode root) {
    return validateHelper2(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  // This is even simpler, just check the value at root
  private boolean validateHelper2(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }

    if (root.val <= min || root.val >= max) {
      return false;
    }

    return validateHelper2(root.left, min, root.val)
            && validateHelper2(root.right, root.val, max);
  }

  private boolean validateHelper(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }

    if (root.left != null && (root.left.val >= root.val || root.left.val <= min)) {
      return false;
    }

    if (root.right != null && (root.right.val <= root.val || root.right.val >= max)) {
      return false;
    }

    return validateHelper(root.left, min, root.val) && validateHelper(root.right, root.val, max);
  }
}
