class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int i: nums){
            total += i;
        }
        int i = 0;
        int max = -1; 
        int target = total - x;
        int sum = 0;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum > target && i <= j ){
                sum -= nums[i];
                i++;
            }
            if(sum == target){
                max = Math.max(max, j - i + 1);
            }
        }
        return max == -1 ? -1 : nums.length - max;

    }
}