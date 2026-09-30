class Solution {
    class DSU{
        int n;
        int[] parent;
        int[] size;
        public DSU(int n){
            this.n = n; 
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        void union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return;
            if(size[pu] >- size[pv]){
                parent[pv] = pu;
                size[pu] += size[pv];
            }else{
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new int[]{i, j, dist});
            }
        }
        int cost = 0;
        DSU dsu = new DSU(n);
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int x = arr[0];
            int y = arr[1];
            if(dsu.find(x) != dsu.find(y)){
                dsu.union(x, y);
                cost += arr[2];
            }
        }
        return cost;
    }
}