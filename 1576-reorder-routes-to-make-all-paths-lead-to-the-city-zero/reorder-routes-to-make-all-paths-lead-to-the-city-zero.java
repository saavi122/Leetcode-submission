class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i) 
            adj.add(new ArrayList<>());
        for (var c : connections) {
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(-c[0]);
        }
        return dfs(adj,new boolean[n],0);
    }
    public int dfs(List<List<Integer>> adj, boolean[] vis, int node){
        int cnt = 0;
        vis[node] = true;
        for(int nei : adj.get(node)){
            if(!vis[Math.abs(nei)]){
                cnt += dfs(adj,vis,Math.abs(nei)) + (nei > 0 ? 1 : 0);
            }
        }
        return cnt;
    }
}