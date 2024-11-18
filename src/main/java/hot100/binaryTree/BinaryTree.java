package hot100.binaryTree;

public class BinaryTree {

    // 插入左子节点
    public void insertLeft(TreeNode node, int value) {
        node.left = new TreeNode(value);
    }

    // 插入右子节点
    public void insertRight(TreeNode node, int value) {
        node.right = new TreeNode(value);
    }

    // 中序遍历
    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);  // 遍历左子树
            System.out.print(node.val + " ");  // 打印节点值
            inOrderTraversal(node.right);  // 遍历右子树
        }
    }

    public TreeNode generateTree() {
        BinaryTree tree = new BinaryTree(); // 创建根节点值为10的二叉树
        TreeNode root = new TreeNode(0);  // 获取根节点

        // 插入节点
        tree.insertLeft(root, 5);
        tree.insertRight(root, 15);
        tree.insertLeft(root.left, 3);
        tree.insertRight(root.left, 7);
        tree.insertLeft(root.right, 12);
        tree.insertRight(root.right, 18);

//                  0
//                /  \
//               5    15
//              / \   /  \
//             3   7 12  18

        return root;
    }

    public static void main(String[] args) {

    }
}
