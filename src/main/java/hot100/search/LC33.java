package hot100.search;

import java.util.Arrays;

public class LC33 {
    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (mid == left) {
            return search(nums, mid + 1, right, target);
        }

        if (mid == right) {
            return binarySearch(nums, left, mid - 1, target);
        }

        // 左有序，右无序
        if (nums[left] <= nums[mid - 1]) {
            if (target >= nums[left] && target <= nums[mid - 1]) {
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return search(nums, mid + 1, right, target);
            }
        }

        // 左无序，右有序
        if (target >= nums[mid + 1] && target <= nums[right]) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return search(nums, left, mid - 1, target);
        }

    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (target > nums[mid]) {
            return binarySearch(nums, mid + 1, right, target);
        }

        return binarySearch(nums, left, mid - 1, target);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};

        System.out.println(search(nums, 5));
        System.out.println(search(nums, 6));
        System.out.println(search(nums, 7));
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 1));
        System.out.println(search(nums, 2));
        System.out.println(search(nums, 100));
    }
}
