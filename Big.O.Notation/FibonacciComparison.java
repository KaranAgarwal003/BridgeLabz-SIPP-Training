
import java.util.Scanner;
public class FibonacciComparison {
    public static void main(String[] args) {
        int n = 30;

        long start = System.nanoTime();
        int rec = fibonacciRecursive(n);
        long recTime = System.nanoTime() - start;

        start = System.nanoTime();
        int iter = fibonacciIterative(n);
        long iterTime = System.nanoTime() - start;

        System.out.printf("Recursive: %d in %.2fms | Iterative: %d in %.2fms%n",
                rec, recTime / 1e6, iter, iterTime / 1e6);
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
