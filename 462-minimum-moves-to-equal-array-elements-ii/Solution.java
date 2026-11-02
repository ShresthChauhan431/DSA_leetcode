class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int med = 0;
        int n = nums.length;
        if(nums.length % 2 == 0){
            med = (nums[n / 2] + nums[(n + 1) / 2]) / 2;
        }else{
            med = nums[n/2];
        }
        int ans = 0;
        for(int i: nums){
            ans += Math.abs(i - med);
        }
        return ans;
    }
}