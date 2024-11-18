package hot100.binaryTree;

public class LC236 {
    public TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postOrder(root, p, q);
        return res;
    }

    public boolean postOrder(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || res != null) {
            return false;
        }

        boolean leftFound = postOrder(node.left, p, q);
        boolean rightFound = postOrder(node.right, p, q);

        if (leftFound && rightFound) {
            res = node;
        }

        boolean currFound = node.val == p.val || node.val == q.val;

        if ((leftFound || rightFound) && currFound) {
            res = node;
        }

        return currFound || leftFound || rightFound;
    }
}
