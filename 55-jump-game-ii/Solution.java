class Solution {
    private int helper(int i, int[] nums, int[] dp){
        if(i >= nums.length - 1) return 0;
        if(dp[i] != -1) return dp[i];
        int ways = 100000;
        for(int j = 1; j <= nums[i]; j++){
            int jump = 1 + helper(i + j, nums, dp);
            ways = Math.min(ways, jump); 
        }
        return dp[i] = ways;
    }
    public int jump(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }
}