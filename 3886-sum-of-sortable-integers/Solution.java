class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int total = 0;
        for(int k = 1; k <= nums.length; k++){
            if(n % k == 0) {
                if(check(nums, sorted, n, k)){
                    total += k;
                }
            }
        }
        return total;
    }

    private boolean check(int[] nums, int[] sorted, int n, int k) {
        int block = n / k;
        for(int i = 0; i < block; i++){
            int st = i * k;
            if(!cyclic(nums, sorted, st, k))
                return false;
        }
        return true;
    }

    private boolean cyclic(int[] nums, int[] sorted, int st, int k){
        int[] lps = new int[k];

        for(int i = 1, len = 0; i < k;){
            if (sorted[st + i] == sorted[st + len]){
                lps[i++] = ++len;
            }else if (len > 0){
                len = lps[len - 1];
            }else{
                lps[i++] = 0;
            }
        }
        int i = 0, j = 0;
        while(i < 2 * k - 1){
            int value = nums[st + (i % k)];
            if(value == sorted[st + j]){
                i++;
                j++;
                if(j == k){
                    return true;
                }
            }else if (j > 0){
                j = lps[j - 1];
            }else{
                i++;
            }
        }

        return false;
    }
}