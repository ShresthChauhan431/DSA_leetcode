class Solution {
    public int resilientSubarray(int[] nums, int k) {
        return helper(nums, k, 0);
    }
    
    private int helper(int[] nums, int k, int i){
        if(i >= nums.length) return 0;
        
        int r = nums[i] % k;
        int l = length(nums, k, i, r);
        
        int valid;
        if(r == 0){
            valid = l;
        }else{
            int x = k / gcd(r, k);
            valid = 1 + ((l - 1) / x) * x;
        }
        return Math.max(valid, helper(nums, k, i + l));
    }
    
    int length(int[] nums, int k, int i, int r){
        if (i >= nums.length) return 0;
        if (nums[i] % k != r) return 0;
        return 1 + length(nums, k, i + 1, r);
    }
    
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}