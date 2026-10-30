class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int len =1;
        for(int i = 0;i<n; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            len = Math.max(len,dp[i]);
        }
        return len;
    }
}

// int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         int maxlen = 0;
//         for (int i = 0; i < n; i++) {
//             maxlen = Math.max(maxlen, solve(i, nums, dp));
//         }
//         return maxlen;
//     }
//     public int solve(int i, int[] nums, int[] dp){
//         if(dp[i] != -1) return dp[i];
//         int maxlen = 1;
//         for(int j = i+1; j<nums.length; j++){
//             if(nums[j] > nums[i]){
//                 maxlen = Math.max(maxlen, 1+solve(j,nums,dp));
//             }
//         }
//         return dp[i] = maxlen;

// return solve(0,-1,nums);
//     }
//     public int solve(int curi, int previ, int[] nums){
//         if(curi == nums.length) return 0;
//         int take = 0;
//         if(previ == -1 || (nums[curi] > nums[previ])){
//             take = 1+solve(curi+1,curi,nums);
//         }
//         int nottake = solve(curi+1,previ,nums);
//         return Math.max(take,nottake); 