class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        for(int i = 0; i<n; i++){
            if(!dp[i]) continue;
            int furthestJump = Math.min(i+nums[i], n-1);
            for(int j = i+1; j <= furthestJump; j++) {
                dp[j] = true;
                if(dp[n - 1]) return true;
            }
        }
        return dp[n - 1];
    }
}