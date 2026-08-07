class Solution {
    private void dfs(int i, List<List<Integer>> adj, boolean[] visit){
        visit[i] = true;
        for(int next: adj.get(i))
            if(!visit[next])
                dfs(next, adj, visit);
        
    }
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> list = new ArrayList<>();
        int e = connections.length; 
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] i: connections){
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        int count = 0; 
        boolean[] visit = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                count++;
                dfs(i, list, visit);
            }
        }
        int req = count - 1; 
        if(e >= n - 1 ) return req;
        return -1;
    }
}