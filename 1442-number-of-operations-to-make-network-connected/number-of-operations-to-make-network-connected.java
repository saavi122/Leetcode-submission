class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        int[] par = new int[n];
        int cnt = n;
        for(int i = 0; i<n; i++){
            par[i] = i;
        }
        for(int[] c : connections){
            int u = c[0];
            int v = c[1];

            int paru = find(u,par);
            int parv = find(v,par);

            if(paru != parv){
                par[parv] = paru;
                cnt--;
            }
        }
        return cnt-1;
    }
    public int find(int i, int[] par){
        if(par[i] == i) return i;
        return par[i] = find(par[i],par);
    }
}