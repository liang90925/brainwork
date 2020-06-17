public class ConvertBSTToGreaterTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: the root of binary tree
     * @return: the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }
        treeHelper(root, 0);
        return root;
    }

    private int treeHelper(TreeNode root, int now_sum) {
        if (root == null) {
            return now_sum;
        }
        int valWithRightPart = treeHelper(root.right, now_sum);

        root.val += valWithRightPart;
        valWithRightPart = root.val;

        int sumOfSubTree = treeHelper(root.left, valWithRightPart);
        return sumOfSubTree;

    }
}
