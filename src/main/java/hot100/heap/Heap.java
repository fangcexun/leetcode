package hot100.heap;

public class Heap {
    private int capacity;
    private int[] heap;
    private int currentSize;

    public Heap(int capacity) {
        this.capacity = capacity;
        int[] heap = new int[capacity];
        currentSize = 0;
    }

    public void add(int value) {
        if (this.currentSize == this.capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[currentSize] = value;

        for (int i = currentSize; i > 0; i--) {

        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
