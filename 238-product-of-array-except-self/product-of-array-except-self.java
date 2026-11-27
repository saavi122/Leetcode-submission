class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int z = 0, idx = -1, prod = 1;
        Arrays.fill(res,0);
        for(int i = 0; i<n; i++){
            if(nums[i] == 0){
                z++;
                idx = i;
            }else{
                prod *= nums[i];
            }
        }
        if(z == 0){
            for(int i = 0; i<n; i++) res[i] = prod/nums[i];
        }else if(z == 1){
            res[idx] = prod;
        }
        return res;
    }
}