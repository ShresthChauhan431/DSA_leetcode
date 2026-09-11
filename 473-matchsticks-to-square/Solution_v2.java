class Solution {
    int[] dp;
    private boolean helper(int k, int curr, int tar, int mask, int[] nums){
        if(k == 0 || mask == (1 << nums.length) - 1) return true;
        
        if(dp[mask] != -1) return dp[mask] == 1;
        if(curr == tar){
            if(helper(k - 1, 0, tar, mask, nums)){
                dp[mask] = 1;
                return true;
            }else{
                dp[mask] = 0;
                return false;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if((mask & (1 << i)) == 0 && curr + nums[i] <= tar){
                int nmask = mask | (1 << i);
                if(helper(k, curr + nums[i], tar, nmask, nums)){
                    dp[nmask] = 1;
                    return true;
                }
            }
        }
        dp[mask] = 0;
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        long sum = 0; 
        int max = 0;
        for(int i: matchsticks){
            sum += i;
            max = Math.max(max, i);
        }
        int k = 4;
        int req = (int)(sum / k);
        if(sum % k != 0 || max > req) return false;
        int mask = 0; 
        int n = (1 << matchsticks.length);
        dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(k, 0, req, mask, matchsticks);
    }
}