package hot100.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,2,3,1,2,4,5,5,6};
        sortMax(array);
        System.out.println(Arrays.toString(array));

        sortMin(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortMax(int[] array) {
        int n = array.length;

        // 要从最下的叶子结点往上走
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMax(array, n, i);
        }


        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapifyMax(array, i, 0);
        }
    }

    public static void sortMin(int[] array) {
        int n = array.length;

        // 要从最下的叶子结点往上走
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMin(array, n, i);
        }


        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapifyMin(array, i, 0);
        }
    }

    public static void heapifyMax(int[] array, int range, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < range && array[left] > array[largest]) {
            largest = left;
        }

        if (right < range && array[right] > array[largest]) {
            largest = right;
        }

        // 只有进行了节点互换操作，才需要对换了的节点下面的树进行堆化
        if (largest != i) {
            swap(array, largest, i);
            heapifyMax(array, range, largest);
        }

    }

    public static void heapifyMin(int[] array, int range, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < range && array[left] < array[smallest]) {
            smallest = left;
        }

        if (right < range && array[right] < array[smallest]) {
            smallest = right;
        }

        // 只有进行了节点互换操作，才需要对换了的节点下面的树进行堆化
        if (smallest != i) {
            swap(array, smallest, i);
            heapifyMin(array, range, smallest);
        }

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
