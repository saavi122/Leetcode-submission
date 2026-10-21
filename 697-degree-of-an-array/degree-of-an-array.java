class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer,Integer> first = new HashMap<>();
        Map<Integer,Integer> last = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int x = nums[i];
            freq.put(x,freq.getOrDefault(x,0)+1);
            first.putIfAbsent(x,i);
            last.put(x,i);
        }
        int deg = 0;
        for(int cnt : freq.values()){
            deg = Math.max(deg,cnt);
        }
        int minlen = Integer.MAX_VALUE;
        for(int n : freq.keySet()){
            if(freq.get(n) == deg){
                minlen = Math.min(minlen,last.get(n)-first.get(n)+1);
            }
        }
        return minlen;
    }
}