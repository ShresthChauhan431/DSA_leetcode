class Solution {
    int[] coins;
    int[][] dp;
    public int helper(int i, int target){
        if (target == 0) return 1;
        if (i == coins.length) return 0;
        if (dp[i][target] != -1) return dp[i][target];
        int ans = 0;
        for (int j = i; j < coins.length; j++){
            if(target - coins[j] >= 0){
                ans += helper(j, target - coins[j]);
            }
        }
        return dp[i][target] = ans;
    }
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        this.coins = coins;
        dp = new int[coins.length][amount + 1];
        for (int[] d: dp)
            Arrays.fill(d, -1);
        return helper(0, amount);
    }
}