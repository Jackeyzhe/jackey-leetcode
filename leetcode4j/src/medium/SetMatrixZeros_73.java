package medium;

import java.util.Arrays;

public class SetMatrixZeros_73 {

    public static void main(String[] args) {
        SetMatrixZeros_73 solution = new SetMatrixZeros_73();
        int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
