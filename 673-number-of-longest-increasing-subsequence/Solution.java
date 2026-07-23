class Solution {

    class Pair {
        int len;
        int count;

        Pair(int len, int count) {
            this.len = len;
            this.count = count;
        }
    }

    Pair[][] dp;
    int max = 0;


    private Pair helper(int i, int j, int[] nums){
        if (i == nums.length)
            return new Pair(0, 1);
        
        if (dp[i][j + 1] != null)
            return dp[i][j + 1];

        Pair notTake = helper(i + 1, j, nums);

        Pair take = new Pair(0, 0);

        if (j == -1 || nums[i] > nums[j]) {
            Pair next = helper(i + 1, i, nums);
            take.len = next.len + 1;
            take.count = next.count;
        }

        if (take.len > notTake.len)
            return dp[i][j + 1] = take;

        if (take.len < notTake.len)
            return dp[i][j + 1] = notTake;

        return dp[i][j + 1] = new Pair(take.len, take.count + notTake.count);
    }


    public int findNumberOfLIS(int[] nums) {
        int n = nums.length; 
        dp = new Pair[n][n + 1];
        
        return helper(0, -1, nums).count;
        
    }
}