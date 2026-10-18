class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && grid[i][j] == 1){
                    dfs(grid,i,j);
                }
            }
        }
        int sum = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                sum += grid[i][j];
            }
        }
        return sum;
    }

    public void dfs(int[][] grid, int r, int c){
        grid[r][c] = 0;
        for(int[] d: dir){
            int row = r + d[0];
            int col = c + d[1];
            if(row >= 0 && row <grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1){
                dfs(grid,row,col);
            }
        }
    }
}