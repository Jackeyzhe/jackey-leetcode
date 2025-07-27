package hot;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {

    public static void main(String[] args) {
        SpiralOrder_54 solution = new SpiralOrder_54();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        boolean[][] visited = new boolean[m][n];
        for (int k = 0; k < m * n; k++) {
            ans.add(matrix[i][j]);
            visited[i][j] = true;
            int nextRow = i + dirs[dir][0];
            int nextCol = j + dirs[dir][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                dir = (dir + 1) % 4;
            }
            i += dirs[dir][0];
            j += dirs[dir][1];
        }
        return ans;
    }
}
