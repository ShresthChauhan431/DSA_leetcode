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
            if(size[pu] >= size[pv]){
                parent[pv] = pu;
                size[pu] += size[pv];
            }else{
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        int[] arr = new int[2];
        for(int i = 0; i < edges.length; i++){
            if(dsu.find(edges[i][0] - 1) != dsu.find(edges[i][1] - 1)){
                dsu.union(edges[i][0] - 1, edges[i][1] - 1);
            }else{
                arr = edges[i];
            }
        }
        return arr;
    }
}