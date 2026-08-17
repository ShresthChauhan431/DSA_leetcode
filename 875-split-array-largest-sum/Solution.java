class Solution {
    public int splitArray(int[] nums, int k) {
        int h = 0;
        int l = 0;

        for(int i: nums){
            l = Math.max(l, i);
            h += i;
        }
        int ans = 0; 
        while(l <= h){
            int mid = l + (h - l) / 2;
            int x = find(mid, nums);
            if(x <= k){
                    ans = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
    private int find(int sum, int[] arr){
        int hi = 0;
        int k = 0;
        for(int i = 0; i < arr.length; i++){
            if(hi + arr[i] > sum){
                hi = 0;
                k++;
            }
            hi += arr[i];
        }
        if(hi > 0) k++;
        return k;
    }
}