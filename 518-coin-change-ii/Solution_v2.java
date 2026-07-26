class Solution {
    int[] coins;
    int[][] dp;

    public int change(int amount, int[] coins) {

        dp = new int[coins.length][amount + 1];
        this.coins = coins;

        for (int[] i: dp)
            Arrays.fill(i, -1); 

        return helper(amount, 0);
    }

    public int helper(int amount, int i){
        if (amount == 0) 
            return 1; 

        if (amount < 0 || i >= coins.length) 
            return 0;

        if (dp[i][amount] != -1) 
            return dp[i][amount]; 

        int ways = helper(amount - coins[i], i);
        int skip = helper(amount, i + 1); 

        return dp[i][amount] = ways + skip;
    }
}