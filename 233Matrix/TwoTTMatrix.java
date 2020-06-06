public class TwoTTMatrix {
    /**
     * @param X: a list of integers
     * @param m: an integer
     * @return: return an integer
     */
    private static final long MOD = 10000007;
    class Matrix {
        int row;
        int col;
        long[][] matrix;
        Matrix(int row, int col) {
            this.row = row;
            this.col = col;
            this.matrix = new long[this.row][this.col];
            for (int i = 0; i < row; ++i) { // 零矩阵
                for (int j = 0; j < col; ++j) {
                    this.matrix[i][j] = 0;
                }
            }
        }
        public Matrix multi(Matrix otherMatrix) {
            // this.matrix * the other Matrix;
            int resultedCol = otherMatrix.matrix[0].length;
            Matrix result = new Matrix(row, resultedCol);

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < resultedCol; j++) {
                    for (int k = 0; k < col; k++) {
                        result.matrix[i][j] += this.matrix[i][k] * otherMatrix.matrix[k][j];
                        result.matrix[i][j] %= MOD;
                    }
                }
            }

            return result;
        }
    }
    public int calcTheValueOfAnm(int[] X, int m) {
        // write your code here
        int n = X.length;
        if (m == 0) {
            if (n == 0) {
                return 0;
            } else {
                return X[n -1];
            }
        }

        int newRow = n + 2;
        // Init a n+2 * n+2 matrix
        Matrix n2n2 = new Matrix(newRow, newRow);
        for (int i = 0; i < newRow - 1; i++) {
            n2n2.matrix[i][0] = 10;
        }
        for (int i = 0; i < newRow; i++) {
            n2n2.matrix[i][newRow - 1] = 1;
        }
        for (int i = 1; i < newRow - 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                n2n2.matrix[i][j] = 1;
            }
        }

        // Init a n+2 * 1 matrix
        Matrix n21 = new Matrix(newRow, 1);
        n21.matrix[0][0] = 233;
        n21.matrix[newRow  - 1][0] = 3;
        for (int i = 1; i < newRow - 1; i++) {
            n21.matrix[i][0] = n21.matrix[i - 1][0] + X[i - 1];
        }

        // do m-1 multiplication of n2n2 Matrix
        Matrix matrixAfterFastFow = fastPowMatrix(n2n2, m - 1);
        Matrix resultMatrix = matrixAfterFastFow.multi(n21);
        return (int) resultMatrix.matrix[newRow - 2][0];
    }

    private Matrix fastPowMatrix(Matrix matrix, int times) {
        // initiate a unit matrix;
        int len = matrix.row;
        Matrix result = new Matrix(len, len);
        for (int i = 0; i < len; i++) {
            result.matrix[i][i] = 1;
        }
        while (times > 0) {
            if (times % 2 == 1) {
                result = result.multi(matrix);
            }
            matrix = matrix.multi(matrix);
            times /= 2;
        }

        return result;
    }


    public static void main(String[] args) {
        TwoTTMatrix twoTTMatrix = new TwoTTMatrix();
        System.out.println(twoTTMatrix.calcTheValueOfAnm(new int[]{}, 100));
    }
}