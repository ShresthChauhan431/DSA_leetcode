class Solution {
    // private int helper(int i, int[] nums, int[] dp){
    //     if(i >= nums.length - 1) return 0;
    //     if(dp[i] != -1) return dp[i];
    //     int ways = 100000;
    //     for(int j = 1; j <= nums[i]; j++){
    //         int jump = 1 + helper(i + j, nums, dp);
    //         ways = Math.min(ways, jump); 
    //     }
    //     return dp[i] = ways;
    // }
    public int jump(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n];

        // Arrays.fill(dp, -1);
        // return helper(0, nums, dp);

        /** Tabulation */
        Arrays.fill(dp, 100000);
        dp[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--){
            for(int j = 1; j <= nums[i]; j++){
                if(i + j < n) {
                    dp[i] = Math.min(dp[i] , 1 + dp[i + j]);
                }
            }
        }
        return dp[0]; 
    }
}