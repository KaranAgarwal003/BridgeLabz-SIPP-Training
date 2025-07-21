import java.io.*;

public class FileReadComparison {
    public static void main(String[] args) throws Exception {
        File file = new File("test_large.txt"); // Use 100MB+ file for real test

        // FileReader
        long start = System.nanoTime();
        try (Reader fr = new FileReader(file)) {
            while (fr.read() != -1) {}
        }
        System.out.printf("FileReader: %.2fms%n", (System.nanoTime() - start) / 1e6);

        // InputStreamReader
        start = System.nanoTime();
        try (Reader isr = new InputStreamReader(new FileInputStream(file))) {
            while (isr.read() != -1) {}
        }
        System.out.printf("InputStreamReader: %.2fms%n", (System.nanoTime() - start) / 1e6);
    }
}
