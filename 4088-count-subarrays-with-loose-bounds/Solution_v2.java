class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int i = 0; 
        int j = 0; 
        long ans = 0;
        while(j < nums.length){
            if(nums[j] > maxK || nums[j] < minK){
                i = j + 1;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}