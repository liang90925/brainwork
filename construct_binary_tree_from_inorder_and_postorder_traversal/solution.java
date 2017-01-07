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
  private int findPosition(int[]inorder, int ioStart, int ioEnd, int rootVal) {
    for (int i = ioStart; i <= ioEnd; i++) {
      if (inorder[i] == rootVal) {
        return i;
      }
    }
    return -1;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length) {
      return null;
    }
    return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private TreeNode dfs(int[] inorder, int ioStart, int ioEnd, int[] postorder, int poStart, int poEnd) {
    if (ioStart > ioEnd) {
      return null;
    }
    int rootVal = postorder[poEnd];
    TreeNode root = new TreeNode(rootVal);
    int rootPosInIo = findPosition(inorder, ioStart, ioEnd, rootVal);
    root.left = dfs(inorder, ioStart, rootPosInIo - 1, postorder, poStart, poStart + rootPosInIo - ioStart - 1);
    root.right = dfs(inorder, rootPosInIo + 1, ioEnd, postorder, poStart + rootPosInIo - ioStart, poEnd - 1);
    return root;
  }
}
