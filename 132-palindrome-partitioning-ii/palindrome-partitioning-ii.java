class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] isPalin = new boolean[n][n];
        for(int i = 0; i<n; i++){
            int mini = i;
            for(int j = 0; j<=i; j++){
                if(s.charAt(i) == s.charAt(j) && (i-j<= 2 || isPalin[j+1][i-1])){
                    isPalin[j][i] = true;
                    if(j==0) mini = 0;
                    else mini = Math.min(mini,1+dp[j-1]);
                }
            }
            dp[i] = mini;
        }
        return dp[n-1];
    }
}


// class Solution {
//     public int minCut(String s) {
//         int n = s.length();
//         Integer[][] dp = new Integer[n][n];
//         return partition(s,0,n-1,dp);
//     }

//     public int partition(String s, int i, int j, Integer[][] dp){
//         if(i >= j || isPalin(s,i,j)) return 0;
//         if (dp[i][j] != null) {
//             return dp[i][j];
//         }
//         int ans = Integer.MAX_VALUE;
//         for(int k = i; k<j; k++){
//             if(isPalin(s, i, k)){
//                 int right = partition(s, k+1, j, dp);
//                 ans = Math.min(ans, 1 + right);
//             }
//         }
//         return dp[i][j] = ans;
//     }

//     public boolean isPalin(String s, int l, int r){
//         while(l<r){
//             if(s.charAt(l) != s.charAt(r)){
//                 return false;
//             }
//             l++;r--;
//         }
//         return true;
//     }
// }


// class Solution {
//     public int minCut(String s) {
//         return partition(s,0,s.length()-1);
//     }

//     public int partition(String s, int i, int j){
//         if(i >= j || isPalin(s,i,j)) return 0;
//         int ans = Integer.MAX_VALUE;
//         for(int k = i; k<j; k++){
//             if(isPalin(s, i, k)){
//                 int right = partition(s, k+1, j);
//                 ans = Math.min(ans, 1 + right);
//             }
//         }
//         return ans;
//     }

//     public boolean isPalin(String s, int l, int r){
//         while(l<r){
//             if(s.charAt(l) != s.charAt(r)){
//                 return false;
//             }
//             l++;r--;
//         }
//         return true;
//     }
// }