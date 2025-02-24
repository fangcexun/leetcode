package hot100.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        preOrder(new boolean[nums.length], nums, new ArrayList<>(), res);
        return res;
    }

    private void preOrder(boolean[] used, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            preOrder(used, nums, path, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC47 lc47 = new LC47();
        int[] nums = new int[]{1,1};

        System.out.println(lc47.permuteUnique(nums));
    }
}
