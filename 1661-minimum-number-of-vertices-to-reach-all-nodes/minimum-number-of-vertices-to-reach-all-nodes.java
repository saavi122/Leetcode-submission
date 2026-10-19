class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int[] indeg = new int[n];
        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            indeg[to]++;
        }
        for(int i = 0; i<n; i++){
            if(indeg[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}