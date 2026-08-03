class Solution {
    int[][] dp;
    private boolean helper(int i, int j, int[] nums, long p1, long p2) {
        if (i > j) 
            return p1 >= p2;
        if(dp[i][j] != -1) return dp[i][j] == 1;
        
        if ((nums.length - (j - i + 1)) % 2 == 0) {
            boolean ans = helper(i + 1, j, nums, p1 + nums[i], p2)
                    || helper(i, j - 1, nums, p1 + nums[j], p2);
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }
        else {
            boolean ans = helper(i + 1, j, nums, p1, p2 + nums[i])
                    && helper(i, j - 1, nums, p1, p2 + nums[j]);
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }
    }

    public boolean predictTheWinner(int[] nums) {
        dp = new int[nums.length + 1][nums.length + 1];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        return helper(0, nums.length - 1, nums, 0L, 0L);
    }
}