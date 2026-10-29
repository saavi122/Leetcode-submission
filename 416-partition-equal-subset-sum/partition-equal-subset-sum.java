class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum %2 != 0) return false;
        int tsum = sum/2;
        boolean[] dp = new boolean[tsum+1];
        dp[0] = true;
        for(int n : nums){
            for(int i = tsum; i>= n; i--){
                dp[i] = dp[i] || dp[i-n];
            }
        }
        return dp[tsum];
    }
}