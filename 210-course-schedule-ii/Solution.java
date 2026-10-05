class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<Integer> list = new ArrayList<>(); 
        int[] arr = new int[n];
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: pre){
            adj.get(i[1]).add(i[0]);
        }
        for(List<Integer> i: adj){
            for(int j: i){
                arr[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0; i < n; i++){
            if(arr[i] == 0)
                q.offer(i);
        }
        while(!q.isEmpty()){
            int x = q.poll();
            list.add(x);
            for(int next: adj.get(x)){
                arr[next]--;
                if(arr[next] == 0){
                    q.add(next);
                }
            }
        }
        if(list.size() != n) return new int[]{};
        
        for(int i = 0; i < n; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}