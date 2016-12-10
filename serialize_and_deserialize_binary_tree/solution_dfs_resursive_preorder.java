/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 public class Codec {
   private String SPLITER = ",";
   private String NN = "NULL";
   private void buildString(StringBuilder sb, TreeNode root) {
     if (root == null) {
       sb.append("NULL").append(SPLITER);
     } else {
       // preorder traversal; append the root's value first
       sb.append(root.val).append(SPLITER);
       buildString(sb, root.left);
       buildString(sb, root.right);
     }
   }

   // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
     StringBuilder sb = new StringBuilder();
     buildString(sb, root);
     return sb.toString();
   }

   private TreeNode BuildTree(Deque<String> nodes) {
     String node = nodes.remove();
     if (node.equals(NN)) {
       return null;
     } else {
       TreeNode root = new TreeNode(Integer.valueOf(node));
       root.left = BuildTree(nodes);
       root.right = BuildTree(nodes);
       return root;
     }
   }

   // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
     // deque这里用linkedlist为interface,其包含了几乎所有resizable array
     // NOTE: 感觉这里不需要用deque，普通的queue就可以了
     Deque<String> nodes = new LinkedList<>();
     // 这里还是挺多知识点的，String.split()后是一个String[],
     // Arrays.asList()可以把数组变成list,
     // nodes.addAll()则是把list加到nodes这个list的中去
     nodes.addAll(Arrays.asList(data.split(SPLITER)));
     return BuildTree(nodes);
   }
 }
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
