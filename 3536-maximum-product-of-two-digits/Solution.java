class Solution {
    public int maxProduct(int n) {
        int[] arr = new int[10];
        int k = 0;
        while(n > 0){
            arr[k++] = n % 10;
            n /= 10;
        }

        int max = 0;
        
        for(int i = 0; i < 9; i++)
            for(int j = i + 1; j < 10; j++)
                max = Math.max(arr[j] * arr[i], max);

        return max;
    }
}