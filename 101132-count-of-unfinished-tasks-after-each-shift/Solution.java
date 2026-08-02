class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length; 
        int m = shifts.length;

        long[] prefix = new long[n + 1];
        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + tasks[i];
        }

        long time = prefix[n];
        long work = 0;
        int[] res = new int[m];

        for(int j = 0; j < m; j++){
            work += shifts[j];

            if(work >= time){
                res[j] = 0;
                work = 0;
            }else{
                int l = 0, h = n; 
                int k = 0; 
                while(l <= h){
                    int mid = l + (h - l) / 2;
                    if(prefix[mid] <= work){
                        k = mid;
                        l = mid + 1;
                    }
                    else {
                        h = mid - 1;
                    }
                }
                res[j] = n - k;
            }
        }
        return res;
    }
}