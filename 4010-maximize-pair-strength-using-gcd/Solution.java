class Solution {
    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1 ; j < nums.length; j++){
                long mux = 1L * nums[i] * nums[j];
                long g = gcd(nums[i], nums[j]);
                long out = mux/(g * g);
                ans = Math.max(ans, out);
            }
        }
        return ans;
    }
}