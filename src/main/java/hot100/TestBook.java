package hot100;

import java.util.Arrays;
import java.util.Comparator;

public class TestBook {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{5,2}, {3,4}};
        Arrays.sort(nums, Comparator.comparing(v -> v[0]));
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }

    }

}
