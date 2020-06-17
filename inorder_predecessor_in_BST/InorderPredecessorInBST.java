public class InorderPredecessorInBST {
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
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode predecessor = null;

        while (root != null) {
            if (p.val <= root.val) {
                root = root.left;
            } else {
                if (predecessor == null || root.val > predecessor.val) {
                    predecessor = root;
                }
                root = root.right;
            }
        }

        return predecessor;
    }

}
