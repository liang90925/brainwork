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


  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (inorder == null || preorder == null || inorder.length != preorder.length) {
      return null;
    }
    return dfs(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

  private TreeNode dfs(int[] inorder, int ioStart, int ioEnd, int[] preorder, int preStart, int preEnd) {
    if (ioStart > ioEnd) {
      return null;
    }
    int rootVal = preorder[preStart];
    TreeNode root = new TreeNode(rootVal);
    int rootPosInIo = findPosition(inorder, ioStart, ioEnd, rootVal);
    root.left = dfs(inorder, ioStart, rootPosInIo - 1, preorder, preStart + 1, preStart + rootPosInIo - ioStart);
    root.right = dfs(inorder, rootPosInIo + 1, ioEnd, preorder, preStart + rootPosInIo - ioStart + 1 , preEnd);
    return root;
  }
}
