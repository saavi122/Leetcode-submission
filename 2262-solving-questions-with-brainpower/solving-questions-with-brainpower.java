class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n-1; i>=0; i--) {
            int nextidx = Math.min(i+questions[i][1]+1, n);
            dp[i] = Math.max(questions[i][0] + dp[nextidx], dp[i+1]);
        }

        return dp[0];
    }
}
