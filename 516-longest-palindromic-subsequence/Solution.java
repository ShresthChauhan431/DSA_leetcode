class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0;  i < n; i++){
            dp[i][i] = 1;
        }

        int max = 0;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j + i <= n; j++){
                int k = j + i -1;
                if(s.charAt(j) == s.charAt(k)){
                        dp[j][k] =  dp[j + 1][k - 1] + 2;
                }
                else
                    dp[j][k] = Math.max(dp[j][k - 1], dp[j + 1][k]);
            }
        }
        return dp[0][n - 1];
    }
}