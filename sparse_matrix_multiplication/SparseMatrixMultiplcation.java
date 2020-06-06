import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparseMatrixMultiplcation {


    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        // Transform two matrix to
        int row = A.length;
        int common = A[0].length;
        int col = B[0].length;
        List<List<int[]>> convertedA = convertSparseMatrix(A, row, common, true);
        List<List<int[]>> convertedB = convertSparseMatrix(B, col, common, false);

        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = multipleArray(convertedA.get(i), convertedB.get(j));
            }
        }
        return result;

    }
    private int multipleArray(List<int[]> array1, List<int[]> array2) {
        int i = 0;
        int j = 0;

        int sum = 0;
        while (i < array1.size() && j < array2.size()) {
            if (array1.get(i)[0] < array2.get(j)[0]) {
                i++;
            } else if (array1.get(i)[0] > array2.get(j)[0]) {
                j++;
            } else {
                sum += array1.get(i)[1] * array2.get(j)[1];
                i++;
                j++;
            }
        }

        return sum;
    }

    private List<List<int[]>> convertSparseMatrix(int[][] matrix, int row, int col, boolean isTheFrontMatrix) {
        List<List<int[]>> converted = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            converted.add(new ArrayList<>());
            for (int j = 0; j < col; j++) {
                if (isTheFrontMatrix) {
                    if (matrix[i][j] != 0) {
                        converted.get(i).add(new int[]{j, matrix[i][j]});
                    }
                } else {
                    if (matrix[j][i] != 0) {
                        converted.get(i).add(new int[]{j, matrix[j][i]});
                    }
                }
            }
        }
        return converted;
    }

    public static void main(String[] args) {
        SparseMatrixMultiplcation sparseMatrixMultiplcation = new SparseMatrixMultiplcation();
        System.out.println("=================");
        int[][] matrixA = new int[][]{{1,0},{0,1}};
        int[][] matrixB = new int[][]{{0,1},{1,0}};
        System.out.println(Arrays.deepToString(matrixA));
        System.out.println(Arrays.deepToString(matrixB));
        System.out.println("result: " + Arrays.deepToString(sparseMatrixMultiplcation.multiply(matrixA, matrixB))
                + " === " + Arrays.deepToString(new int[][]{{0,1},{1,0}}));

        System.out.println("=================");
        int[][] matrixA1 = new int[][]{{1, 0, 0},{-1, 0, 3}};
        int[][] matrixB1 = new int[][]{{7, 0, 0},{0, 0, 0},{0, 0, 1 }};
        System.out.println(Arrays.deepToString(matrixA1));
        System.out.println(Arrays.deepToString(matrixB1));
        System.out.println("result: " + Arrays.deepToString(sparseMatrixMultiplcation.multiply(matrixA1, matrixB1))
                + " === " + Arrays.deepToString(new int[][]{{7, 0, 0},{-7, 0, 3}}));
    }

}
