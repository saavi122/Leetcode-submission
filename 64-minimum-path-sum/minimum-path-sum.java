class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(m-1, n-1, grid,dp);
    }
    
    public int helper(int r, int c, int[][] grid, int[][] dp) {
        if(r < 0 || c < 0) return Integer.MAX_VALUE;
        if(r == 0 && c == 0) dp[0][0] = grid[0][0];
        if(dp[r][c] != -1) return dp[r][c];

        int up = helper(r-1, c, grid,dp);
        int left = helper(r, c-1, grid,dp);
        return dp[r][c] = grid[r][c] + Math.min(up, left);
    }
}