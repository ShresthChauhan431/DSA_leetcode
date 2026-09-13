class Solution {
    public int[] countBits(int n) {
        int[] arr =new int[n + 1];
        for(int i = 1; i <= n; i++){
            int d = i >> 1;
            if((i & 1 )== 1)
                arr[i] = arr[d] + 1;
            else 
                arr[i] = arr[d];
        }
        return arr;
    }
}