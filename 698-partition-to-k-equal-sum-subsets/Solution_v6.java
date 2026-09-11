class Solution {
    int[] dp;
    private void reverse(int[] a){
        int l=0, r=a.length-1;
        while(l<r){
            int temp=a[l];
            a[l]=a[r];
            a[r]=temp;
            l++; r--;
        }
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // Arrays.sort(nums);
        // reverse(nums);
        int sum = 0, max = 0;
        for(int i: nums){
            max = Math.max(max, i);
            sum += i;
        }
        int req = sum / k;
        if(sum%k != 0 || max > req)return false;
        int s = (1 << nums.length) - 1;
        dp = new int[s + 1];
        Arrays.fill(dp, -1);
        int mask = 0;
        return helper(nums, 0, k, req, 0, mask);
    }
    public boolean helper(int[] nums,int i, int k, int tar,int curr,int mask){
        if(k==1 || (mask == (1 << nums.length) - 1)) return true;
        if(dp[mask] != -1) return dp[mask] == 1;
        if(curr == tar){
            if(helper(nums,0,k - 1,tar,0,mask)){
                dp[mask]= 1;
                return true;
            }else{
                dp[mask] = 0;
                return false;
            }
        }
        for(int j=i; j<nums.length; j++){
            if(((mask & (1 << j)) == 0) && (curr + nums[j] <= tar)){
                int nmask = mask | (1 << j);
                if(helper(nums, j + 1, k, tar, curr + nums[j], nmask)){
                    dp[nmask] = 1;
                    return true;
                }
            }
        }
        dp[mask] = 0;
        return false;
    }
}