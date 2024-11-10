package hot100.heap;

import hot100.sort.HeapSort;

public class LC215 {

    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(array, 4));
    }

    public static int findKthLargest(int[] array, int k) {
        int n = array.length;

        for (int i = n / 2; i >= 0; i--) {
            HeapSort.heapifyMax(array, n, i);
        }

        for (int i = n - 1; i > n - k; i--) {
            HeapSort.swap(array, i, 0);
            HeapSort.heapifyMax(array, i, 0);
        }

        return array[0];
    }
}
