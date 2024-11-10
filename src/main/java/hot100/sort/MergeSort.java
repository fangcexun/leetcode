package hot100.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] {1,4,9,5,3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void sort(int[] array) {
        sort(0, array.length - 1, array);
    }

    private static void sort(int left, int right, int[] array) {
        if (left == right) {
            return;
        }
        int mid = (right + left) / 2;
        sort(left, mid, array);
        sort(mid + 1, right, array);
        merge(left, right, array);
    }

    private static void merge(int left, int right, int[] array) {
        int mid = (right + left) / 2;

        int leftIndex = left;
        int rightIndex = mid + 1;

        int tempLength = right - left + 1;
        int[] temp = new int[tempLength];
        int tempIndex = 0;

        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] < array[rightIndex]) {
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            temp[tempIndex++] = array[leftIndex++];
        }

        while (rightIndex <= right) {
            temp[tempIndex++] = array[rightIndex++];
        }

        leftIndex = left;
        tempIndex = 0;

        while (leftIndex <= right) {
            array[leftIndex++] = temp[tempIndex++];
        }
    }
}
