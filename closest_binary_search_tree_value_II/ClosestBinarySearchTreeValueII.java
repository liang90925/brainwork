import com.sun.corba.se.impl.ior.ObjectIdImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//最优算法，时间复杂度 O(k + logn)  空间复杂度 O(logn)
public class ClosestBinarySearchTreeValueII {
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
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> smaller = new Stack<>();
        Stack<TreeNode> bigger = new Stack<>();

        // Initiate stack
        while (root != null) {
            if (root.val <= target) {
                smaller.push(root);
                root = root.right;
            } else {
                bigger.push(root);
                root = root.left;
            }
        }

        while (k-- > 0) {
            if (bigger.isEmpty()
                    || (!smaller.isEmpty() && target-smaller.peek().val < bigger.peek().val-target)) {
                results.add(smaller.peek().val);
                getMoreSmaller(smaller);
            } else {
                results.add(bigger.peek().val);
                getMoreBigger(bigger);
            }
        }

        return results;
    }
    private void getMoreSmaller(Stack<TreeNode> smallerStack) {
        TreeNode node = smallerStack.pop();
        if (node.left != null) {
            smallerStack.push(node.left);
            while(smallerStack.peek().right != null) {
                smallerStack.push(smallerStack.peek().right);
            }
        }
    }

    private void getMoreBigger(Stack<TreeNode> biggerStack) {
        TreeNode node = biggerStack.pop();
        if (node.right != null) {
            biggerStack.push(node.right);
            while(biggerStack.peek().left != null) {
                biggerStack.push(biggerStack.peek().left);
            }
        }
    }

}
