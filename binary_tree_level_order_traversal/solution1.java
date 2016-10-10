/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // use two queues or one queue

 public class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {

     List<List<Integer>> result = new ArrayList<>();
     if (root == null) {
       return result;
     }

     Queue<TreeNode> l1 = new LinkedList<>();
     Queue<TreeNode> l2 = new LinkedList<>();
     l1.offer(root);

     while (!l1.isEmpty()) {
       l2.clear();
       List<Integer> singleLevel = new ArrayList<>();
       while (!l1.isEmpty()) {
         TreeNode curr = l1.poll();
         singleLevel.add(curr.val);
         if (curr.left != null) {
           l2.offer(curr.left);
         }
         if (curr.right != null) {
           l2.offer(curr.right);
         }
       }
       Queue<TreeNode> temp = l1;
       l1 = l2;
       l2 = temp;
       result.add(singleLevel);
     }
     return result;
   }
 }


 public class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {

     List<List<Integer>> result = new ArrayList<>();
     if (root == null) {
       return result;
     }

     Queue<TreeNode> l1 = new LinkedList<>();
     l1.offer(root);

     while (!l1.isEmpty()) {
       Queue<TreeNode> l2 = new LinkedList<>();
       List<Integer> singleLevel = new ArrayList<>();
       while (!l1.isEmpty()) {
         TreeNode curr = l1.poll();
         singleLevel.add(curr.val);
         if (curr.left != null) {
           l2.offer(curr.left);
         }
         if (curr.right != null) {
           l2.offer(curr.right);
         }
       }
       l1 = l2;
       result.add(singleLevel);
     }
     return result;
   }
 }
