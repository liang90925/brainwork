/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // BFS with one queue

 public class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {

     List<List<Integer>> result = new ArrayList<>();
     if (root == null) {
       return result;
     }

     Queue<TreeNode> l1 = new LinkedList<>();
     l1.offer(root);

     while (!l1.isEmpty()) {
       int size = l1.size();
       List<Integer> singleLevel = new ArrayList<>();
       while (size-- > 0) {
         TreeNode curr = l1.poll();
         singleLevel.add(curr.val);
         if (curr.left != null) {
           l1.offer(curr.left);
         }
         if (curr.right != null) {
           l1.offer(curr.right);
         }
       }
       result.add(singleLevel);
     }
     return result;
   }
 }
