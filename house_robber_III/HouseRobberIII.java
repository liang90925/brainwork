import com.sun.org.apache.regexp.internal.REUtil;

public class HouseRobberIII {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class ResultType {
        int maxInclude;
        int maxNotInclude;

        ResultType(int maxInclude, int maxNotInclude) {
            this.maxInclude = maxInclude;
            this.maxNotInclude = maxNotInclude;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        // write your code here
        ResultType resultType = helper(root);
        return Math.max(resultType.maxInclude, resultType.maxNotInclude);

    }


    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int maxInclude = root.val + left.maxNotInclude + right.maxNotInclude;
        int maxNotInclude = Math.max(left.maxInclude, left.maxNotInclude) + Math.max(right.maxInclude, right.maxNotInclude);
        return new ResultType(maxInclude, maxNotInclude);
    }

}
