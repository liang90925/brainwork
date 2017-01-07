/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // divide and conqure
public class Solution {
  public void flatten(TreeNode root) {
    flattenHelper(root);
  }
  private TreeNode flattenHelper(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      return root;
    }
    if (root.left == null) {
      // 去下一新root
      return flattenHelper(root.right);
    }
    if (root.right == null) {
      root.right = root.left;
      root.left = null;
      // 去下一新root
      return flattenHelper(root.right);
    }

    // when all left and right node all exist, divide the problem to left and right;
    TreeNode leftNode = flattenHelper(root.left);
    TreeNode rightNode = flattenHelper(root.right);

    leftNode.right = root.right;
    // 注意此处一定是root.right = root.left 而不是指向leftNode！！！！！！！！走一遍就知道为什么了
    root.right = root.left;
    root.left = null;
    // 每次都是return的rightNode所以已经自动track了左字数的最右
    return rightNode;
  }
}
