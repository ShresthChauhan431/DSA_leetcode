class Solution {
    // private int findDepth(int[] parent, int i, int[] depth) {
    //     if(depth[i] != 0){
    //         return depth[i];
    //     }
        
    // }
    // public int findHeight(int[] parent){
    //     int n = parent.length; 
    //     int[] depth = new int[n];
    //     for(int i = 0; i < n; i++){
    //         findDepth(parent, i, depth);
    //     }
    // }
    public long weightedSum(int[] parent, int[] hi) {
        int n = parent.length; 

        List<List<Integer>> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++){
            
            list.get(parent[i]).add(i);
        }

        int[] depth = new int[n];
        int h = 0;


        int[] arr = new int[n];
        int[] nums = new int[n];

        int t = 0;
        arr[t] = 0;
        nums[t] = 1;
        t++;

        while(t > 0){
            t--;
            int curr = arr[t];
            int d = nums[t];

            depth[curr] = d;
            h = Math.max(h, d);

            for(int next: list.get(curr)) {
                arr[t] = next;
                nums[t] = d + 1;
                t++;
            }
        }
        long total = 0L;

        for(int i = 0 ; i < n; i++) {
            total += (long) hi[i] * (h - depth[i] + 1);
        }
        return total;

        
    }
}