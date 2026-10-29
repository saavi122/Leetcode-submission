class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i = 1; i<= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int c : coins){
                if(i >= c && dp[i-c] != -1) min = Math.min(min,dp[i-c]);
                if(min != Integer.MAX_VALUE) dp[i] = 1+min;
            }
        }
        return dp[amount];
    }
}

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int amt = helper(coins,amount);
//         return amt == Integer.MAX_VALUE ? -1 : amt;
//     }
//     public int helper(int[] coins, int amt){
//         if(amt == 0) return 0;
//         if(amt < 0) return Integer.MAX_VALUE;
//         int mincost = Integer.MAX_VALUE;
//         for(int c : coins){
//             int sumprob = helper(coins,amt-c);
//             if (sumprob != Integer.MAX_VALUE) mincost = Math.min(mincost, 1+sumprob);
//         } 
//         return mincost;
//     }
// }