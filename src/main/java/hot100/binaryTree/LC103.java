package hot100.binaryTree;

import java.util.*;

public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        preOrder(root, res, 1);

        for (int i = 1; i < res.size(); i = i + 2) {
            Collections.reverse(res.get(i));
        }

        return res;
    }

    public void preOrder(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }

        if (res.size() < level) {
            res.add(new ArrayList<>());
        }

        res.get(level - 1).add(node.val);

        preOrder(node.left, res, level + 1);
        preOrder(node.right, res, level + 1);
    }
}

class LC103QueueSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // 对于 LinkedList，由于其没有容量限制，两者的行为是非常相似的。
        // 你可以根据你的编程风格选择使用 offer() 或 add()，
        // 但是一般来说，如果你不想在队列操作失败时抛出异常，offer() 会更安全一些。
        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty()) {
            List<Integer> currLevelRes = new ArrayList<>();
            int currSize = queue.size();

            // 对当前 level 做两件事：1. 把当前 node 值放到 res 里；2. 把下一层的放入 queue
            for (int i = 0; i < currSize; i++) {
                TreeNode curr = queue.poll();

                // queue 里永远是从左到右的节点，添加 currLevelRes 的时候，如果是偶数 level 需要头插插入节点
                if (level % 2 == 1) {
                    currLevelRes.add(curr.val);
                } else {
                    currLevelRes.add(0, curr.val);
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res.add(currLevelRes);
            level++;
        }

        return res;
    }
}
