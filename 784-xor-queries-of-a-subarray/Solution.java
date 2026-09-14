class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = prefix[queries[i][1] + 1] ^ prefix[queries[i][0]];
        }
        return ans;
    }
}