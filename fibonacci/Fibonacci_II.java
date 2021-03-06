public class Fibonacci_II {
    private static final int[][] MATRIX = new int[][]{{1, 1}, {1, 0}};
    private static final int DIGIT = 4;
    private static final int MOD = (int) Math.pow(10, DIGIT);
    /**
     * @param n: an integer
     * @return: return an int
     */
    public int lastFourDigitsOfFn(int n) {
       if (n <= 0) {
            return 0;
        }
       if (n == 1) {
           return 1;
       }
       int[][] lastMatrix = matrixHelper(n - 1);
       int Fn = lastMatrix[0][0];
       return Fn % MOD;
    }

    private int[][] matrixHelper(int n) {
        if (n == 2) {
            return matrixMultiplexer(MATRIX, MATRIX);
        }
        if (n == 1) {
            return MATRIX;
        }

        int[][] matrixHalfMultiplied = matrixHelper(n/2);

        if (n % 2 == 0) {
            return matrixMultiplexer(matrixHalfMultiplied, matrixHalfMultiplied);
        } else {
            return matrixMultiplexer(matrixMultiplexer(matrixHalfMultiplied, matrixHalfMultiplied), MATRIX);
        }
    }

//    private int[][] matrixMultiplexer(int[][] matrix1, int[][] matrix2) {
//        int[][] result = new int[2][2];
//        result[0][0] = (matrix1[0][0] * matrix2[0][0] + matrix1[0][1]*matrix2[1][0]) % MOD;
//        result[0][1] = (matrix1[0][0] * matrix2[0][1] + matrix1[0][1]*matrix2[1][1]) % MOD;
//        result[1][0] = (matrix1[1][0] * matrix2[0][0] + matrix1[1][1]*matrix2[1][0]) % MOD;
//        result[1][1] = (matrix1[1][0] * matrix2[0][1] + matrix1[1][1]*matrix2[1][1]) % MOD;
//        return result;
//    }

    private int[][] matrixMultiplexer(int[][] matrix1, int[][] matrix2) {
        int matrix1Row = matrix1.length;
        int matrix1Col = matrix1[0].length;
        int matrix2Col = matrix2[0].length;
        int[][] result = new int[matrix1Row][matrix2Col];

        for (int i = 0; i <matrix1Row; i++) {
            for (int j = 0; j < matrix2Col; j++) {
                for (int k = 0; k < matrix1Col; k++) {
                    result[i][j] += (matrix1[i][k] * matrix2[k][j]) % MOD;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Fibonacci_II f = new Fibonacci_II();

        System.out.println(f.lastFourDigitsOfFn(9) + " === 34");
        System.out.println(f.lastFourDigitsOfFn(60) + " === 5920");
        System.out.println(f.lastFourDigitsOfFn(100) + " === 5075");

    }
}
