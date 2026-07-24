class Solution {
    // int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // public int helper(int i, int j, String s, String t){

    //     if(i < 0 || j < 0){
    //         return 0;
    //     }
    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(s.charAt(i) == t.charAt(j)){
    //         return 1 + helper(i - 1, j - 1, s, t);
    //     }
    //     return dp[i][j] = Math.max(helper(i - 1, j, s, t), helper(i, j - 1, s, t));
    // }
}