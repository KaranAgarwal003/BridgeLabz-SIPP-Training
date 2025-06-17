import java.util.Random;

public class q15 {

    // Generate random matrix
    public static double[][] generateMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        Random rand = new Random();
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); // values 0 to 9
        return matrix;
    }

    // Display matrix
    public static void displayMatrix(String label, double[][] matrix) {
        System.out.println("\n" + label);
        for(double[] row : matrix) {
            for(double val : row)
                System.out.printf("%8.2f", val);
            System.out.println();
        }
    }

    // Transpose
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] result = new double[cols][rows];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                result[j][i] = matrix[i][j];
        return result;
    }

    // Determinant 2x2
    public static double determinant2x2(double[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    // Determinant 3x3
    public static double determinant3x3(double[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1]) 
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0]) 
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    // Inverse 2x2
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = {
            { m[1][1]/det, -m[0][1]/det },
            { -m[1][0]/det, m[0][0]/det }
        };
        return inv;
    }

    // Inverse 3x3
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;

        double[][] cofactor = new double[3][3];

        cofactor[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        cofactor[0][1] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        cofactor[0][2] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        cofactor[1][0] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        cofactor[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        cofactor[1][2] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);

        cofactor[2][0] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
        cofactor[2][1] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        cofactor[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

        // Transpose of cofactor (adjugate)
        double[][] adjugate = transpose(cofactor);

        // Divide each element by determinant
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                adjugate[i][j] /= det;

        return adjugate;
    }

    // Main
    public static void main(String[] args) {
        // 2x2
        double[][] mat2x2 = generateMatrix(2, 2);
        displayMatrix("2x2 Matrix:", mat2x2);
        displayMatrix("Transpose:", transpose(mat2x2));
        System.out.println("\nDeterminant: " + determinant2x2(mat2x2));
        double[][] inv2x2 = inverse2x2(mat2x2);
        if(inv2x2 != null)
            displayMatrix("Inverse:", inv2x2);
        else
            System.out.println("Matrix is singular, no inverse.");

        // 3x3
        double[][] mat3x3 = generateMatrix(3, 3);
        displayMatrix("\n3x3 Matrix:", mat3x3);
        displayMatrix("Transpose:", transpose(mat3x3));
        System.out.println("\nDeterminant: " + determinant3x3(mat3x3));
        double[][] inv3x3 = inverse3x3(mat3x3);
        if(inv3x3 != null)
            displayMatrix("Inverse:", inv3x3);
        else
            System.out.println("Matrix is singular, no inverse.");
    }
}
