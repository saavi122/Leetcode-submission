class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        if(amount == 0) return 1;
        if(amount < 0) return -1;
        int[][] dp = new int[amount+1][n+1];
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

// class Solution {
//     public int change(int amount, int[] coins) {
//         return helper(amount,coins,0);
//     }
//     public int helper(int amt, int[] coins, int i){
//         if(amt == 0) return 1;
//         if(amt < 0 || i == coins.length) return 0;
//         int take = helper(amt-coins[i],coins,i);
//         int nottake = helper(amt,coins,i+1);
//         return take + nottake;
//     }
// }