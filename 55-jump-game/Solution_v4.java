class Solution {
    public boolean helper(int i, int[] nums, int[] dp){
        if(i >= nums.length - 1){
            return true;
        }
        if(dp[i] != -1) return dp[i] == 1;
        for(int j = 1; j <= nums[i]; j++){
            if(helper(i + j, nums, dp)){
                dp[i] = 1;
                return true;
            }
        }
        
        dp[i] = 0;
        
        return false;
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1); 
        return helper(0, nums, dp);
    }
}