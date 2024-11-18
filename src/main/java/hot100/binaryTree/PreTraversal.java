package hot100.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PreTraversal {
    public static void preOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.generateTree();

        List<Integer> res = new ArrayList<>();

        preOrder(root, res);

        System.out.println(res);
    }
}
