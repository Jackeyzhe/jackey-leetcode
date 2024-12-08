package medium;

import java.util.*;

public class EvaluateDivision_399 {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        equations.add(equation1);
        equations.add(equation2);
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");
        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");
        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");
        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");
        List<String> query5 = new ArrayList<>();
        query5.add("x");
        query5.add("x");
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);

        EvaluateDivision_399 evaluateDivision399 = new EvaluateDivision_399();
        double[] result = evaluateDivision399.calcEquation(equations, values, queries);
        Arrays.stream(result).forEach(System.out::println);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationSize);
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (int i = 0; i < equationSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }

            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }

        int querySize = queries.size();
        double[] res = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {
        private int[] parent;

        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}
