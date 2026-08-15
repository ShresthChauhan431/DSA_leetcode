class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean flag = false;
        int n = nums.length; 
        for(int i: nums){
            xor ^= i;
            if(i != 0) flag = true;
        }
        if(xor != 0) return n;
        else if(flag) return n - 1;
        return 0; 
    }
}