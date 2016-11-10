// binary tree BFS template
public class Solution {
  public List<List<Integer>> levelOrder(TreaNode root) {
    List<List<Integer>>  result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode head = queue.poll();
        level.add(head.val);
        if(head.left != null) {
          queue.offer(head.left);
        }
        if (head.right != null) {
          queue.offer(head.right);
        }
      }
      result.add(level);
    }

    return result;
  }
}
