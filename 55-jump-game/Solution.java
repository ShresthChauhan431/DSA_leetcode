class Solution {
    public boolean helper(int i, int[] nums, int[] dp){
        if(i >= nums.length){
            return true;
        }
        if(dp[i] != -1) return dp[i] == 1;
        boolean ans = false;
        for(int j = 1; j <= nums[i]; j++){
            ans = helper(i + j, nums, dp);
        }
        if(ans){
            dp[i] = 1;
        }else{
            dp[i] = 0;
        }
        return ans;
    }
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1); 
        return helper(0, nums, dp);
    }
}