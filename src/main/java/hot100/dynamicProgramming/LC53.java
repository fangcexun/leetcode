package hot100.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LC53 {
    private static int largest = 0;

    // 如果 extra 要输出最大数值对应的 index
    private static List<Integer> indexList = new ArrayList<>();

    public static int maxSubArray(int[] nums) {
        maxNext(0, nums);
        return largest;
    }

    public static int maxNext(int index, int[] nums) {
        if (index == nums.length - 1) {
            largest = nums[index];
            return nums[index];
        }
        // 递归到最后，以 1 -5 4 为例子，当指向 1 的时候，最大值等于 1 + 1(右侧的最大)，1 右侧最大的值是 -1
        int res = Math.max(nums[index], nums[index] + maxNext(index + 1, nums));
        largest = Math.max(largest, res);
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
        System.out.println(largest);
    }
}
