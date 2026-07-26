class Solution {
    String s, t;
    int[][] dp;
    private int helper(int i, int j){
        if (i >= s.length())
            return t.length() - j;
        
        if (j >= t.length())
            return s.length() - i;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) return dp[i][j] = helper(i + 1, j + 1);

        int insert = 1 + helper(i, j + 1);
        int delete = 1 + helper(i + 1, j);
        int replace = 1 + helper(i + 1, j + 1);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        s = word1;
        t = word2;
        dp = new int[s.length()][t.length()];
        for (int[] d: dp)
            Arrays.fill(d, -1);
        return helper(0, 0);
    }
}