class Solution {
    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length; 

        long[] prefix = new long[n + 1];

        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 == 0) {
                prefix[i + 1] = prefix[i] + b;
            } else {
                prefix[i + 1] = prefix[i] - a;
            }
        }
        long[] temp =  new long[n + 1];

        return mergeSort(prefix, temp, 0, n);
    }
    long mergeSort(long[] prefix, long[] temp, int l, int h){
        if(l >= h)
            return 0;

        int mid = l + (h - l) / 2;

        long count = 0;

        count += mergeSort(prefix, temp, l, mid);
        count += mergeSort(prefix, temp, mid + 1, h);
        count += merge(prefix, temp, l, mid, h);

        return count;
    }
    long merge(long[] prefix, long[] temp, int l, int mid, int h){
        int i = l;
        int j = mid + 1; 
        int k = l;
        long count = 0;

        while(i <= mid && j <= h){
            if(prefix[i] >= prefix[j]) {
                count += (mid - i + 1);
                temp[k++]  = prefix[j++];
            }else {
                temp[k++]  = prefix[i++];
            }
        }

        while(i <= mid)
            temp[k++] = prefix[i++];

        while(j <= h){
            temp[k++] = prefix[j++];
        }

        for(i = l; i <= h; i++){
            prefix[i] = temp[i];
        }

        return count;
    }
}