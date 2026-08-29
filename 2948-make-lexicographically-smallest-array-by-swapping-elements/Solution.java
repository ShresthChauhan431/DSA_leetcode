class Solution {
    class DSU {
        int[] parent;
        public DSU (int n){
            parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            if(rootI != rootJ){
                parent[rootI] = rootJ;
            }
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        DSU dsu = new DSU(n);

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        for(int i = 1; i < n; i++){
            if(arr[i][0] - arr[i - 1][0] <= limit){
                dsu.union(arr[i][1], arr[i - 1][1]);
            }
        }

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int root = dsu.find(arr[i][1]);
            map.putIfAbsent(root, new LinkedList<>());
            map.get(root).offer(arr[i][0]);
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int root = dsu.find(i);
            res[i] = map.get(root).poll();
        }
        return res; 
    }
}