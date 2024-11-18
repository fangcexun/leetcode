package hot100.binaryTree;

public class LC236Opt {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;

        // 遇到了需要寻找的直接返回
        if (node == p) return p;
        if (node == q) return q;
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);

        // 如果当前节点，左右都找了，那么当前节点就是祖先
        if (left != null && right != null) {
            return node;
        }

        // 返回 left 和 right 中不为空的
        return left != null ? left : right;
    }

}
