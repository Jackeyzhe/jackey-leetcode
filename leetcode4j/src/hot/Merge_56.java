package hot;

import java.util.*;

public class Merge_56 {

    public static void main(String[] args) {
        Merge_56 solution = new Merge_56();
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] result = solution.merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
