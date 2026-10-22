class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], d = e[2];
            dist[u][v] = d;
            dist[v][u] = d;
        }
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int minnum = n;
        int res = -1;

        for (int i = 0; i < n; i++) {
            int srccnt = 0;
            for (int j = 0; j<n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    srccnt++;
                }
            }

            if (srccnt <= minnum) {
                minnum = srccnt;
                res = i;
            }
        }
        return res;
    }
}
//  List<List<Pair>> adj = new ArrayList<>();
//         for(int i = 0; i<n; i++){
//             adj.add(new ArrayList<>());
//         }

//         for(int[] e : edges){
//             int u = e[0];
//             int v = e[1];
//             int edge = e[2];
//             adj.get(u).add(new Pair(edge,v));
//             adj.get(v).add(new Pair(edge,u));
//         }
//         int rescity = -1;
//         int minreachcnt = Integer.MAX_VALUE;
//         for (int i = 0; i < n; i++) {
//             int reachcnt = reachcity(n, i, adj, distanceThreshold);
//             if (reachcnt <= minreachcnt) {
//                 minreachcnt = reachcnt;
//                 rescity = i;
//             }
//         }
//         return rescity;
//     }

    // public int reachcity(int n, int start, List<List<Pair>> adj, int dt){
    //     int[] dist = new int[n];
    //     Arrays.fill(dist,Integer.MAX_VALUE);
    //     PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.dist,b.dist));
    //     dist[start] = 0;
    //     pq.add(new Pair(0,start));

    //     int count = 0;
    //     while(!pq.isEmpty()){
    //         Pair top = pq.poll();
    //         int d = top.dist;
    //         int u = top.V;

    //         if(d > dist[u]) continue;
    //         for(Pair p : adj.get(u)){
    //             int v = p.V;
    //             int w = p.dist;

    //             if(dist[u]+w < dist[v]){
    //                 dist[v] = dist[u]+w;
    //                 pq.offer(new Pair(dist[v], v));
    //             }
    //         }
    //     }
    //     for (int i = 0; i < n; i++) {
    //         if (i != start && dist[i] <= dt) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }