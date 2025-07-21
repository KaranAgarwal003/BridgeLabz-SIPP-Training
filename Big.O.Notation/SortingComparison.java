import java.util.*;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            int[] array = new Random().ints(size, 1, 1000000).toArray();

            // Bubble Sort (only for size <= 10,000)
            if (size <= 10000) {
                int[] bubble = array.clone();
                long start = System.nanoTime();
                bubbleSort(bubble);
                long bubbleTime = System.nanoTime() - start;
                System.out.printf("Bubble Sort [%d]: %.2fms%n", size, bubbleTime / 1e6);
            } else {
                System.out.printf("Bubble Sort [%d]: Skipped (too large)%n", size);
            }

            // Merge Sort
            int[] merge = array.clone();
            long start = System.nanoTime();
            Arrays.sort(merge); // Java uses TimSort (optimized merge sort)
            long mergeTime = System.nanoTime() - start;

            // Quick Sort (custom)
            int[] quick = array.clone();
            start = System.nanoTime();
            quickSort(quick, 0, quick.length - 1);
            long quickTime = System.nanoTime() - start;

            System.out.printf("Merge Sort [%d]: %.2fms | Quick Sort: %.2fms%n",
                    size, mergeTime / 1e6, quickTime / 1e6);
        }
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot)
                swap(arr, ++i, j);
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}
