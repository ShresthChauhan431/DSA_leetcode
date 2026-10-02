class Solution {
    int[] dist;
    int[] low;
    List<List<Integer>> list;
    int time = 0;
    public void helper(int src, int parent, List<List<Integer>> adj, boolean[] vis){
        vis[src] = true;
        dist[src] = low[src] = ++time;
        for(int next: adj.get(src)){
            if(next == parent) continue;
            if(!vis[next]){
                helper(next, src, adj, vis);
                low[src] = Math.min(low[src], low[next]);
                if(low[next] > dist[src]){
                    list.add(List.of(src, next)); // mtlb yha koi bhi dusra rasta nhi mila next ko toh iska low update hi nhi ho paya isliye ye. iss se current time ke equal ho gya jo har baar ek se badhta ja rha hai 
                
                }
            }else if(next != parent){
                low[src] = Math.min(dist[next], low[src]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
       list = new ArrayList<>(); 
       dist = new int[n];
       low = new int[n];
       List<List<Integer>> adj = new ArrayList<>(); 
       for(int i = 0; i < n; i++){
        adj.add(new ArrayList<>());
       }

       for(List<Integer> i: connections){
        int p = i.get(0);
        int node = i.get(1);
        adj.get(p).add(node);
        adj.get(node).add(p);
       }
       boolean[] vis = new boolean[n];
       Arrays.fill(vis, false);
       helper(0, 0, adj, vis);
       return list;
    }
}