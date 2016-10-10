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
  //  the val in root and root->left->right and root->right->left is in the same List
  // so use an indexMap to store the index as key and list of integers in that index as value;
  // start with root, index = 0; things at root left is index - 1, and at root right is index + 1;
  // also introduced a queue with new class: Position that includes the node and the index(column)
  

 public class Solution {
   public class Position {
     int column;
     TreeNode node;
     public Position(TreeNode node, Integer column) {
       this.column = column;
       this.node = node;
     }
   }

   public List<List<Integer>> verticalOrder(TreeNode root) {
     List<List<Integer>> result = new ArrayList<>();
     if (root == null) {
       return result;
     }
     int min = Integer.MAX_VALUE;
     int max = Integer.MIN_VALUE;

     Map<Integer, List<Integer>> indexMap = new HashMap<>();
     Queue<Position> positionQ = new LinkedList<>();

     positionQ.offer(new Position(root, 0));

     while(!positionQ.isEmpty()) {
       Position position = positionQ.poll();
       int index = position.column;
       min = Math.min(min, index);
       max = Math.max(max, index);
       TreeNode curr = position.node;
       List<Integer> level = indexMap.get(index);
       if (level == null) {
         level = new ArrayList<>();
         indexMap.put(index, level);
       }
       level.add(curr.val);
       if (curr.left != null) {
         positionQ.offer(new Position(curr.left, index - 1));
       }
       if (curr.right != null) {
         positionQ.offer(new Position(curr.right, index + 1));
       }
     }
     for (int i = min; i <= max; i++) {
       List<Integer> level = indexMap.get(i);
       if (level != null) {
         result.add(level);
       }
     }
     return result;
   }
 }
