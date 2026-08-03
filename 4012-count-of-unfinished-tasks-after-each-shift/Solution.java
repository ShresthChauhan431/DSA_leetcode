class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int[] prefix = new int[tasks.length+1];
        
        for(int i = 0; i<tasks.length; i++){
            prefix[i+1] = tasks[i]+prefix[i];
        }
        int total = prefix[prefix.length-1];
        
        int work = 0;
        int[] res = new int[shifts.length];
        
        for(int i = 0; i < shifts.length; i++){
            work += shifts[i];
            
            if(work >= total) {
                res[i] = 0;
                work = 0;
            }
            
            else{
                int l = 0, h = tasks.length;
                int store = 0;
                while(l <= h){
                    int mid = l+(h-l)/2;
                    if(prefix[mid] <= work){
                        l = mid+1;
                        store = mid;
                    }
                    else{
                        h = mid - 1;
                    }
                }
                res[i] = tasks.length-store;
            }
        }
        return res;
        
    }
}