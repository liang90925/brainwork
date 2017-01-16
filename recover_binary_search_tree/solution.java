/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  private TreeNode firstElement = null;
  private TreeNode secondElement = null;
  private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);

  public void recoverTree(TreeNode root) {
    // find the two element that were swapped
    traverse(root);
    // swap the find two elements
    int temp = secondElement.val;
    secondElement.val = firstElement.val;
    firstElement.val = temp;

  }
  // this is similar to inorder traverse;
  private void traverse(TreeNode root) {
    if (root == null) {
      return;
    }
    traverse(root.left);
    if (root.val < lastElement.val && firstElement == null) {
      firstElement = lastElement;
    }
    if (root.val < lastElement.val && firstElement != null) {
      secondElement = root;
    }
    //!!!!!!!! assing lastElement to current root
    lastElement = root;
    traverse(root.right);
  }
}
