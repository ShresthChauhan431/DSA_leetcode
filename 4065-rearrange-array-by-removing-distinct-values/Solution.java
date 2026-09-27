class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] freq = new int[101];
        for(int i: nums){
            freq[i]++;
        }
        int i = 0;
        int[] arr = new int[nums.length]; 
        while(i < nums.length){
            for(int j = 0; j < 101; j++){
                if(freq[j] > 0){
                    arr[i++] = j;
                }
            }
            for(int j = 0; j < 101; j++){
                if(freq[j] > 0)
                    freq[j]--;
            }
        }
        return arr;
    }
}