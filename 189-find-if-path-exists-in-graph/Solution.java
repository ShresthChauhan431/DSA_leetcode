class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, false);
        arr[source] = true;
        q.offer(source);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next: adj.get(node)){
                if(!arr[next]){
                    arr[next] = true;
                    q.offer(next);
                }
            }
        }
        return arr[destination];
    }
}