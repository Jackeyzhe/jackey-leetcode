package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram_84 {

    public static void main(String[] args) {
        LargestRectangleInHistogram_84 solution = new LargestRectangleInHistogram_84();
        int[] heights = {2, 4};
        int result = solution.largestRectangleArea(heights);
        System.out.println(result);
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            int h = heights[i];
            while (!st.isEmpty() && h <= heights[st.peek()]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int h = heights[i];
            while (!st.isEmpty() && h <= heights[st.peek()]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }
}
