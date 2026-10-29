class Solution {
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0, nums, target, 0, new HashMap<>());
    }

    public int helper(int idx, int[] nums, int target, int sum, HashMap<String, Integer> memo){
        if(idx == nums.length) return sum == target ? 1 : 0;
        String key = idx + "," + sum;
        if(memo.containsKey(key)) return memo.get(key);
        int add = helper(idx+1, nums, target, sum + nums[idx], memo);
        int sub = helper(idx+1, nums, target, sum - nums[idx], memo);

        int totalWays = add + sub;
        memo.put(key, totalWays);
        return totalWays;
    }
}