package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals_56 solution = new MergeIntervals_56();
        int[][] result = solution.merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merge = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (merge.isEmpty() || merge.get(merge.size() - 1)[1] < l) {
                merge.add(new int[]{l, r});
            } else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], r);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
