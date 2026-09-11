class Solution {
    private int helper(int i, int mask, int[] nums, int n){
        if(mask == ((1<<n) - 1)) return 1;
        int ans = 0; 
        for(int j = 0; j < n; j ++){
            if(nums[j] % i != 0 && i % nums[j] != 0) continue;
            if((mask & (1 << j)) != 0) continue;
            int nmask = mask | (1 << j);
            ans += helper(i + 1, nmask, nums, n);
        }
        return ans;
    }
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        int mask = 0; 
        return helper(1, mask, nums, n);
    }
}