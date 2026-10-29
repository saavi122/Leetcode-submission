class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];

        for (int i = n-1; i>=0; i--) {
            List<Integer> ans = triangle.get(i);
            for (int j = 0; j<ans.size(); j++) {
                dp[j] = ans.get(j) + Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[][] dp = new int[n][n];
//         for (int j = 0; j < n; j++) dp[n - 1][j] = triangle.get(n - 1).get(j);

//         for (int i = n-2; i>=0; i--) {
//             for (int j = 0; j<=i; j++) {
//                 dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
//             }
//         }
//         return dp[0][0];
//     }
// }

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         Integer[][] dp = new Integer[triangle.size()][triangle.size()];
//         return helper(0,0,triangle,dp);
//     }
//     public int helper(int r, int c, List<List<Integer>> tri,Integer[][] dp){
//         if(r == tri.size()-1) return tri.get(r).get(c);
//         if(dp[r][c] != null)return dp[r][c];
//         int downl = helper(r+1,c,tri,dp);
//         int downr = helper(r+1,c+1,tri,dp);

//         return dp[r][c] =  tri.get(r).get(c) + Math.min(downl, downr);
//     }
// }

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         return helper(0,0,triangle);
//     }
//     public int helper(int r, int c, List<List<Integer>> tri){
//         if(r == tri.size()-1) return tri.get(r).get(c);

//         int downl = helper(r+1,c,tri);
//         int downr = helper(r+1,c+1,tri);

//         return tri.get(r).get(c) + Math.min(downl, downr);
//     }
// }