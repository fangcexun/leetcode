package hot100.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        preOrder(res, root, 0);
        return res;
    }

    public void preOrder(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        preOrder(res, node.left, level + 1);
        preOrder(res, node.right, level + 1);

    }
}
