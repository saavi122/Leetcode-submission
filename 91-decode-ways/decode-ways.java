class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return rec(s, 0, dp);
    }
    public int rec(String s, int i, int[] dp){
        if(i >= s.length()) return 1;
        if(dp[i] != -1) return dp[i];
        if(s.charAt(i) == '0') return dp[i] = 0;
        int ans = rec(s,i+1,dp);
        if(i+1 < s.length()){
            int twodigi = Integer.parseInt(s.substring(i,i+2));
            if(twodigi >= 10 && twodigi <= 26) ans += rec(s, i + 2, dp);
        }
        return dp[i] = ans;
    }
}