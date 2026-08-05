class Solution {
    // Set<Integer> set;

    void dfs(List<List<Integer>> list, int src, boolean[] visit) {
        visit[src] = true;
        for (int next : list.get(src)) {
            if (!visit[next]) {
                dfs(list, next, visit);
            }
        }
    }

    // void dfs2(List<List<Integer>> list, int src, boolean[] visit) {
    //     set.add(src);
    //     visit[src] = false;
    //     for(int next: list.get(src)){
    //         if(visit[next]) {
    //             dfs2(list, next, visit);
    //         }
    //     }
    // } 
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
       List<List<Integer>> list = new ArrayList<>(); 
       for(int i = 0; i < n; i++) {
        list.add(new ArrayList<>());
       }
       for(int[] i: invocations) {
            int u = i[0];
            int v = i[1];
            list.get(u).add(v);
       }
       boolean[] visit = new boolean[n];
       dfs(list, k, visit);
       
       for(int[] i: invocations) {
            int u = i[0];
            int v = i[1];
            if(!visit[u] && visit[v]){
                List<Integer> res = new ArrayList<>(); 
                for(int j = 0; j < n; j++){
                    res.add(j);
                }
                return res;
            }
       }
       List<Integer> res = new ArrayList<>(); 
       for(int i = 0; i < n; i++){
        if(!visit[i])
            res.add(i);
       }
        return res;
    }
}