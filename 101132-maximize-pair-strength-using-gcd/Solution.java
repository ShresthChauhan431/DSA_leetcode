class Solution {
    int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
    public long maxPairStrength(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int x = (nums[i] * nums[j]) / (gcd(nums[i], nums[j]) * gcd(nums[i], nums[j]));
                max = Math.max(x, max);
            }
        }
        return max;
    }
}