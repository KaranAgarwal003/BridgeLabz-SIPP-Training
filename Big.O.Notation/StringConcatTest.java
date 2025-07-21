import java.util.Scanner;
public class StringConcatTest {
    public static void main(String[] args) {
        int N = 1000000;

        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < N; i++) {
            s += "a";
        }
        System.out.printf("String: %.2fms%n", (System.nanoTime() - start) / 1e6);

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        System.out.printf("StringBuilder: %.2fms%n", (System.nanoTime() - start) / 1e6);

        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbuf.append("a");
        }
        System.out.printf("StringBuffer: %.2fms%n", (System.nanoTime() - start) / 1e6);
    }
}
