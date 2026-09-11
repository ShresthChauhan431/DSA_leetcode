class Solution {
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
        Arrays.sort(nums);
        reverse(nums);
        int sum = 0, max = 0;
        for(int i: nums){
            max = Math.max(max, i);
            sum += i;
        }
        if(sum%k != 0 || max > sum / k)return false;
        int mask = 0;
        return helper(nums,0,k, sum/k, 0, mask);
    }
    public boolean helper(int[] nums,int i, int k, int tar,int curr,int mask){
        if(k==1) return true;
        if(curr == tar)return helper(nums,0,k - 1,tar,0,mask);
        for(int j=i; j<nums.length; j++){
            if(((mask & (1 << j)) == 0) && (curr + nums[j] <= tar)){
                int nmask = mask | (1 << j);
                if(helper(nums, j + 1, k, tar, curr + nums[j], nmask)) return true;
            }
        }
        return false;
    }
}