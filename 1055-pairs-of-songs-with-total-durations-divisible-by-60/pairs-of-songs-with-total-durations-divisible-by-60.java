class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i<n; i++){
            int rem = time[i] % 60;
            int targ = 60 - rem;
            if(map.containsKey(targ)){
                ans += map.get(targ);
            }
            if(rem != 0){
                map.put(rem,map.getOrDefault(rem,0)+1);
            }else{
                map.put(60,map.getOrDefault(60,0)+1);
            }
        }
        return ans;
    }
}