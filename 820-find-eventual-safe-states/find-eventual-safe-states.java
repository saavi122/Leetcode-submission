class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // topological sorting
        int n = graph.length;
        List<List<Integer>> revadj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            revadj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int u = 0; u<n; u++){
            for(int v : graph[u]){
                revadj.get(v).add(u);
            }
            indeg[u] = graph[u].length;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        boolean[] safe = new boolean[n];
        while(!q.isEmpty()){
            int node = q.poll();
            safe[node] = true;
            for(int nei : revadj.get(node)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.add(nei);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(safe[i]){
                ans.add(i);
            }
        }
        return ans;
    }
} 

// int n = graph.length;
//         List<Integer> ans = new ArrayList<>();
//         int[] state = new int[n];
//         for(int i = 0; i<n; i++){
//             if(dfs(i,graph, state)) ans.add(i);
//         }
//         return ans;
//     }

//     public boolean dfs(int node, int[][] gph, int[] state){
//         if(state[node] == 1) return false;
//         if(state[node] == 2) return true;

//         state[node] = 1; // 0 -> unvisited, 1 ->visiting , 2-> safe
//         for(int nei : gph[node]){
//             if(!dfs(nei, gph, state)) return false;
//         }
//         state[node] = 2;
//         return true;