class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n-1; i>=0; i--){
            dp[i][i] = 1;
            for(int j = i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2+dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}


// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         Integer[][] memo = new Integer[s.length()][s.length()];
//         return solve(s,0,s.length()-1,memo);
//     }
//     public int solve(String s, int l, int r, Integer[][] memo){
//         if(l > r) return 0;
//         if(l == r) return 1;
//         if(memo[l][r] != null) return memo[l][r];
//         if(s.charAt(l) == s.charAt(r)){
//             memo[l][r] = 2+solve(s,l+1,r-1,memo);
//         }else memo[l][r] = Math.max(solve(s,l+1,r,memo),solve(s,l,r-1,memo)); 
//         return memo[l][r];
//     }
// }

// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         return solve(s,0,s.length()-1);
//     }
//     public int solve(String s, int l, int r){
//         if(l > r) return 0;
//         if(l == r) return 1;
//         if(s.charAt(l) == s.charAt(r)){
//             return  2+solve(s,l+1,r-1);
//         }
//         return Math.max(solve(s,l+1,r),solve(s,l,r-1));
//     }
// }