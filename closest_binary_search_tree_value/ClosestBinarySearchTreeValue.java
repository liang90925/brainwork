public class ClosestBinarySearchTreeValue {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE, target);
    }

    private int helper(TreeNode root, int max, int min, double target) {
        if (root == null) {
            if (min == Integer.MIN_VALUE) {
                return max;
            }
            if (max == Integer.MAX_VALUE) {
                return min;
            }
            if (target - min < max - target) {
                return min;
            }
            return max;
        }

        if (target > root.val) {
            return helper(root.right, max, root.val, target);
        }
        return helper(root.left, root.val, min, target);
    }
}

