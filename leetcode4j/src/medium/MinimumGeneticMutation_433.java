package medium;

import java.util.*;

public class MinimumGeneticMutation_433 {

    public static void main(String[] args) {
        MinimumGeneticMutation_433 solution = new MinimumGeneticMutation_433();
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int result = solution.minMutation(start, end, bank);
        System.out.println(result);
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Set<String> cnt = new HashSet<>(Arrays.asList(bank));
        if (!cnt.contains(endGene)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);
        char[] keys = {'A', 'C', 'G', 'T'};
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (keys[k] != cur.charAt(j)) {
                            StringBuilder sb = new StringBuilder(cur);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)) {
                                if (next.equals(endGene)) {
                                    return step;
                                }
                                visited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

}
