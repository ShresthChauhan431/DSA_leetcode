class Solution {

    int min = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] child = new int[k];
        helper(0, cookies, child);
        return min;
    }
    private void helper(int i, int[] nums, int[] child){
        if(i == nums.length) {
            int max = 0;
            for(int ch: child)
                max = Math.max(ch, max);

            min = Math.min(max, min);
            return;
        }
        int cookie = nums[i];    
        for(int j = 0; j < child.length; j++){
            child[j] += cookie;
            helper(i + 1, nums, child);
            child[j] -= cookie;
        }
    }
}