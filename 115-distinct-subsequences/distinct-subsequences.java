class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        long[] dp = new long[m+1];
        dp[0] = 1;

        for (int i = 0; i<n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i) == t.charAt(j-1)) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return (int) dp[m];
    }
}

// class Solution {
//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         int[][] dp = new int[n+1][m+1];

//         if(n < m) return 0;
//         for(int i = 0; i<=n; i++){
//             dp[i][m] = 1;
//         }
//         for(int i = n-1; i>=0; i--){
//             for(int j = m-1; j>=0; j--){
//                 if(s.charAt(i) == t.charAt(j)){
//                     dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
//                 }else{
//                     dp[i][j] = dp[i+1][j];
//                 }
//             }
//         }
//         return dp[0][0];
//     }
// }