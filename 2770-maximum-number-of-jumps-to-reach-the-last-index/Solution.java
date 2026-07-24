class Solution {
    int[] nums;
    int[] dp;
    int target;
    public int maximumJumps(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return helper(0);
    }

    private int helper(int i) {

        if(i == nums.length - 1) 
            return 0;

        if(dp[i] != Integer.MIN_VALUE) return dp[i];
        int max = -1;

        for (int j = i + 1; j < nums.length; j++) {

            int diff = nums[j] - nums[i];

            if(diff >= -target && diff <= target) {
                int jumps = helper(j);
                if(jumps != -1) 
                    max = Math.max(max, jumps + 1);
            }
        }

        return dp[i] = max;
    }
}