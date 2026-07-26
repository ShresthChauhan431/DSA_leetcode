class Solution {

    private String s, t;
    private int[][] dp;

    private int sum(int i, String s) {
        int sum = 0; 
        while (i < s.length()){
            sum += (int)s.charAt(i++);
        }
        return sum;
    }

    private int helper(int i, int j) {
        if (i == s.length())
            return sum(j, t);
        
        if (j == t.length())
            return sum(i, s);

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j))
            return dp[i][j] = helper(i + 1, j + 1);

        int left = (int)s.charAt(i) + helper(i + 1, j);
        int right = (int)t.charAt(j) + helper(i, j + 1);

        return dp[i][j] = Math.min(left, right); 
    }

    public int minimumDeleteSum(String s1, String s2) {
        this.s = s1;
        this.t = s2;
        dp = new int[s1.length()][s2.length()];
        
        for (int[] d: dp){
            Arrays.fill(d, -1);
        }

        return helper(0, 0);
    }
}