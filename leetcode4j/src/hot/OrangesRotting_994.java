package hot;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting_994 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int x = arr[0];
                int y = arr[1];
                for (int j = 0; j < dir.length; j++) {
                    int xNext = x + dir[j][0];
                    int yNext = y + dir[j][1];
                    if (xNext >= 0 && yNext >= 0 && xNext < m && yNext < n && grid[xNext][yNext] == 1) {
                        grid[xNext][yNext] = 2;
                        freshCount--;
                        hasRotten = true;
                        queue.offer(new int[]{xNext, yNext});
                    }
                }

            }
            if (hasRotten) {
                time++;
            }
        }
        return freshCount == 0 ? time : -1;
    }
}
