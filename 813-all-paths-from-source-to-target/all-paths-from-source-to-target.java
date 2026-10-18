class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        ans.add(0);
        dfs(0,graph,ans,res);
        return res;
    }
    public void dfs(int node, int[][] gph, List<Integer> ans, List<List<Integer>> res){
        int n = gph.length;
        if(node == n-1){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int nei : gph[node]){
            ans.add(nei);
            dfs(nei,gph,ans,res);
            ans.remove(ans.size()-1);
        }
    }
}