class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length; 
        Arrays.sort(nums);
        if ((nums[n - 1] > 0 && nums[n - 2] > 0 && nums[n - 3] > 0) || (nums[n - 1] > 0 && nums[n - 2] < 0)){
            return nums[n - 1] * nums[n - 2] * nums[n - 3];
        }else {
            return nums[0] * nums[1] * nums[2];
        }
    }
}