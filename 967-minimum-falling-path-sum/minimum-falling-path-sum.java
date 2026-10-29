class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i = 0; i<n; i++){
            ans = Math.min(ans,path(matrix,n-1,i,dp));
        }
        return ans;
    }
    public int path(int[][] mat,int i, int j, int[][] dp){
        if(j < 0 || j>=mat.length) return Integer.MAX_VALUE;
        if(i == 0) return mat[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int down = path(mat,i-1,j,dp);
        int downl = path(mat,i-1,j-1,dp);
        int downr = path(mat,i-1,j+1,dp);
        int min = Math.min(down,Math.min(downl,downr));
        return dp[i][j] = mat[i][j] + min;
    }
}