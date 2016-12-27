/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class BSTIterator {

  private Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    pushLeft(stack, root);
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode curr = stack.pop();
    pushLeft(stack, curr.right);

    return curr.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
    return;
  }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
