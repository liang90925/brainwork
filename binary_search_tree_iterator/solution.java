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
  private TreeNode curr;
  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    curr = root;

  }

  /** @return the next smallest number */
  public int next() {
    while (curr != null) {
      stack.push(curr);
      curr = curr.left;
    }
    curr = stack.pop();
    int result = curr.val;
    curr = curr.right;

    return result;

  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return (curr != null || !stack.isEmpty());
  }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
