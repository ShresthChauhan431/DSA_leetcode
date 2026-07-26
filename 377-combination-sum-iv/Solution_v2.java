class Solution {
    int[] nums;
    int[][] dp;
    public int helper(int i, int target){
        if (target == 0) 
            return 1;

        if (i == nums.length) 
            return 0;

        if (dp[i][target] != -1) 
            return dp[i][target];

        int ans = 0;

        for (int j = 0; j < nums.length; j++) {

            if(target - nums[j] >= 0) {
                ans += helper(i, target - nums[j]);
            }

        }
        return dp[i][target] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;

        dp = new int[nums.length][target + 1];
        for (int[] d: dp) 
            Arrays.fill(d, -1);
        
        return helper(0, target);
    }
}