import java.util.ArrayList;
import java.util.List;

public class MyTreeNode {

    private int val;
    private List<MyTreeNode> children;
    private boolean deleted;

    /**
     * @param val: the val of the node
     * @return: a MyTreeNode Object
     */
    MyTreeNode(int val) {
        // write your code here
        this.val = val;
        this.children = new ArrayList<>();
        this.deleted = false;
    }

    /**
     * @param root: the root treenode
     * @return: get the traverse of the treenode
     */
    public ArrayList<Integer> traverse(MyTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverseHelper(root, result);
        return result;
    }

    public void traverseHelper(MyTreeNode root, ArrayList<Integer> result) {
        if (!root.deleted) {
            result.add(root.val);
        }
        for (MyTreeNode child : root.children) {
            traverseHelper(child, result);
        }
    }

    /**
     * @param root: the node where added
     * @param value: the added node's value
     * @return: add a node, return the node
     */
    public MyTreeNode addNode(MyTreeNode root, int value) {
        // write your code here
        MyTreeNode node = new MyTreeNode(value);
        root.children.add(node);
        return node;
    }

    /**
     * @param root: the deleted node
     * @return: nothing
     */
    public void deleteNode(MyTreeNode root) {
        // write your code here
        root.deleted = true;
    }
}