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
        // if(nums.length == 1) return true;
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, -1); 
        // boolean ans = helper(0, nums, dp);
        // System.out.println(Arrays.toString(dp));
        // return ans;
        /** Tabulation */
        int n = nums.length;
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for(int i = n - 2; i >= 0; i--){
            for(int j = 1; j <= nums[i]; j++){
                if(i + j >= n-1 || dp[i + j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}