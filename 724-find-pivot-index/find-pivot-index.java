class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        for(int i = 1; i<n; i++){
            pre[i] = pre[i-1]+nums[i];
        }
        suf[n-1] = nums[n-1];
        for(int i = n-2; i>=0; i--){
            suf[i] = suf[i+1]+nums[i];
        }
        for(int i = 0; i<n; i++){
            int p = pre[i]-nums[i];
            int s = suf[i]-nums[i];
            if(p == s) return i;
        }
        return -1;
    }
}
// int total = 0;
//         for (int num : nums) {
//             total += num;
//         }
        
//         int leftTotal = 0;
//         for (int i = 0; i < nums.length; i++) {
//             int rightTotal = total - leftTotal - nums[i];
//             if (rightTotal == leftTotal) {
//                 return i;
//             }
//             leftTotal += nums[i];
//         }
//         return -1; 
