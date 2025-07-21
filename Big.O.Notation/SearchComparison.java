import java.util.*;

public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] data = rand.ints(size, 1, size * 10).toArray();
            int target = data[rand.nextInt(size)];

            // Linear Search
            long start = System.nanoTime();
            for (int val : data) {
                if (val == target) break;
            }
            long linearTime = System.nanoTime() - start;

            // Binary Search
            Arrays.sort(data);
            start = System.nanoTime();
            Arrays.binarySearch(data, target);
            long binaryTime = System.nanoTime() - start;

            System.out.printf("Size: %,d | Linear: %.2fms | Binary: %.2fms%n",
                    size, linearTime / 1e6, binaryTime / 1e6);
        }
    }
}

