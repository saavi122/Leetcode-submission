class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalsum = 0;
        for(int n : nums) totalsum += n;
        if(target > totalsum || target < -totalsum || (target+totalsum)%2 != 0) return 0;
        int s1 = (target+totalsum)/2;
        int[] dp = new int[s1+1];
        dp[0] = 1;
        for(int n : nums){
            for(int i = s1; i>= n; i--) dp[i] += dp[i-n];
        }
        return dp[s1];
    }
}

    // return helper(0, nums, target, 0, new HashMap<>());
    // }

    // public int helper(int idx, int[] nums, int target, int sum, HashMap<String, Integer> memo){
    //     if(idx == nums.length) return sum == target ? 1 : 0;
    //     String key = idx + "," + sum;
    //     if(memo.containsKey(key)) return memo.get(key);
    //     int add = helper(idx+1, nums, target, sum + nums[idx], memo);
    //     int sub = helper(idx+1, nums, target, sum - nums[idx], memo);

    //     int totalWays = add + sub;
    //     memo.put(key, totalWays);
    //     return totalWays;