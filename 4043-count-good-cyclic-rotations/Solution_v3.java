class Solution {
    public int countGoodRotations(int[] nums) {
        long halfSum = 0; 
        long sum = 0; 
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i < n/2) halfSum += nums[i];
            sum += nums[i];
        }
        int count = 0; 
        if(halfSum > sum - halfSum) count++;
        for(int i = 0; i < n - 1; i++){
            halfSum -= nums[i];
            halfSum += nums[(n/2 + i) % n];
            if(halfSum > sum - halfSum) count++;
        }
        return count;
    }
}