class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> list = new ArrayList<>();
        boolean[] vis = new boolean[n];
        List<List<Integer>> l = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
            if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                list.get(i).add(j);
                list.get(j).add(i);
                }
            }
        }
        for(int i = 0; i<n; i++){
            if(!vis[i]){
            dfs(i,vis,list);
            cnt++;
            }
        }
        return n-cnt;
    }
    public void dfs(int node, boolean[] vis, List<List<Integer>> list){
        vis[node] = true;
        for(int nei : list.get(node)){
            if(!vis[nei])
            dfs(nei,vis,list);
        }
    }
}









