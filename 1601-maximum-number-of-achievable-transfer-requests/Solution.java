class Solution {
    int res = 0;

    private void helper(int i, int[][] req, int count, int[] arr) {
        if (i == req.length) {
            boolean flag = false;
            //arr should be zero 
            for (int j : arr) {
                if (j != 0) {
                    flag = true;
                    break;
                }
            }
            //check only when resultant is zero 
            if(!flag){
                res = Math.max(res, count);
            }
            return;
        }
        int from = req[i][0];
        int to = req[i][1];
        // update the status
        arr[from]--;
        arr[to]++;
        // call recursion and get element
        helper(i + 1, req, count + 1, arr);
        // backtrack
        arr[from]++;
        arr[to]--;
        // call recursion and skip the element
        helper(i + 1, req, count, arr);
    }

    public int maximumRequests(int n, int[][] req) {
        int[] arr = new int[n];
        helper(0, req, 0, arr);
        return res;
    }
}