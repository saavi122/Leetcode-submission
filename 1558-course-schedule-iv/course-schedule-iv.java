class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            adj.get(p[0]).add(p[1]);
            indeg[p[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i = 0; i<numCourses; i++){
            map.put(i,new HashSet<>());
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nei : adj.get(cur)){
                map.get(nei).add(cur);
                map.get(nei).addAll(map.get(cur));
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.add(nei);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] qu : queries){
            res.add(map.get(qu[1]).contains(qu[0]));
        }
        return res;
    }
}