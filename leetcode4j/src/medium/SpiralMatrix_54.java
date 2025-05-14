package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public static void main(String[] args) {
        SpiralMatrix_54 solution = new SpiralMatrix_54();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int row = 0;
        int col = 0;
        int directionIndex = 0;
        for (int i = 0; i < rows * columns; i++) {
            order.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow >= rows || nextRow < 0 || nextCol >= columns || nextCol < 0 || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return order;
    }
}
