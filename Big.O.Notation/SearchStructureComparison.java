import java.util.*;

public class SearchStructureComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] array = rand.ints(size, 1, size * 10).toArray();
            int target = array[rand.nextInt(size)];

            // Array (Linear Search)
            long start = System.nanoTime();
            for (int val : array) {
                if (val == target) break;
            }
            long arrayTime = System.nanoTime() - start;

            // HashSet
            Set<Integer> hashSet = new HashSet<>();
            for (int val : array) hashSet.add(val);
            start = System.nanoTime();
            hashSet.contains(target);
            long hashSetTime = System.nanoTime() - start;

            // TreeSet
            Set<Integer> treeSet = new TreeSet<>();
            for (int val : array) treeSet.add(val);
            start = System.nanoTime();
            treeSet.contains(target);
            long treeSetTime = System.nanoTime() - start;

            System.out.printf("Size: %,d | Array: %.2fms | HashSet: %.2fms | TreeSet: %.2fms%n",
                    size, arrayTime / 1e6, hashSetTime / 1e6, treeSetTime / 1e6);
        }
    }
}
