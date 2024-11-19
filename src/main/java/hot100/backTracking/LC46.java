package hot100.backTracking;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        preOrder(new ArrayList<>(), nums, res);
        return res;
    }

    public void preOrder(List<Integer> path, int[] nums, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            // 因为这个 path 是个对象，后面还会对这个 path 进行操作，所以需要新建一个对象
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }

            path.add(nums[i]);
            preOrder(path, nums, res);
            // list 的 remove 只能是按照 index 来删除
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC46 lc46 = new LC46();
        System.out.println(lc46.permute(new int[]{1, 2, 3}));
    }
}
