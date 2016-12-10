public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> que = new LinkedList<>();
    que.offer(root);

    StringBuilder sb = new StringBuilder();

    while(!que.isEmpty()) {
      TreeNode curr = que.poll();
      if (curr != null) {
        sb.append(curr.val + ",");
        que.offer(curr.left);
        que.offer(curr.right);
      } else {
        sb.append("#" + ",");
      }
    }
    String result = sb.toString();
    int j = result.length() - 1;

    while (j > 0 && result.charAt(j) == ',' && result.charAt(j - 1) == '#') {
      j -= 2;
    }

    return result.substring(0, j);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) {
      return null;
    }
    Queue<TreeNode> que = new LinkedList<>();
    String[] nodes = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    que.offer(root);

    int i = 1;
    while (!que.isEmpty() && i < nodes.length) {
      // NOTE: for each while loop, there must be two actions taken, add left and add right.
      TreeNode curr = que.poll();
      if (!nodes[i].equals("#")) {
        TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
        curr.left = node;
        que.offer(node);
      } else {
        curr.left = null;
      }
      i++;
      // NOTE: sometimes, there is only one child at the end. so check i before continue;
      if (i >= nodes.length) {
          break;
      }
      if (!nodes[i].equals("#")) {
        TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
        curr.right = node;
        que.offer(node);
      } else {
        curr.right = null;
      }
      i++;
    }
    return root;
  }
}
