package hot100.doubleIndex;

import java.util.Arrays;

public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int index = m + n - 1;

        while (left >= 0 && right >= 0) {
            if (nums1[left] >= nums2[right]) {
                swap(nums1, left--, index--);
            } else {
                nums1[index--] = nums2[right--];
            }
        }

        while (right >= 0) {
            nums1[index--] = nums2[right--];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC88 lc88 = new LC88();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        lc88.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
