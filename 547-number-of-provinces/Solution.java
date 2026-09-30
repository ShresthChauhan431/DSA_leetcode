class Solution {
    static class DSU{
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
            if(size[pu] >= size[pv]){
                parent[pv] = pu;
                size[pu] += size[pv];
            }else{
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }
    public int findCircleNum(int[][] arr) {
        int n = arr.length; 
        DSU dsu = new DSU(n);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1){
                    dsu.union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(dsu.find(i));
        }
        return set.size();
    }
}