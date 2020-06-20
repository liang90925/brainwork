public class DiameterOfBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    int max =0;

    /**
     * @param root: a root of binary tree
     * @return: return a integer
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // write your code here
        helper(root);
        return max;
    }

    // The return value is the max single path
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSinglePathMax = helper(root.left);
        int rightSinglePathMax = helper(root.right);

        max = Math.max(max, leftSinglePathMax + rightSinglePathMax);
        return Math.max(leftSinglePathMax, rightSinglePathMax) + 1;

    }
}
