/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // DFS with one queue
 /*
 Don't know how to solve with DFS will refer to
 http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/

 // version 2:  DFS
 // public class Solution {
 //     /**
 //      * @param root: The root of binary tree.
 //      * @return: Level order a list of lists of integer
 //      **/
 //     public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
 //         ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
 //
 //         if (root == null) {
 //             return results;
 //         }
 //
 //         int maxLevel = 0;
 //         while (true) {
 //             ArrayList<Integer> level = new ArrayList<Integer>();
 //             dfs(root, level, 0, maxLevel);
 //             if (level.size() == 0) {
 //                 break;
 //             }
 //
 //             results.add(level);
 //             maxLevel++;
 //         }
 //
 //         return results;
 //     }
 //
 //     private void dfs(TreeNode root,
 //                      ArrayList<Integer> level,
 //                      int curtLevel,
 //                      int maxLevel) {
 //         if (root == null || curtLevel > maxLevel) {
 //             return;
 //         }
 //
 //         if (curtLevel == maxLevel) {
 //             level.add(root.val);
 //             return;
 //         }
 //
 //         dfs(root.left, level, curtLevel + 1, maxLevel);
 //         dfs(root.right, level, curtLevel + 1, maxLevel);
 //     }
 // }

 */
 public class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {

   }
 }
