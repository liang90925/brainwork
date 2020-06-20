public class DiameterOfBinaryTreeV2 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class ResultType {
        public ResultType(int maxCrossLen, int maxSingleLen) {
            this.maxCrossLen = maxCrossLen;
            this.maxSingleLen = maxSingleLen;
        }

        int maxCrossLen;
        int maxSingleLen;

    }

    /**
     * @param root: a root of binary tree
     * @return: return a integer
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // write your code here
        ResultType maxLen = helper(root);
        return maxLen.maxCrossLen;
    }

    // The return value is the max single path
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int maxCrossLen = Math.max(
                Math.max(left.maxCrossLen, right.maxCrossLen),
                left.maxSingleLen + right.maxSingleLen);
        int maxSingleLen = Math.max(left.maxSingleLen, right.maxSingleLen) + 1;


        return new ResultType(maxCrossLen, maxSingleLen);
    }
}
