/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // using two Lists
 public class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {

     List<List<Integer>> result = new ArrayList<>();
     if (root == null) {
       return result;
     }

     List<TreeNode> l1 = new ArrayList<>();
     List<TreeNode> l2 = new ArrayList<>();
     l1.add(root);

     while (!l1.isEmpty()) {
       l2.clear();
       List<Integer> singleLevel = new ArrayList<>();
       for (int i = 0; i < l1.size(); i++) {
         TreeNode curr = l1.get(i);
         singleLevel.add(curr.val);
         if (curr.left != null) {
           l2.add(curr.left);
         }
         if (curr.right != null) {
           l2.add(curr.right);
         }
       }
       List<TreeNode> temp = l1;
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
