package hot100.binaryTree;

public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }

    public TreeNode create(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = create(nums, left, mid - 1);
        midNode.right = create(nums, mid + 1, right);

        return midNode;
    }
}
