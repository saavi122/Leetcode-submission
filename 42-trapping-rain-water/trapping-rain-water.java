class Solution {
    public int trap(int[] height) {
        int l = 1, r = height.length-2; // 1 nd n-2 is because last block can never trap the water
        int lmax = height[l-1];
        int rmax = height[r+1];
        int water = 0;
        while(l<=r){
            if(rmax<=lmax){
                water += Math.max(0,rmax-height[r]);
                rmax = Math.max(rmax,height[r]);
                r--;
            }else{
                water += Math.max(0,lmax-height[l]);
                lmax = Math.max(lmax,height[l]);
                l++;
            }
        }
        return water;
    }
}