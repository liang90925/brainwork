/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class ValidBinarySearchTree {
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

  class ResultType {
    boolean is_bst;
    int maxValue, minValue;
    ResultType(boolean is_bst, int maxValue, int minValue) {
      this.is_bst = is_bst;
      this.maxValue = maxValue;
      this.minValue = minValue;
    }
  }

  public boolean isValidBST(TreeNode root) {
    ResultType r = validateHelper(root);
    return r.is_bst;
  }
  private ResultType validateHelper(TreeNode root) {
    if (root == null) {
      return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    ResultType left = validateHelper(root.left);
    ResultType right = validateHelper(root.right);

    if (!left.is_bst || !right.is_bst) {
      // if is_bst is false then minValue and maxValue are useless
      return new ResultType(false, 0, 0);
    }

    if ((root.left != null && left.maxValue >= root.val) ||
        (root.right != null && right.minValue <= root.val)) {
      return new ResultType(false, 0, 0);
    }

    return new ResultType(true,
                          Math.max(root.val, right.maxValue),
                          Math.min(root.val, left.minValue));
  }
}
