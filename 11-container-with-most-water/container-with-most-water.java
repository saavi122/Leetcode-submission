class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, water = 0;
        while(l<r){
            int ht = Math.min(height[l],height[r]);
            water = Math.max(water,ht*(r-l));
            while(l<r && height[l] <= ht) l++;
            while(l<r && height[r] <= ht) r--; 
        }
        return water;
    }
}