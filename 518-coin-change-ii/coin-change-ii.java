class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];
        if(amount == 0) return 1;
        if(amount < 0) return -1;
        for(int j = 0; j<=n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i<= amount; i++){
            for(int j = 1; j<=n; j++){
                dp[i][j] = dp[i][j-1];

                if(coins[j-1] <= i){
                    dp[i][j] += dp[i-coins[j-1]][j];
                }
            }
        }
        return dp[amount][n];
    }
}

// int[] dp = new int[coins.length];
//         Arrays.fill(dp,0);
//         return helper(amount,coins,0,dp);
//     }
//     public int helper(int amt, int[] c, int i, int[] dp){
//         if(amt == 0) return 1;
//         if(amt < 0 || i == c.length) return 0;
//         int take = helper(amt-c[i],c,i,dp);
//         int nottake = helper(amt,c,i+1,dp);
//         return dp[i] = take+nottake;