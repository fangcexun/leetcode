package hot100.sort;

import hot100.Utils;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{5,1,1,2,0,0};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(array, left, right);
        sort(array, left, pivotIndex - 1);
        sort(array, pivotIndex + 1, right);
    }

    // left 和 right 为 Index
    public static int partition(int[] array, int left, int right) {
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        int pivot = array[pivotIndex];
        // lastPosition 最终指向的是第一个比 pivot 大的数
        int lastPosition = left;

        // 边界条件要注意，不比较 pivotIndex，要不然 lastPosition 会往后移动一个
        for (int i = left; i <= right; i++) {
            if (array[i] < pivot) {
                Utils.swap(array, i, lastPosition);
                lastPosition++;
            }
        }
        Utils.swap(array, lastPosition, pivotIndex);
        return lastPosition;
    }
}
