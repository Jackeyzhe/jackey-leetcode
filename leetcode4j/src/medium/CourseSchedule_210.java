package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule_210 {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        CourseSchedule_210 solution = new CourseSchedule_210();
        int[] res = solution.findOrder(numCourses, prerequisites);
        for (int r : res) {
            System.out.println(r);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        int[] inDegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegrees[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[count++] = cur;
            for (int[] p : prerequisites) {
                if (p[1] == cur) {
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) {
                        queue.offer(p[0]);
                    }
                }
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }
}
