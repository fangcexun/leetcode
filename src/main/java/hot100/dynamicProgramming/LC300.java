package hot100.dynamicProgramming;

import hot100.slidingWindow.LC3;

import java.util.ArrayList;
import java.util.List;

public class LC300 {
    private int maxLength = 0;
    public int lengthOfLIS(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            preOrder(i, nums, new ArrayList<>());
        }

        return maxLength;
    }

    private void preOrder(int index, int[] nums, List<Integer> path) {
        if (index == nums.length - 1) {
            path.add(nums[index]);
            maxLength = Math.max(maxLength, path.size());
//            System.out.println(path);
            return;
        }

        path.add(nums[index]);
        System.out.println(path);

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] >= nums[i]) {
                maxLength = Math.max(maxLength, path.size());
                continue;
            }
            preOrder(i, nums, path);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        LC300 lc300 = new LC300();
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lc300.lengthOfLIS(nums));
    }
}
