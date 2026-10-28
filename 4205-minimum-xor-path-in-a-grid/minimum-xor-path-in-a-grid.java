class Solution {
    int[][] dir = {{1,0},{0,1}};
    int ans = Integer.MAX_VALUE;
    boolean[][][] vis;
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = grid;
        vis = new boolean[m][n][1024];
        
        dfs(grid,0,0,grid[0][0]);
        return ans;
        
    }
    public void dfs(int[][] grid,int i, int j, int xor){
        int m = grid.length;
        int n = grid[0].length;

        if (vis[i][j][xor]) return;
        vis[i][j][xor] = true;

        if(i == m-1 && j == n-1){ 
            ans = Math.min(ans,xor);
            return;
        }
        for(int[] d: dir){
            int r = i+d[0];
            int c = j+d[1];

            if(r<m && c<n) dfs(grid,r,c,xor^grid[r][c]);
        }
    }
}