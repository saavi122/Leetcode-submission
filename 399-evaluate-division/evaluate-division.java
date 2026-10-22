class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> set = new HashSet<>();
        for (List<String> eq : equations) {
            set.add(eq.get(0));
            set.add(eq.get(1));
        }
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (String var : set) {
            map.put(var, id++);
        }
        int n = id;
        double[][] dist = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1.0);
            dist[i][i] = 1.0;
        }
        for (int i = 0; i < equations.size(); i++) {
            int u = map.get(equations.get(i).get(0));
            int v = map.get(equations.get(i).get(1));
            double val = values[i];
            dist[u][v] = val;
            dist[v][u] = 1.0 / val;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] == -1.0 && dist[i][k] != -1.0 && dist[k][j] != -1.0) {
                        dist[i][j] = dist[i][k] * dist[k][j];
                    }
                }
            }
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String ustr = queries.get(i).get(0);
            String vstr = queries.get(i).get(1);

            if (!map.containsKey(ustr) || !map.containsKey(vstr)) {
                ans[i] = -1.0;
            } else {
                int u = map.get(ustr);
                int v = map.get(vstr);
                ans[i] = dist[u][v];
            }
        }
        return ans;
    }
}