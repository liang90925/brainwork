public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class ResultTrack {
        int singlePath;
        int maxPath;
        public ResultTrack(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        ResultTrack result = helper(root);
        return result.maxPath;
    }

    public ResultTrack helper(TreeNode root) {
        if (root == null) {
            return new ResultTrack(0, Integer.MIN_VALUE);
        }
        ResultTrack left = helper(root.left);
        ResultTrack right = helper(root.right);

        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultTrack(singlePath, maxPath);
    }
}

