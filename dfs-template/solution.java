// Binary tree dfs template

// template 1 Traverse
public class Solution {
  public void traverse(TreeNode root) {
    if (root == null) {
      return;
    }
    // do something with root

    traverse(root.left);

    // do something with root

    traverse(root.right);

    // do something with root
  }
}

// template 2: divide and conqure
public class Solution {
  public ResultType traversal(TreeNode root) {
    // null or leaf
    if (root == null) {
      // do someting and return;
    }

    //divide
    ResultType left = traversal(root.left);
    ResultType right = traversal(root.right);

    //conqure
    ResultType result = merge from left and right;
    return result;
  }
}
