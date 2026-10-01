class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int num = nums[i];
            if(map.containsKey(target - num)) return new int[] {i,map.get(target-num)};
            map.put(num,i);
        }
        return new int[]{};
    }
}