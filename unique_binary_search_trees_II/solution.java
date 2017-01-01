/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
   public List<TreeNode> generateTrees(int n) {
     if (n <= 0) {
       return Collections.emptyList();
     }
     return buildTree(1, n);
   }

   private List<TreeNode> buildTree(int left, int right) {
     List<TreeNode> result = new ArrayList<>();
     if (left > right) {
       result.add(null);
       return result;
     }

     // For 循环表示 循环以i为root的 tree，找到 (left, i - 1) 和 (i + 1， right) 组成的tree
     for (int i = left; i <= right; i++) {
       List<TreeNode> lefts = buildTree(left, i - 1);
       List<TreeNode> rights = buildTree(i + 1, right);

       for (int j = 0; j < lefts.size(); j++) {
         for (int k = 0; k < rights.size(); k++) {
           TreeNode root = new TreeNode(i);
           root.left = lefts.get(j);
           root.right = rights.get(k);
           result.add(root);
         }
       }
     }
     return result;
   }
 }
