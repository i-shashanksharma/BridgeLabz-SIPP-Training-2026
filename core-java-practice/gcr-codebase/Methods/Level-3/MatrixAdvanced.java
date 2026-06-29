public class MatrixAdvanced {

    public static double[][] createMatrix(int rows, int cols) {

        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = (int)(Math.random() * 9) + 1;
            }
        }

        return matrix;
    }

    public static double[][] transpose(double[][] matrix) {

        double[][] result =
                new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static double determinant2x2(double[][] m) {

        return (m[0][0] * m[1][1])
                - (m[0][1] * m[1][0]);
    }

    public static double determinant3x3(double[][] m) {

        return m[0][0] * ((m[1][1] * m[2][2]) -
                (m[1][2] * m[2][1]))
                - m[0][1] * ((m[1][0] * m[2][2]) -
                (m[1][2] * m[2][0]))
                + m[0][2] * ((m[1][0] * m[2][1]) -
                (m[1][1] * m[2][0]));
    }

    public static double[][] inverse2x2(double[][] m) {

        double det = determinant2x2(m);

        double[][] inv = new double[2][2];

        inv[0][0] = m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] = m[0][0] / det;

        return inv;
    }

    public static double[][] inverse3x3(double[][] m) {

        double det = determinant3x3(m);

        double[][] inv = new double[3][3];

        inv[0][0] = ((m[1][1]*m[2][2])-(m[1][2]*m[2][1]))/det;
        inv[0][1] = ((m[0][2]*m[2][1])-(m[0][1]*m[2][2]))/det;
        inv[0][2] = ((m[0][1]*m[1][2])-(m[0][2]*m[1][1]))/det;

        inv[1][0] = ((m[1][2]*m[2][0])-(m[1][0]*m[2][2]))/det;
        inv[1][1] = ((m[0][0]*m[2][2])-(m[0][2]*m[2][0]))/det;
        inv[1][2] = ((m[0][2]*m[1][0])-(m[0][0]*m[1][2]))/det;

        inv[2][0] = ((m[1][0]*m[2][1])-(m[1][1]*m[2][0]))/det;
        inv[2][1] = ((m[0][1]*m[2][0])-(m[0][0]*m[2][1]))/det;
        inv[2][2] = ((m[0][0]*m[1][1])-(m[0][1]*m[1][0]))/det;

        return inv;
    }

    public static void display(double[][] matrix) {

        for (double[] row : matrix) {

            for (double value : row) {

                System.out.printf("%.2f\t", value);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        double[][] matrix2 =
                createMatrix(2, 2);

        System.out.println("2x2 Matrix");
        display(matrix2);

        System.out.println("Transpose");
        display(transpose(matrix2));

        System.out.println("Determinant");
        System.out.println(determinant2x2(matrix2));

        System.out.println("Inverse");
        display(inverse2x2(matrix2));

        double[][] matrix3 =
                createMatrix(3, 3);

        System.out.println("3x3 Matrix");
        display(matrix3);

        System.out.println("Determinant");
        System.out.println(determinant3x3(matrix3));

        System.out.println("Inverse");
        display(inverse3x3(matrix3));
    }
}