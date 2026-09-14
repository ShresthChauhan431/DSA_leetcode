class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length; 
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] ^ nums[i];
        }
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            int bit = prefix[n - i - 1];
            int ans = 0;
            for(int j = 0; j < maximumBit; j++){
                if ((bit & (1 << j)) == 0) {
                    ans |= (1 << j);
                }
            }
            arr[i] = ans;
        }
        return arr;
    }
}