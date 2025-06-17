import java.util.Scanner;

public class q14 {

    // Generate a random matrix with given dimensions
    public static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 10); // random values 0-9
            }
        }
        return matrix;
    }

    // Add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    // Multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for(int i = 0; i < rowsA; i++) {
            for(int j = 0; j < colsB; j++) {
                for(int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Display matrix
    public static void displayMatrix(String label, int[][] matrix) {
        System.out.println("\n" + label);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for matrix dimensions
        System.out.print("Enter rows and columns for Matrix A: ");
        int rowsA = sc.nextInt();
        int colsA = sc.nextInt();

        System.out.print("Enter rows and columns for Matrix B: ");
        int rowsB = sc.nextInt();
        int colsB = sc.nextInt();

        int[][] A = generateMatrix(rowsA, colsA);
        int[][] B = generateMatrix(rowsB, colsB);

        displayMatrix("Matrix A:", A);
        displayMatrix("Matrix B:", B);

        if(rowsA == rowsB && colsA == colsB) {
            int[][] sum = addMatrices(A, B);
            int[][] diff = subtractMatrices(A, B);
            displayMatrix("Addition (A + B):", sum);
            displayMatrix("Subtraction (A - B):", diff);
        } else {
            System.out.println("\nAddition/Subtraction not possible (dimension mismatch)");
        }

        if(colsA == rowsB) {
            int[][] prod = multiplyMatrices(A, B);
            displayMatrix("Multiplication (A * B):", prod);
        } else {
            System.out.println("\nMultiplication not possible (A's cols ≠ B's rows)");
        }

        sc.close();
    }
}
