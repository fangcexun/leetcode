package hot100.doubleIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 这个判断逻辑没想到，i - 1 表示需要让 i 的时候去判断一次
            // 写成 nums[i] == nums[i + 1] continue 的话，-1 -1 2 这样的就会被跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int remain = -nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while(right - left >= 1) {

                if (nums[left] + nums[right] == remain) {
                    addToResult(res, nums, i, left, right);

                    while (right - left >= 1) {
                        if (nums[left] == nums[left + 1]) {
                            left++;
                            continue;
                        }

                        if (nums[right] == nums[right - 1]) {
                            right--;
                            continue;
                        }
                        left++;
                        right--;
                        break;
                    }
                    continue;
                }

                if (nums[left] + nums[right] < remain) {
                    left++;
                    continue;
                }

                if (nums[left] + nums[right] > remain) {
                    right--;
                }
            }

        }

        return res;
    }

    private static void addToResult(List<List<Integer>> res, int[] nums, int i, int left, int right) {
        List<Integer> subRes = new ArrayList<>();
        subRes.add(nums[i]);
        subRes.add(nums[left]);
        subRes.add(nums[right]);
        res.add(subRes);
    }
}
