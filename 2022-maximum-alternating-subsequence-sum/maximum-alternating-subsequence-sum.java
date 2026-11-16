class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] dp = new long[2];
        int sum = 0;
        for(int i = n-1; i>=0; i--){
            dp[0] = Math.max(nums[i]+dp[1], dp[0]);
            dp[1] = Math.max(-nums[i]+dp[0], dp[1]);
        }
        return dp[0];
    }
}

// int n = nums.length;
//         long[][] dp = new long[n+1][2];
//         int sum = 0;
//         for(int i = n-1; i>=0; i--){
//             dp[i][0] = Math.max(nums[i]+dp[i+1][1], dp[i+1][0]);
//             dp[i][1] = Math.max(-nums[i]+dp[i+1][0], dp[i+1][1]);
//         }
//         return dp[0][0];