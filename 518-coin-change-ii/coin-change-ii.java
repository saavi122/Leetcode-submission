class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (amount < 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int j = c; j <= amount; j++) {
                dp[j] += dp[j - c];
            }
        }
        return dp[amount];
    }
}
//         int n = coins.length;
//         int[][] dp = new int[n + 1][amount + 1];
//         if (amount == 0) return 1;
//         if (amount < 0) return -1;

//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = 1;
//         }
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= amount; j++) {
//                 dp[i][j] = dp[i-1][j]; // skip
//                 if (coins[i-1] <= j) {
//                     dp[i][j] += dp[i][j-coins[i-1]]; // not skip
//                 }
//             }
//         }
//         return dp[n][amount];
//     }
// }

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