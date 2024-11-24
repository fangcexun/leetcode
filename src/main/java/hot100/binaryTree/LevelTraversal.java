package hot100.binaryTree;

import java.util.*;

public class LevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currLevelRes = new ArrayList<>();
            int currSize = queue.size();

            // 因为是遍历，所以这个 for 做的事情：
            // 1. 把当前 level 的数值放到 res 里；2. 把当前 level 下的子节点放到 queue 中
            for (int i = 0; i < currSize; i++) {
                TreeNode curr = queue.poll();
                currLevelRes.add(curr.val);

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            res.add(currLevelRes);
        }
        return res;
    }

    public static void main(String[] args) {
        LevelTraversal levelTraversal = new LevelTraversal();

        TreeNode treeNode = BinaryTree.generateTree();
        System.out.println(levelTraversal.levelOrder(treeNode));
    }
}
